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

/*
 * execute() -> DDL (Crear Tablas, etc) Returns BOOLEAN
 * executeUpdate() -> Insert, Update, Delete Returns INTEGER
 * executeQuery() -> SELECT ... Returns RS
 */

public class BD extends Entrada_Salida{
    public static Connection conexion = null;

    public Connection cargarBD(String nombreBD, String usuario, String contrasenya) throws Exception{
        try {
            Class.forName("org.postgresql.Driver");   
        } catch (Exception e) {
            System.out.println("Error al registrar el driver");
        }

        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nombreBD, usuario, contrasenya);  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }   
    
    public static void crearTabla(){
        String vacio = "CREATE TABLE prueba (column1 int);";
        PreparedStatement st;
        try {
            st = conexion.prepareStatement(vacio);
            st.execute();
        } catch (Exception e) {
            System.out.println("Fallo en la creación de la tabla: " + e);
        }
    }

    public static void cerrarBD(){
        try {
            conexion.close();
            conexion = null;
        } catch (Exception e) {
            System.out.println("Fallo cerrando la conexión a la BD");
        }
    }

    public static void insertarBD() throws Exception{
        String sql = "INSERT INTO  VALUES(?, ?, ?, ?)";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setInt(1, devolverInt());;
        st.setString(2, devolverString());
        st.setString(3, devolverString());
        st.setDouble(4, devolverDouble());
        st.executeUpdate();
    }

    public static void actualizarBD() throws Exception{
        String sql = "UPDATE SET ? = ? WHERE  = ?";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setString(1, devolverString());
        st.executeUpdate();
    }

    public static void eliminarBD() throws Exception{
        String sql = "DELETE FROM carta WHERE n_carta = ?";
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setInt(1, devolverInt());
        st.executeQuery();
    }

    public static void registrarNuevaCartaHashMap(int nCarta) throws Exception{
        PreparedStatement st = conexion.prepareStatement("SELECT ca.n_carta, ca.nombre, ca.categoria, ca.precio, ca.stock, l.fuerza, l.resistencia, l.velocidad, l.carisma FROM carta ca LEFT JOIN luchador l ON ca.n_carta = l.n_carta WHERE ca.n_carta = " + nCarta);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            
        }
    }


    public static void idAutogenerado() throws Exception{
        String sql = "INSERT INTO ? (Atributos) VALUES(?, ?)";
        /*El id autogenerado no se especifica en el values */
        PreparedStatement stTemporal = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
        stTemporal.setString(1, /*Atributo */);
        stTemporal.setString(2, /*Atributo */);

        int filas = stTemporal.executeUpdate();
        //Solo se autogenera un ID
        ResultSet clavesCreadas = stTemporal.getGeneratedKeys(); 
        clavesCreadas.next();
        //Asignamos el id al objeto de java
        object.setID(clavesCreadas.getInt("identificador"));
    }
}