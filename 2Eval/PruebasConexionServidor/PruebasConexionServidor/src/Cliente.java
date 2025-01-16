import java.io.IOException;
import java.net.*;

import static java.net.InetAddress.getByName;

public class Cliente {

    public static void main(String[] args) throws IOException, IOException {
//puerto del servidor
        final int puerto = 12345;
//buffer donde se almacenara los mensajes
        byte[] buffer = new byte[1024];
        InetAddress destino = getByName("192.168.124.46");//
//        getByName(args[0]);//InetAddress.getLocalHost();
        String mensaje = "Hola mundo desde el cliente!";
//Convierto el mensaje a bytes
        buffer = mensaje.getBytes();
//Creo un datagrama
        DatagramPacket envio = new DatagramPacket(buffer, buffer.length,
                destino, puerto);
//Creo el socket de UDP
        DatagramSocket socketUDP = new DatagramSocket(34567);
//Lo envio con send
        System.out.println("Envio el datagrama");
        socketUDP.send(envio);
//cierro el socket
        socketUDP.close();
    }

}
