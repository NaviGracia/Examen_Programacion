/**
* Codigo main
*
* @author Ivan García
* @version 1.0, 2024/02/5
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class App extends Entrada_Salida{
    static BD bd = new BD();
    static Connection conexion;
    static ArrayList<Libro> libros = new ArrayList<>();
    
    public static void insertarArrayList(int id) throws SQLException{
        PreparedStatement st = conexion.prepareStatement("SELECT * FROM librogarcia WHERE id = " + id);
        ResultSet rs = st.executeQuery();
        rs.next();
        libros.add(new Libro(id, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
    }

    public static void mostrarLibros(){
        for (Libro l : libros) {
            System.out.println(l.toString());
        }
    }
        public static void main(String[] args) throws Exception {
        try {
            conexion = bd.conectarBD();
            libros = bd.cargarBDaArrayList();
        } catch (SQLException e) {
            System.out.println("Error en la carga de la BD: " + e);
        }

        int eleccion = 0;
        do {    
            System.out.println("Menú: " + "\n 1. Añadir Libro " + "\n 2. Añadir 2 Libros" + "\n 3. Actualizar un Libro" + "\n 4. Eliminar Libro" + 
            "\n 5. Consultar libros por autor" + "\n 6. Consultar todos los libros" + "\n 7. Salir" + "\n Que desea realizar?:");
            eleccion = devolverInt();
            switch (eleccion) {
                case 1:
                    int id = bd.insertarLibro();
                    System.out.println("ID autogenerado del libro: " + id);
                    insertarArrayList(id);
                    break;
                case 2:
                    
                    break;
                case 3:
                    bd.menuActualizarBD();
                    break;
                case 4:
                    System.out.println("Inserte el id del libro a eliminar:");
                    int idEliminar = devolverInt();
                    bd.eliminarLibro(idEliminar);
                    for (Libro l : libros) {
                        if (l.getId()==idEliminar) {

                            libros.remove(l);
                        }
                    }
                    break;
                case 5:
                    bd.consultarBD();
                    break;
                case 6:
                    mostrarLibros();
                    break;
                case 7:
                    bd.cerrarBD();
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    break;
            }
        } while (eleccion!=7);
    }
}
