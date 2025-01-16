package Ejercicio3;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<SuperHeroes> superHeroes = new ArrayList<SuperHeroes>();
        String rutaArchivo = "src/Ejercicio3/InfoSuperHeroes/Heroes.txt";
        String paginaWeb = "";

        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){

            String linea;
            while((linea=br.readLine())!=null){

                String[] heroe = linea.split(";");
                superHeroes.add(new SuperHeroes(heroe));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        for (SuperHeroes superHero : superHeroes) {
            System.out.println(superHero);
        }

        try{
            URL url = new URL("https://mural.uv.es/franpevi/index.html");
            InputStream is = url.openStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=bf.readLine())!=null){

                paginaWeb += line+"\n";

            }
            System.out.println(paginaWeb);
            bf.close();

            String patron = "<img[^>]*src=['\"]([^'\"]+)['\"][^>]*class=['\"]([^'\"]+)['\"][^>]*>";

            Pattern patternSrc = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
            Matcher matcherSrc = patternSrc.matcher(paginaWeb);

            while (matcherSrc.find()) {

                for (SuperHeroes superHero : superHeroes) {
                    if (matcherSrc.group(2).equals(superHero.getId())) {

                        superHero.setImagen(matcherSrc.group(1));

                    }
                }
            }

            for (SuperHeroes superHero : superHeroes) {
                System.out.println(superHero);
            }


            String htmlMarvel = "<html>\n" +
                    "<head>\n" +
                    "<title>Marvel</title>\n" +
                    "</head>\n" +
                    "<body style=\"background-color: #f0f0f0;\">\n" +
                    "<h1>SuperHeroes Marvel</h1>\n";

            for (SuperHeroes superHero : superHeroes) {
                if (superHero.getMarvel()) {
                    htmlMarvel += "<div>\n" +
                            "<img src=\""+superHero.getImagen()+"\" alt=\""+superHero.getNombre()+"\">\n" +
                            "<p>"+superHero.getDescripcion()+"</p>\n" +
                            "</div>\n";
                }
            }

            htmlMarvel += "</body>\n" +
                    "</html>";

            try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ejercicio3/InfoSuperHeroes/marvel.html"))){

                bw.write(htmlMarvel);

            }catch (Exception e){
                e.printStackTrace();
            }

            String htmlDC = "<html>\n" +
                    "<head>\n" +
                    "<title>DC</title>\n" +
                    "</head>\n" +
                    "<body style=\"background-color: #f0f0f0;\">\n" +
                    "<h1>SuperHeroes DC</h1>\n";

            for (SuperHeroes superHero : superHeroes) {
                if (!superHero.getMarvel()) {
                    htmlDC += "<div>\n" +
                            "<img src=\""+superHero.getImagen()+"\" alt=\""+superHero.getNombre()+"\">\n" +
                            "<p>"+superHero.getDescripcion()+"</p>\n" +
                            "</div>\n";
                }
            }

            htmlDC += "</body>\n" +
                    "</html>";

            try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ejercicio3/InfoSuperHeroes/dc.html"))){

                bw.write(htmlDC);

            }catch (Exception e){
                e.printStackTrace();
            }


        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
