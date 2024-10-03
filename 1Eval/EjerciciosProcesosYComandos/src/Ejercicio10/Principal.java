package Ejercicio10;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String ruta = "out/production/EjerciciosProcesosYComandos/";
        File file = new File(ruta);
        String[] comando = {"java", "Ejercicio10.ValidaMail"};


        System.out.println("Introduce una direccion de email válida");

        String mail;
        Scanner sc = new Scanner(System.in);
        mail = sc.nextLine();

        try{
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.directory(file);
            Process p = pb.start();

            OutputStream os = p.getOutputStream();
            os.write((mail+"\n").getBytes());
            os.flush();

            InputStream is = p.getInputStream();
            int fila;
            while ((fila = is.read()) != -1){

                System.out.print((char)fila);

            }
            is.close();

            InputStream isErr = p.getErrorStream();
            int filaErr;
            while ((filaErr = isErr.read()) != -1){

                System.err.print((char)filaErr);

            }
            isErr.close();


        }catch(Exception e){

            e.printStackTrace();
        }

    }

}
