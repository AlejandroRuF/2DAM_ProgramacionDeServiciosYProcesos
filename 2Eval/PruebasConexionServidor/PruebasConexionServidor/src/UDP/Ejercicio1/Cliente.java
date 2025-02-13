package UDP.Ejercicio1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        final int puertoServer = 12345;
        byte[] buffer = new byte[1024];

        Scanner sc = new Scanner(System.in);
        String mensaje = "";
        System.out.println("Escribe un mensaje para enviar...");

        try {

            InetAddress destino = InetAddress.getByName("localhost");

            mensaje = sc.nextLine();

            buffer = mensaje.getBytes();

            DatagramPacket envio =  new DatagramPacket(buffer, buffer.length, destino, puertoServer);
            DatagramSocket socketUDP = new DatagramSocket();
            System.out.println("Enviando mensaje...");
            socketUDP.send(envio);


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
