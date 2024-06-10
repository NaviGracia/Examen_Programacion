import java.io.*;

/**
 * FicheroDatos
 */
public class FicheroDatos extends Entrada_Salida{

    public void escribirDatos(){
            FileWriter fw = new FileWriter(/*Ruta fichero a escribir */);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Texto a escribir");
            String texto = devolverString();
            bw.write(texto);
            bw.close();
            fw.close();
        }

        public void leerDatos(){
            FileReader fr = new FileReader(/*Ruta del archivo */);
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());//Lee la primera linea
            br.close();
            fr.close();
        }
}