/**
* Clase de entrada|salida de valores
* @author Ivan García
* @version 1.0, 2024/04/22
*/
import java.util.Scanner;

/*Importaciones Únicas del Proyecto */
import java.sql.Statement;
import java.sql.ResultSet;


public class Entrada_Salida {
    static Scanner sc = new Scanner(System.in);
    
    /*Colores de Terminal */
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    
    /*Estándar*/
    public static int devolverInt(){
        int n = Integer.parseInt(devolverString());
        return n;
    }

    public static String devolverString(){
        return sc.nextLine();
    }
    
    public static double devolverDouble(){
        double n = Double.parseDouble(devolverString());
        return n;
    }

    public static boolean devolverBoolean(){
        boolean bool = sc.nextBoolean();
        return bool;
    }


    //Controlador para que no salten automaticamente los menus después de completar la acción
    public static String controladorContinuar(){
        System.out.println("Presione Enter para continuar.");
        return devolverString();
    }

    //Controlador de Objetos, para que no aparezcan 100 objetos de golpe, reutilizable cambiando los parametros
    public static void controladorObjetos(Object o){
        int controladorCatalogo = 0;
        if (controladorCatalogo == 6) {
            System.out.println(o.toString());
            controladorContinuar();
            controladorCatalogo = 0;
        } else{
            System.out.println(o.toString());
            controladorCatalogo++;
        }
    }
}