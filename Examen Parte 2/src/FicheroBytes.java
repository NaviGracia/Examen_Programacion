import java.io.FileOutputStream;

/**
 * FileOutputStream
 */
import java.io.*;

public class FicheroBytes extends Entrada_Salida{
        public void escribirBytes(){
            FileOutputStream fout = new FileOutputStream(/*Ruta fichero a escribir */);
            DataOutputStream dos = new DataOutputStream(fout);
            System.out.println("Byte a escribir");
            byte b = devolverByte();
            dos.write(b);
            dos.close();
            fout.close();
        }

        public void leerBytes(){
            FileInputStream fis = new FileInputStream(/*Ruta del archivo */)
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
        }
}

