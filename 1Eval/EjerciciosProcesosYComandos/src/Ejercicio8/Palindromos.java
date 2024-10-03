package Ejercicio8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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


        String rutaProyecto = System.getProperty("user.dir");
        String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Ejercicio8" + File.separator + "textos"+File.separator;

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(in);
        String[] variables = br.readLine().split("-");
        String frase = "Anita lava la tina";
        boolean palindromo = esPalindromo("Anita lava la tina");





        if (variables[0].equalsIgnoreCase("1")){

            System.out.print(variables[1]+" en mayuscula es --> "+mayuscula(variables[1]));


        } else if (variables[0].equalsIgnoreCase("2")) {

            System.out.print("Anita lava la tina es palimdormo --> "+palindromo);

            List<File> archivos = new ArrayList<File>();
            archivos.add(new File(rutaDirectorio+"palindromo.txt"));
            archivos.add(new File(rutaDirectorio+"Nopalindromo.txt"));
            archivos.add(new File(rutaDirectorio+"todas.txt"));

            try{

                for (File file : archivos){

                    if(!file.exists()){

                        if (file.createNewFile()){

                            System.out.println(file.getName()+" Creado correctamente" );

                        }else {

                            System.out.println(file.getName()+" No se ha podido crear");

                        }

                    }

                }

                FileWriter fw = new FileWriter(archivos.get(2));
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(frase);
                bw.newLine();
                bw.close();

                if(palindromo){

                    FileWriter fwPalindromo = new FileWriter(archivos.get(0));
                    BufferedWriter bwPalindromo = new BufferedWriter(fwPalindromo);
                    bwPalindromo.write(frase);
                    bwPalindromo.newLine();
                    bwPalindromo.close();

                }else {

                    FileWriter fwNoPalindromo = new FileWriter(archivos.get(1));
                    BufferedWriter bwNoPalindromo = new BufferedWriter(fwNoPalindromo);
                    bwNoPalindromo.write(frase);
                    bwNoPalindromo.newLine();
                    bwNoPalindromo.close();


                }




            }catch (Exception e){

                e.printStackTrace();

            }

        }


    }

}
