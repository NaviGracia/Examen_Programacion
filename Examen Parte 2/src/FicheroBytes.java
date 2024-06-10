/**
 * FileOutputStream
 */
import java.io.*;

public class FicheroBytes extends Fichero{
    public FicheroBytes(String ruta) {
        super(ruta);
    }

    public void escribir() throws ExcepcionEscrituraFicheros{
        try {
            FileOutputStream fout = new FileOutputStream(getRuta());
            DataOutputStream dos = new DataOutputStream(fout);
            System.out.println("Byte a escribir");
            byte b = devolverByte();
            dos.write(b);
            dos.close();
            fout.close();
        } catch (Exception e) {
            throw new ExcepcionEscrituraFicheros(e);
        }
    }

    public void leer() throws ExcepcionLecturaFicheros{
        try {
            FileInputStream fis = new FileInputStream(getRuta());
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            dis.close();
            fis.close();
        } catch (Exception e) {
            throw new ExcepcionLecturaFicheros(e);
        }
    }

}

