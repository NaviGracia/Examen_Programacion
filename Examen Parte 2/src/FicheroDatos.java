import java.io.*;

/**
 * FicheroDatos
 */
public class FicheroDatos extends Fichero{
    
    public FicheroDatos(String ruta) {
        super(ruta);
    }

    public void escribir() throws ExcepcionEscrituraFicheros{
        try {
            FileWriter fw = new FileWriter(getRuta());
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Texto a escribir");
            String texto = devolverString();
            bw.write(texto);
            bw.close();
            fw.close();
        } catch (Exception e) {
            throw new ExcepcionEscrituraFicheros(e);
        }
    }

    public void leer() throws ExcepcionLecturaFicheros{
        try{
            FileReader fr = new FileReader(getRuta());
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());//Lee la primera linea
            br.close();
            fr.close();
        } catch (Exception e) {
            throw new ExcepcionLecturaFicheros(e);
        }
    }

    public void escribirObjeto(Libro l) throws ExcepcionEscrituraFicheros{
        try{
            FileOutputStream fout = new FileOutputStream(getRuta());
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(l);
            out.close();
        }catch(Exception e){
            throw new ExcepcionEscrituraFicheros(e);
        }
    }

    public Libro leerObjeto() throws ExcepcionLecturaFicheros{
        Libro l = null;
        try {
            FileInputStream fis = new FileInputStream(getRuta());
            ObjectInputStream ois = new ObjectInputStream(fis);
            l  = (Libro) ois.readObject();
            ois.close();
        } catch (Exception e) {
            throw new ExcepcionLecturaFicheros(e);
        }
        return l;
    }
}