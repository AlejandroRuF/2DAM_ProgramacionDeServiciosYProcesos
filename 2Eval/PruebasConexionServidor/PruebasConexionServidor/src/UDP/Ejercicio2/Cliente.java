package UDP.Ejercicio2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    //Falta Acabar bucle que se mantenga mientras no se pulse la opcion salir demas opciones dependiendo de la respuesta del servidor

//    private static final int PUERTO_SERVER = 12345;
//    private static final String HOST = "localhost";
//    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un mensaje para enviar...");
        String mensaje = sc.nextLine();

        try (DatagramSocket socketUDP = new DatagramSocket()) {
            InetAddress destino = InetAddress.getByName(HOST);

            enviarMensaje(socketUDP, mensaje, destino, PUERTO_SERVER);

            String respuesta = recibirMensaje(socketUDP);
            System.out.println("Mensaje recibido: " + respuesta);

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Error de socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void enviarMensaje(DatagramSocket socket, String mensaje, InetAddress destino, int puerto) throws IOException {
        byte[] buffer = mensaje.getBytes();
        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
        socket.send(envio);
    }

    private static String recibirMensaje(DatagramSocket socket) throws IOException {
        byte[] bufferRespuesta = new byte[BUFFER_SIZE];
        DatagramPacket recibo = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
        socket.receive(recibo);
        return new String(recibo.getData(), 0, recibo.getLength());
    }
}
