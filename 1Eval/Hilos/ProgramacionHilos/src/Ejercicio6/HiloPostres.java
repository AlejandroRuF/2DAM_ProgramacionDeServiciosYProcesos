package Ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class HiloPostres extends Thread {

    public HiloPostres() {

        super("Postres");

    }

    public List<String> leerPostres(){

        List<String> postres = new ArrayList<String>();

        String archivoLectura = "src/Ejercicio6/menu.txt";
        String archivoEscritura = "src/Ejercicio6/postres.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(archivoLectura))){

            String linea;

            while ((linea = br.readLine()) != null){

                String[] lineaVector = linea.split("-");

                if (lineaVector[0].equalsIgnoreCase("3") && !lineaVector[1].equalsIgnoreCase("postres")){
                    postres.add(lineaVector[1]);
                }

            }

            br.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEscritura))){

            for (String postre : postres){

                bw.write(postre);
                bw.newLine();
                System.out.println(getName()+"..... escribe "+postre);

            }

            bw.flush();

        }catch (Exception e){

            e.printStackTrace();

        }



        return postres;
    }

    public void run(){
        leerPostres();
    }

}
