/**
* Creación de nueva excepción
* @author Ivan García
* @version 1.0, 2024/06/05
*/

public class ExcepcionEscrituraFicheros extends Exception {
    public ExcepcionEscrituraFicheros(Exception e) {
        super("Error en la escritura de ficheros: " + e);
    }
}
