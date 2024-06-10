/**
* Codigo main
*
* @author Ivan García
* @version 1.0, 2024/02/5
*/

public class App extends Entrada_Salida{
    static BD bd = new BD();
    static Array libros = new Array();
    
    public static void main(String[] args) throws Exception {
        bd.conectarBD();
        libros.conversionLibrosBD(bd);

        int eleccion = 0;
        do {    
            System.out.println("Menú: " + "\n 1. Añadir Libro " + "\n 2. Añadir 2 Libros" + "\n 3. Actualizar un Libro" + "\n 4. Eliminar Libro" + 
            "\n 5. Consultar libros por autor" + "\n 6. Consultar todos los libros" + "\n 7. Salir" + "\n Que desea realizar?:");
            eleccion = devolverInt();
            switch (eleccion) {
                case 1:
                    int id = bd.insertarLibro();
                    System.out.println("ID autogenerado del libro: " + id);
                    libros.insertarLibro(bd, id);
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
                    libros.eliminarLibro(idEliminar);
                    break;
                case 5:
                    bd.consultarBD();
                    break;
                case 6:
                    libros.mostrarLibros();
                    break;
                case 7:
                    bd.cerrarBD();
                    System.out.println("Saliendo del programa");
                    break;
                case 8:
                    try {
                        FicheroBytes fb = new FicheroBytes("/src/prueba.txt");
                        fb.escribir();
                    } catch (ExcepcionEscrituraFicheros e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        } while (eleccion!=7);
    }
}
