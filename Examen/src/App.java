/**
* Codigo main
*
* @author Ivan García
* @version 1.0, 2024/02/5
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static Connection conexion = null;
    public static Statement st = null;
    public static PreparedStatement sentencia = null;

    public static void insertarBD() throws Exception{
        String sql = "INSERT INTO  VALUES())";
        sentencia = conexion.prepareStatement(sql);
        /*
        sentencia.setInt(1, l.getN_carta());
        sentencia.setString(2, l.getNombre());
        sentencia.setString(3, l.getCategoria());
        sentencia.setDouble(4, l.getPrecio());
        sentencia.executeUpdate();
        */
    }

    public static void actualizarBD(String atributo, int cartaActualizar) throws Exception{
        String sql = "UPDATE SET ? = ? WHERE  = ?";
        sentencia = conexion.prepareStatement(sql);
        //sentencia.setString(1, atributo);
    }

    public static void eliminarBD(){
        sentencia = null;
        String sql = "DELETE FROM carta WHERE n_carta = ?";
        sentencia = conexion.prepareStatement(sql);
        int n_carta_eliminar = recibirNumCarta();
        sentencia.setInt(1, n_carta_eliminar);
        sentencia.executeQuery();
    }

    public static void registrarNuevaCartaHashMap(int nCarta) throws Exception{
        ResultSet rs = st.executeQuery("SELECT ca.n_carta, ca.nombre, ca.categoria, ca.precio, ca.stock, l.fuerza, l.resistencia, l.velocidad, l.carisma FROM carta ca LEFT JOIN luchador l ON ca.n_carta = l.n_carta WHERE ca.n_carta = " + nCarta);
        while (rs.next()) {
            
        }
    }
    public static void main(String[] args) throws Exception {
    //Conectar BD
    try {
        Class.forName("org.postgresql.Driver");
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("Error en registro driver");
    }
    
    conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Supercard", "dam", "dam");
    st = conexion.createStatement();
    }
}
