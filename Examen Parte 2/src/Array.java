import java.util.ArrayList;

/**
 * ArrayList
 */
public class Array extends Entrada_Salida{
    static ArrayList<Libro> libros = new ArrayList<>();

    public void conversionLibrosBD(BD bd){
        libros = bd.cargarBDaArrayList();
    }

    public void insertarLibro(BD bd, int id){
        libros.add(bd.obtenerLibro(id));
    }

    public void mostrarLibros(){
        for (Libro l : libros) {
            System.out.println(l.toString());
        }
    }

    public void eliminarLibro(int id){
        for (Libro l : libros) {
            if (l.getId()==id) {
                libros.remove(l);
            }
        }
    }
}