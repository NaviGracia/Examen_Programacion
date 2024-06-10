/**
* Clase de entrada|salida de valores
* @author Ivan García
* @version 1.0, 2024/04/22
*/
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * execute() -> DDL (Crear Tablas, etc) Returns BOOLEAN
 * executeUpdate() -> Insert, Update, Delete Returns INTEGER
 * executeQuery() -> SELECT ... Returns RS
 */

public class BD extends Entrada_Salida{
    public static Connection conexion = null;

    public Connection conectarBD() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");   
        } catch (Exception e) {
            System.out.println("Error al registrar el driver");
        }

        try {
            System.out.println("Inserte el nombre de usuario para iniciar sesión en la base de datos:");
            String usuario = devolverString();
            System.out.println("Inserte la contraseña del usuario:");
            String contrasenya = devolverString();
            System.out.println("Inserte la ruta a la Base de Datos (jdbc:postgresql: está por defecto):");
            String ruta = devolverString();
            conexion = DriverManager.getConnection("jdbc:postgresql:" + ruta, usuario, contrasenya); /* //localhost:5432/Biblioteca */ 
        } catch (SQLException e) {
            throw new ExcepcionFalloBD("Fallo en la conexion a la BD");
        }
        return conexion;
    }
    
    public ArrayList<Libro> cargarBDaArrayList() throws SQLException{
        ArrayList<Libro> libros = new ArrayList<>();
        PreparedStatement st = conexion.prepareStatement("SELECT * FROM librogarcia WHERE autor != 'censurado'");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            libros.add(new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
        }
        return libros;
    }

    public void crearTabla() throws SQLException{
        String sql = "CREATE TABLE librogarcia(id serial, titulo varchar(25) not null, autor varchar(25) not null, any_publicacion int, genero varchar(25))";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.execute();
    }

    public int insertarLibro() throws SQLException{
        String sql = "INSERT INTO librogarcia(titulo, autor, any_publicacion, genero) VALUES(?, ?, ?, ?)";
        PreparedStatement stTemporal = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        System.out.println("Introduzca el titulo del libro:");    
        stTemporal.setString(1, devolverString());
        System.out.println("Introduzca el autor del libro:");      
        stTemporal.setString(2, devolverString());
        System.out.println("Introduzca el año de publicación del libro:");    
        stTemporal.setInt(3, devolverInt());
        System.out.println("Introduzca el genero del libro:");    
        stTemporal.setString(4, devolverString());

        stTemporal.executeUpdate();
        //Solo se autogenera un ID
        ResultSet clavesCreadas = stTemporal.getGeneratedKeys(); 
        clavesCreadas.next();
        return clavesCreadas.getInt("id");
    }

    public void menuActualizarBD() throws SQLException{
        System.out.println("Introduzca el id del libro:");
        int id = devolverInt();
        System.out.println("Que desea modificar:" + "\n 1. Titulo" + "\n 2. Autor" + "\n 3. Año de Publicación" + "\n 4. Genero");
        switch (devolverInt()) {
            case 1:
                actualizarLibro("titulo", id);
                break;
            case 2:
                actualizarLibro("autor", id);
                break;
            case 3:
                actualizarLibro("any_publicacion", id);
                break;
            case 4:
                actualizarLibro("genero", id);
                break;
            default:
                System.out.println("Nº introducido incorrecto");
                break;
        } 
    }

    private void actualizarLibro(String atributo, int id) throws SQLException{
        String sql = "";
        System.out.println("Introduzca el nuevo dato");
        if (atributo.equals("any_publicacion")) {
            sql = "UPDATE SET " + atributo + " = " + devolverInt() + " WHERE id = " + id;
        }else{
            sql = "UPDATE SET " + atributo + " = " + devolverString() + " WHERE id = " + id;
        }
        Statement st = conexion.prepareStatement(sql);
        st.executeQuery(sql);
    }

    public void eliminarLibro(int idEliminar) throws Exception{
        String sql = "DELETE FROM librogarcia WHERE id = ?";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setInt(1, idEliminar);
        st.executeQuery();

    }

    public void consultarBD() throws Exception{
        PreparedStatement st = null; 

        st = conexion.prepareStatement("SELECT * FROM librogarcia WHERE autor = ?");
        System.out.println("Introduzca el autor a buscar:");
        st.setString(1, devolverString());   

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5));
        }
    }

    public void cerrarBD(){
        try {
            conexion.close();
            conexion = null;
        } catch (Exception e) {
            System.out.println("Fallo cerrando la conexión a la BD");
        }
    }
}