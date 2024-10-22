package Ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class HiloSegundos extends Thread {

    public HiloSegundos() {

        super("Segundos");

    }

    public List leerSegundos(){

        List<String> Segundos = new ArrayList<String>();

        String archivoLectura = "src/Ejercicio6/menu.txt";
        String archivoEscritura = "src/Ejercicio6/segundos.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(archivoLectura))){

            String linea;

            while ((linea = br.readLine()) != null){

                String[] lineaVector = linea.split("-");

                if (lineaVector[0].equalsIgnoreCase("2") && !lineaVector[1].equalsIgnoreCase("segundos")){
                    Segundos.add(lineaVector[1]);
                }

            }

            br.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEscritura))){

            for (String segundo : Segundos){

                bw.write(segundo);
                bw.newLine();

                System.out.println(getName()+"..... escribe "+segundo);
            }

            bw.flush();

        }catch (Exception e){

            e.printStackTrace();

        }



        return Segundos;
    }

    public void run(){
        leerSegundos();
    }

}
