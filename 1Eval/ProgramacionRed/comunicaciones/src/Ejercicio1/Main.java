package Ejercicio1;

import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        //Para poner en práctica todos los métodos de la clase InetAddress, lleva a cabo un programa en
        //Java que devuelva toda la información del “localhost” y de una dirección web como, por ejemplo,
        //“www.google.es”, de la cual obtendremos además todas las direcciones IP asociadas.

        String pagina = "www.youtube.es";
        InetAddress website;
        InetAddress local;

        System.out.println("SALIDA PARA LOCALHOST");
        try {
            local = InetAddress.getLocalHost();

            System.out.println("    Metodo getByName: "+local);
            System.out.println("    Metodo getLocalHost: "+InetAddress.getLocalHost());
            System.out.println("    Metodo getHostName: "+local.getHostName());
            System.out.println("    Metodo getHostAddress: "+local.getHostAddress());
            System.out.println("    Metodo toString: "+local.toString());
            System.out.println("    Metodo getCanonicalHostName(): "+local.getCanonicalHostName());



        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        System.out.println("==========================================================================================");
        System.out.println("SALIDA PARA LA URL "+ pagina);
        try {

            website = InetAddress.getByName(pagina);


            System.out.println("    Metodo getByName: "+website);
            System.out.println("    Metodo getLocalHost: "+local);
            System.out.println("    Metodo getHostName: "+website.getHostName());
            System.out.println("    Metodo getHostAddress: "+website.getHostAddress());
            System.out.println("    Metodo toString: "+website.toString());
            System.out.println("    Metodo getCanonicalHostName(): "+website.getCanonicalHostName());
            System.out.println("    DIRECCIONES IP PARA "+ pagina);


            InetAddress[] ipPagina = InetAddress.getAllByName(pagina);

            for (InetAddress ip : ipPagina) {
                System.out.println("        "+ ip);
            }


        }catch (Exception e) {
            System.err.println(e.getMessage());


        }

    }

}
