package UDP.Ejercicio3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {


    private static final int PUERTO_SERVER = 6000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String mensaje = "";
        String respuesta = "";


        try (DatagramSocket socketUDP = new DatagramSocket()) {
            InetAddress destino = InetAddress.getByName(HOST);

            while (!mensaje.equalsIgnoreCase("salir1")) {
                System.out.println("Escribe una palabra para traducir...\n" +
                        "Escribe salir1 para salir del programa");

                mensaje = sc.nextLine();

                if (!mensaje.equalsIgnoreCase("salir1")) {


                    enviarMensaje(socketUDP, mensaje, destino, PUERTO_SERVER);

                    respuesta = "";

                    socketUDP.setSoTimeout(5000);
                    respuesta = recibirMensaje(socketUDP);
                    System.out.println(respuesta);
                }

            }

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Error de socket: " + e.getMessage());
        } catch (InterruptedIOException e) {
            System.err.println("No se encontro traduccion");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void enviarMensaje(DatagramSocket socket, String mensaje, InetAddress destino, int puerto) throws IOException {
        byte[] buffer = mensaje.getBytes();
        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
        socket.send(envio);
    }

    private static String recibirMensaje(DatagramSocket socket) throws IOException {
        byte[] bufferRespuesta = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
        socket.receive(recibo);
        return new String(recibo.getData(), 0, recibo.getLength());
    }
}
