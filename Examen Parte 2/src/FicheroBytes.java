import java.io.FileOutputStream;

/**
 * FileOutputStream
 */
import java.io.*;

public class FicheroBytes extends Entrada_Salida{
        public void escribirBytes(){
            FileOutputStream fout = new FileOutputStream(/*Ruta fichero a escribir */);
            System.out.println("Byte a escribir");
            byte b = devolverByte();
            fout.write(b);
        }

        public void leerBytes(){
            FileInputStream fis = new FileInputStream(/*Ruta del archivo */)
            
        }
}

