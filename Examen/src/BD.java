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

public class BD extends Entrada_Salida{
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
        String sql = "INSERT INTO  VALUES(?, ?, ?, ?)";
        sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, devolverInt());;
        sentencia.setString(2, devolverString());
        sentencia.setString(3, devolverString());
        sentencia.setDouble(4, devolverDouble());
        sentencia.executeUpdate();
    }

    public static void actualizarBD() throws Exception{
        String sql = "UPDATE SET ? = ? WHERE  = ?";
        sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, devolverString());
        sentencia.executeUpdate();
    }

    public static void eliminarBD() throws Exception{
        String sql = "DELETE FROM carta WHERE n_carta = ?";
        sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, devolverInt());
        sentencia.executeQuery();
    }

    public static void registrarNuevaCartaHashMap(int nCarta) throws Exception{
        ResultSet rs = st.executeQuery("SELECT ca.n_carta, ca.nombre, ca.categoria, ca.precio, ca.stock, l.fuerza, l.resistencia, l.velocidad, l.carisma FROM carta ca LEFT JOIN luchador l ON ca.n_carta = l.n_carta WHERE ca.n_carta = " + nCarta);
        while (rs.next()) {
            
        }
    }

    public static void idAutogenerado() throws Exception{
        st = conexion.createStatement();

        st.executeUpdate("CREATE TABLE EMP_PHONE (EMPNO CHAR(6), PHONENO CHAR(4), " + "IDENTCOL INTEGER GENERATED ALWAYS AS IDENTITY)"); 
        sentencia =conexion.prepareStatement("INSERT INTO EMP_PHONE (EMPNO, PHONENO) " + "VALUES ('000010', '5555')", Statement.RETURN_GENERATED_KEYS);
                                      
        rs = st.getGeneratedKeys(); 
                                      
        while (rs.next()) {
            java.math.BigDecimal idColVar = rs.getBigDecimal(1);     
                                                
            System.out.println("automatically generated key value = " + idColVar);
        }
        rs.close();
        st.close();
    }
}