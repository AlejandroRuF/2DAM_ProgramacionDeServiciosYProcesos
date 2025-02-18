package UDPObjetos.Ejercicio1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    public static void main(String[] args) {

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        try {
            DatagramSocket socket = new DatagramSocket(6001);
            InetAddress destino = InetAddress.getByName("localhost");

            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(new Persona("Juan", 25));
            os.close();
            byte[] buffer = bs.toByteArray();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, destino, 6000);
            socket.send(packet);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
