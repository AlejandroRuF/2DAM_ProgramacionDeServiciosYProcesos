package UDP.Ejercicio3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    static byte[] buffer = new byte[1024];
    static DatagramPacket recibir = new DatagramPacket(buffer, buffer.length);
    static  HashMap<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        int puertoServer = 6000;
        dictionary.put("hello", "hola");
        dictionary.put("world", "mundo");
        dictionary.put("dog", "perro");
        dictionary.put("cat", "gato");
        dictionary.put("food", "comida");



        try (DatagramSocket socket = new DatagramSocket(puertoServer)) {
            System.out.println("Servidor activo en el puerto " + puertoServer);

            while (true) {

                String opcionMenu = recibirMensaje(socket);
                if (dictionary.get(opcionMenu) != null) {
                    enviarRespuesta(dictionary.get(opcionMenu.toLowerCase()), socket);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviarRespuesta(String mensaje, DatagramSocket socket) {
        try {
            byte[] respuestaBuffer = mensaje.getBytes();
            InetAddress clientAddress = recibir.getAddress();
            int clientPort = recibir.getPort();
            DatagramPacket envio = new DatagramPacket(respuestaBuffer, respuestaBuffer.length, clientAddress, clientPort);

            socket.send(envio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static String recibirMensaje(DatagramSocket socket){

        try {
            socket.receive(recibir);
            return new String(recibir.getData(), 0, recibir.getLength()).trim();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}


