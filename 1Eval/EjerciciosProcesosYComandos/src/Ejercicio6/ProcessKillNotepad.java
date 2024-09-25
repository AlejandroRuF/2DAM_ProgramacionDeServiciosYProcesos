package Ejercicio6;

import java.io.IOException;
import java.util.Scanner;

public class ProcessKillNotepad {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        String so = System.getProperty("os.name").toLowerCase();
        if (so.contains("win")) {
            String[] blocDeNotas = {"notepad"};
            Process p = new ProcessBuilder(blocDeNotas).start();

//            System.out.println("Quieres cerrar el progrma notepad ?");
//            if (sc.nextLine().equalsIgnoreCase("si")){
            Thread.sleep(10000);
            System.out.println("cerrando programa");
            Process p2 = new ProcessBuilder("cmd.exe","/c","taskkill /IM notepad.exe /F").start();

//            }else {
//                System.out.println("Cierre de notepad cancelado");
//
//            }


        }else {
            //System.out.println("Introduce el programa de bloc de notas predeterminado en tu sistema linux");
//            String programa = sc.nextLine();
            String programa = "gedit";
            Process p = new ProcessBuilder(programa).start();

//            System.out.println("Quieres cerrar el progrma "+programa+"?");
//            if (sc.nextLine().equalsIgnoreCase("si")){
            Thread.sleep(10000);
            System.out.println("cerrando programa");
            Process p2 = new ProcessBuilder("bash","-c","pkill "+programa).start();

//            }else {
//                System.out.println("Cierre de "+programa+" cancelado");
//
//            }


        }

    }

}
