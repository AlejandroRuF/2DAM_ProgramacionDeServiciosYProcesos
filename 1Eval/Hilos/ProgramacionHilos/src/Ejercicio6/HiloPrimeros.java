package Ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class HiloPrimeros extends Thread {

    public HiloPrimeros() {

        super("Primeros");

    }

    public List<String> leerPrimeros(){

        List<String> primeros = new ArrayList<String>();

        String archivoLectura = "src/Ejercicio6/menu.txt";
        String archivoEscritura = "src/Ejercicio6/primeros.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(archivoLectura))){

            String linea;

            while ((linea = br.readLine()) != null){

                String[] lineaVector = linea.split("-");

                if (lineaVector[0].equalsIgnoreCase("1") && !lineaVector[1].equalsIgnoreCase("primeros")){
                    primeros.add(lineaVector[1]);
                }

            }

            br.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEscritura))){

            for (String primero : primeros){

                bw.write(primero);
                bw.newLine();

                System.out.println(getName()+"..... escribe "+primero);

            }

            bw.flush();

        }catch (Exception e){

            e.printStackTrace();

        }



        return primeros;
    }


    public void run() {
        leerPrimeros();
    }
}
