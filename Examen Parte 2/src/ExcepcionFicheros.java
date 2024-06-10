/**
* Creación de nueva excepción
* @author Ivan García
* @version 1.0, 2024/06/05
*/

public class ExcepcionFicheros extends Exception {
    public ExcepcionFicheros(Exception e) {
        super("Error de ficheros: " + e);
    }
    
}
