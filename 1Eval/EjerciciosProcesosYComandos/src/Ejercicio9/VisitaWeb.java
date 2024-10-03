package Ejercicio9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VisitaWeb {

    public static void main(String[] args) throws Exception {

        String[] frase;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        frase = br.readLine().split("@");


        if (frase.length < 4 && frase.length > 0 && !frase[0].equalsIgnoreCase("")) {

            for (int i = 0; i < frase.length; i++) {

                String[] cmd = {"cmd","/c","start","chrome", frase[i]};
                Process p = new ProcessBuilder(cmd).start();
            }


        }else {

            throw new Exception("Solo es posible abrir un máximo de 3 paginas y un minimo de 1");
        }

    }

}
