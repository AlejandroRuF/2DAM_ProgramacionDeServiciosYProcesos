package Ejercicio5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProcessListPNG {
    public static void main(String[] args) throws IOException {

        String ruta = "/home/procesos/IdeaProjects/untitled";

        Scanner sc =  new Scanner(System.in);
//        System.out.println("Introduce la ruta que desees para comprobar los PNG Existentes");
//        ruta = sc.nextLine();

        String[] cmd = {"bash", "-c", "ls "+ruta+"/*.png"};
        Process p = new ProcessBuilder(cmd).start();

        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {

            System.out.print((char)c);

        }


    }
}