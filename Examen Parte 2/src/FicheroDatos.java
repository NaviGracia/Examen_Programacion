import java.io.*;

/**
 * FicheroDatos
 */
public class FicheroDatos extends Entrada_Salida implements InterfazFicheros{

    public void escribirDatos() throws ExcepcionFicheros{
        try {
            FileWriter fw = new FileWriter(solicitarRuta());
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Texto a escribir");
            String texto = devolverString();
            bw.write(texto);
            bw.close();
            fw.close();
        } catch (Exception e) {
            throw new ExcepcionFicheros(e);
        }
    }

    public void leerDatos() throws ExcepcionFicheros{
        try{
            FileReader fr = new FileReader(solicitarRuta());
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());//Lee la primera linea
            br.close();
            fr.close();
        } catch (Exception e) {
            throw new ExcepcionFicheros(e);
        }
    }

    @Override
    public String solicitarRuta() {
        System.out.println("Inserte la ruta del fichero:");
        return devolverString();
    }
}