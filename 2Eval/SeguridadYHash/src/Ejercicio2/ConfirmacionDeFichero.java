package Ejercicio2;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConfirmacionDeFichero {

    public static void main(String[] args) {

        String ruta = "src/Ejercicio1/Datos.dat";

        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();
            String datos = (String) o;
            System.out.println("Datos: " + datos);

            o = ois.readObject();
            byte resumenOriginal[] = (byte[]) o;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] dataBytes = datos.getBytes();
            md.update(dataBytes);
            byte[] resumenActual = md.digest();

            if (MessageDigest.isEqual(resumenActual, resumenOriginal)) {
                System.out.println("DATOS VÁLIDOS");
            }else{
                System.out.println("DATOS NO VÁLIDOS");
                fis.close();
                ois.close();
            }



        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

}
