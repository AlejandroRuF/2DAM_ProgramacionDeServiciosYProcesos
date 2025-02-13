package UDP.Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

//    1. Vamos a realizar una práctica en Java mediante el envío de mensajes UDP en la cual un Servidor
//    sea capaz de contar el número de letras a que recibe de un Cliente. Para ello, necesitaremos un
//    Cliente que leerá una cadena de texto de la entrada estándar, la envíe al servidor y espere una
//    respuesta del mismo.

    public static int numeroLetras(String frase){

        String fraseSinEspacios = frase.replaceAll(" ", "");
        return fraseSinEspacios.length();

    }

    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        int puertoServer = 12345;
        System.out.println("Encendiendo Servidor...");

        try {
            DatagramSocket socketUDP = new DatagramSocket(puertoServer);

            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(recibo);

            String mensaje  = new String(recibo.getData(), 0 , recibo.getLength());

            System.out.println("Mensaje recibido: " + mensaje);
            int numero = numeroLetras(mensaje);
            System.out.println("Número de letras: " + numero);

            int puertoCliente = recibo.getPort();
            InetAddress direccionCliente = recibo.getAddress();

            DatagramPacket envio = new DatagramPacket(buffer, buffer.length, direccionCliente, puertoCliente);
            DatagramSocket socketEnvio = new DatagramSocket();
            socketEnvio.send(envio);

            socketEnvio.close();
            socketUDP.close();



        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
