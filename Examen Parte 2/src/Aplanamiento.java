import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Aplanamiento
 */
public class Aplanamiento {

    public static void aplanarFichero(){
        FileOutputStream fout = new FileOutputStream("src/"/*Ruta del archivo a escribir*/);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(/*ArrayList a escribir*/);
        out.close();
        System.out.println("Aplanamiento Realizado");
    }

    public static ArrayList</*Atributos del ArrayList */> desaplanarFichero(){
        FileInputStream fis = new FileInputStream("src/"/*Ruta del archivo a escribir*/);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList</*Atributos del ArrayList */> al = (ArrayList</*Atributos del ArrayList */>)ois.readObject();
        ois.close();
        return al;
    }
}