package Ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromos {

    public static boolean esPalindromo(String palabra){

        palabra = palabra.replace(" ","");

        return palabra.equalsIgnoreCase(palabraInversa(palabra));
    }

    public static String palabraInversa(String palabra){

        String alReves="";

        for(int i = palabra.length()-1; i >= 0; i--){

            alReves = alReves + (palabra.charAt(i) + "");
        }

        return alReves.toLowerCase();
    }

    public static String mayuscula(String palabra){

        return palabra.toUpperCase();

    }

    public static void main(String[] args) throws IOException {


        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(in);
        String[] variables = br.readLine().split("-");


        if (variables[0].equalsIgnoreCase("1")){

            System.out.print(variables[1]+" en mayuscula es --> "+mayuscula(variables[1]));


        } else if (variables[0].equalsIgnoreCase("2")) {

            System.out.print("Anita lava la tina es palimdormo --> "+esPalindromo("Anita lava la tina"));

        }


    }

}
