package Ejercicio9;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerWeb {

    public static void main(String[] args) throws Exception {


        String frase;
        System.out.println("Introduce de 1 a 3 paginas web separadas por el simbolo '@'");

        Scanner sc = new Scanner(System.in);
        frase = sc.nextLine();
        String ruta = "out/production/EjerciciosProcesosYComandos";
        File file = new File(ruta);


        try {
            String[] comando = {"java","Ejercicio9.VisitaWeb"};
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.directory(file);
            Process p = pb.start();

            OutputStream os = p.getOutputStream();
            os.write(frase.getBytes());
            os.flush();




        }catch (Exception e){
            System.err.println(e.getMessage());

        }



    }

}
