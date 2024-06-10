/**
 * FileOutputStream
 */
import java.io.*;

public class FicheroBytes extends Entrada_Salida  implements InterfazFicheros{
    public void escribirBytes() throws ExcepcionFicheros{
        try {
            FileOutputStream fout = new FileOutputStream(solicitarRuta());
            DataOutputStream dos = new DataOutputStream(fout);
            System.out.println("Byte a escribir");
            byte b = devolverByte();
            dos.write(b);
            dos.close();
            fout.close();
        } catch (Exception e) {
            throw new ExcepcionFicheros(e);
        }
    }

    public void leerBytes() throws ExcepcionFicheros{
        try {
            FileInputStream fis = new FileInputStream(solicitarRuta());
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            dis.close();
            fis.close();
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

