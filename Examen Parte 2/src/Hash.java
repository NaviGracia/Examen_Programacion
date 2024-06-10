import java.util.HashMap;

/**
 * Hash
 */
public class Hash {
    static HashMap<Integer, Libro> librosMap = new HashMap<>();

    public void conversionLibrosBD(BD bd){
        librosMap = bd.cargarBDaHashMap();
    }

    public void insertarLibro(BD bd, int id){
        librosMap.put(id, bd.obtenerLibro(id));
    }

    public void mostrarLibros(){
        for (Libro l : librosMap.values()) {
            System.out.println(l.toString());
        }
    }

    public void eliminarLibro(int id){
        for (int clave : librosMap.keySet()) {
            if (clave==id) {
                librosMap.remove(clave);
            }
        }
    }

    public void limpiarHashMap(){
        librosMap.clear();
    }
    
}