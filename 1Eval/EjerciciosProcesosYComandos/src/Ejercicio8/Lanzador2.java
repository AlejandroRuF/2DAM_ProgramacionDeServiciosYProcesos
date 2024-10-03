package Ejercicio8;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Lanzador2 {

    public static void main(String[] args) throws IOException {


        String ruta = System.getProperty("user.dir");
        ruta = ruta+"/out/production/EjerciciosProcesosYComandos/";
        File file = new File(ruta);
        String[] comando = {"java", "Ejercicio8.Palindromos"};
        Scanner sc = new Scanner(System.in);
        String palabra = " ";
        String opcion;


        System.out.println("1- Transformar una palabra a mayuscula\n" +
                "2- Averiguar si la frase registrada es palindromo");

        System.out.print("Opcion:  ");
        opcion = sc.nextLine();

        if (opcion.equals("1")) {

            System.out.print("Introduce la palabra palabra que transformar en mayuscula: ");
            palabra = sc.nextLine();


        } else if (!opcion.equalsIgnoreCase("2")) {

            System.out.println("La opcion introducida no es valida reinicia el programa");

        }

        String instruccion = opcion+"-"+palabra+"\n";



        try{
            ProcessBuilder pb =  new ProcessBuilder("java","Ejercicio8.Palindromos");
            pb.directory(file);
            Process p = pb.start();


            OutputStream os = p.getOutputStream();
            os.write(instruccion.getBytes());
            os.flush();


            InputStream es = p.getErrorStream();
            int errorChar;
            System.out.println("\n");
            while ((errorChar = es.read()) != -1) {
                System.err.print((char) errorChar);
            }
            es.close();

        }catch (Exception e){
            System.out.println(e.getMessage());


        }

    }

}
