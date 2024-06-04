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

public class App extends Entrada_Salida{
    public static void main(String[] args) throws Exception {
        //Conectar BD
        BD bd = new BD();
        try {
            System.out.println(bd.cargarBD("Supercard", "dam", "dam"));
        } catch (Exception e) {
            System.out.println("Error en la carga de la BD: " + e);
        }

        System.out.println("Menú: " + "\n 1. " + "\n 2. " + "\n 3. " + "\n 4. ");

        switch (bd) {
            case value:
                
                break;
        
            default:
                break;
        }
    }
}
