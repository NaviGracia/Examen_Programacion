/**
* Clase de entrada|salida de valores
* @author Ivan García
* @version 1.0, 2024/04/22
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {
    public static Connection conexion = null;
    public static Statement st = null;
    public static PreparedStatement sentencia = null;
    public static ResultSet rs = null;

    public BD(){}

    public String cargarBD(String nombreBD, String usuario, String contrasenya) throws Exception{
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nombreBD, usuario, contrasenya);
        st = conexion.createStatement();
        return "BD cargada.";
    }    

    public static void insertarBD() throws Exception{
        String sql = "INSERT INTO  VALUES())";
        st = conexionexion.prepareStatement(sql);
        /*
        st.setInt(1, l.getN_carta());
        st.setString(2, l.getNombre());
        st.setString(3, l.getCategoria());
        st.setDouble(4, l.getPrecio());
        st.executeUpdate();
        */
    }

    public static void actualizarBD(String atributo, int cartaActualizar) throws Exception{
        String sql = "UPDATE SET ? = ? WHERE  = ?";
        st = conexionexion.prepareStatement(sql);
        //st.setString(1, atributo);
    }

    public static void eliminarBD(){
        st = null;
        String sql = "DELETE FROM carta WHERE n_carta = ?";
        st = conexionexion.prepareStatement(sql);
        int n_carta_eliminar = recibirNumCarta();
        st.setInt(1, n_carta_eliminar);
        st.executeQuery();
    }

    public static void registrarNuevaCartaHashMap(int nCarta) throws Exception{
        ResultSet rs = st.executeQuery("SELECT ca.n_carta, ca.nombre, ca.categoria, ca.precio, ca.stock, l.fuerza, l.resistencia, l.velocidad, l.carisma FROM carta ca LEFT JOIN luchador l ON ca.n_carta = l.n_carta WHERE ca.n_carta = " + nCarta);
        while (rs.next()) {
            
        }
    }

    public static void idAutogenerado(){
        String query = "INSERT INTO ....";
        PreparedStatement preparedStatement = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setXXX(1, VALUE); 
        preparedStatement.setXXX(2, VALUE); 
        preparedStatement.executeUpdate();  

        ResultSet rs = preparedStatement.getGeneratedKeys();  
        int key = rs.next() ? rs.getInt(1) : 0;

        if(key!=0){
            System.out.println("Generated key="+key);
        }
    }
}