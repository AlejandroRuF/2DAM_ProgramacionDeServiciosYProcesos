package Ejercicio7;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Lanzador {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero entero");
        String numero = sc.nextLine();
        System.out.println("Introduce un numero entero");
        String numero2 = sc.nextLine();

        String ruta  = System.getProperty("user.dir");

        String[] comando = {"java", "Ejercicio7.Sumador", numero, numero2};
        ProcessBuilder pb = new ProcessBuilder(comando);

        File file = new File(ruta+"/out/production/EjerciciosProcesosYComandos/");
        pb.directory(file);

        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();

            int fila;
            while((fila = is.read()) != -1) {
                System.out.print((char)fila);
            }

            is.close();
        } catch (Exception e) {
            Exception ex = e;
            throw new RuntimeException(e);
        }

    }

}
