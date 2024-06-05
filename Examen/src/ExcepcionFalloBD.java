import java.sql.SQLException;

/**
* Creación de nueva excepción
* @author Ivan García
* @version 1.0, 2024/06/05
*/

public class ExcepcionFalloBD extends SQLException {
    public ExcepcionFalloBD(String mensaje) {
        super(mensaje);
    }
}
