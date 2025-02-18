package Ejercicio1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GuardadoDeFichero {

    public static void main(String[] args) {

        String datos = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] dataBytes = datos.getBytes();
            md.update(dataBytes);
            byte[] hash = md.digest();

            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("src/Ejercicio1/Datos.dat"));
            escribir.writeObject(datos);
            escribir.writeObject(hash);

        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}
