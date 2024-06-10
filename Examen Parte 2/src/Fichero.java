/**
 * Fichero
 */
public abstract class Fichero extends Entrada_Salida implements InterfazFicheros{
    private String ruta;

    public Fichero(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }
}