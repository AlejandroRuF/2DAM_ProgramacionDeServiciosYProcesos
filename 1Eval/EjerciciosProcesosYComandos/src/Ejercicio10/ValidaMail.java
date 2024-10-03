package Ejercicio10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ValidaMail {

    public static boolean arroba(String mail) throws Exception {

        if (mail.contains("@")){
            return true;
        }else {

            throw new Exception("ERROR: El email no contiene una @!");

        }
    }

    public static boolean identificador(String mail) throws Exception {

        String[] mailArray = mail.split("@");
        if (mailArray.length <= 1){

            throw new Exception("No existe segundo identificador!");
        }
        return true;

    }

    public static boolean identificadorValido(String mail) throws Exception {
        String[] mailArray = mail.split("@");

        if (mailArray[0].length() < 3){

            throw new Exception("ERROR: El primer dentificador ha de tener una longitud mínima de 3 caracteres!");
        }
        return true;
    }

    public static boolean dominio(String mail) throws Exception {

        String[] mailArray = mail.split("\\.");
        if (mailArray.length <= 1){

            throw new Exception("ERROR: El dominio no es ni com/es/org!");


        }

        if (mailArray[mailArray.length-1].equals("com") || mailArray[mailArray.length-1].equals("es") || mailArray[mailArray.length-1].equals("org")){

            return true;

        }

        throw new Exception("ERROR: El dominio no es ni com/es/org!");

    }

    public static void main(String[] args) throws Exception {

        String mail;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        mail = br.readLine();

        arroba(mail);
        identificador(mail);
        identificadorValido(mail);
        dominio(mail);

        System.out.println("El Email es válido");

    }

}
