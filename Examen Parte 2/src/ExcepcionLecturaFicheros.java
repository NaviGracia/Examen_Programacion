/**
* Creación de nueva excepción
* @author Ivan García
* @version 1.0, 2024/06/05
*/

public class ExcepcionLecturaFicheros extends Exception {
    public ExcepcionLecturaFicheros(Exception e) {
        super("Error en la lectura de ficheros: " + e);
    }
}
