package Ejercicio2;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void printUrl (URL url){
        System.out.println("URL completa: " + url);
        System.out.println("    get protocol: " + url.getProtocol());
        System.out.println("    getHost: " + url.getHost());
        System.out.println("    getPort: " + url.getPort());
        System.out.println("    getFile: " + url.getFile());
        System.out.println("    getUserInfo: " + url.getUserInfo());
        System.out.println("    getPath: " + url.getPath());
        System.out.println("    getAuthority: " + url.getAuthority());
        System.out.println("    getQuery: " + url.getQuery());
        System.out.println("    getDefaultPort: " + url.getDefaultPort());
    }


    public static void main(String[] args) {

        URL url;


        try {
            url = new URL("http://docs.oracle.com/");
            System.out.println("Metodo 1: url =  new URL(\"http://docs.oracle.com/\");");

            printUrl(url);

            System.out.println("---------------------------------------------------------------------------------------\n");

            url = new URL("https", "docs.oracle.com", "/javase/23");
            System.out.println("Metodo 2: url = new URL(\"https\",\"docs.oracle.com\",\"/javase/23\");");

            printUrl(url);

            System.out.println("---------------------------------------------------------------------------------------\n");


            url = new URL("https", "docs.oracle.com", 123, "/javase/23");
            System.out.println("Metodo 2: url = new URL(\"https\",\"docs.oracle.com\",\"/javase/23\");");
            printUrl(url);

            System.out.println("---------------------------------------------------------------------------------------\n");


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br;
        String htmlPag = "";
        List<String> codigo = new ArrayList<String>();
        String pagina = "https://www.marca.com/atletismo/2024/12/12/gout-gout-fenomeno-australiano-asombra-portento-unico.html";



        try{

            url = new URL("https://www.marca.com/atletismo/2024/12/12/gout-gout-fenomeno-australiano-asombra-portento-unico.html");
            InputStream is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) {

                htmlPag += linea;


            }

            br.close();

            Pattern patron = Pattern.compile("<h2\s.*?>(.*?)</h2>");
            Matcher matcher = patron.matcher(htmlPag);

            while (matcher.find()) {

                codigo.add(matcher.group(1));

            }


            System.out.println("Titulos h2 en la pagina "+pagina);

            for (String titulo : codigo){
                System.out.println(titulo);
                System.out.println();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
