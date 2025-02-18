package UDPObjetos.Ejercicio1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Cliente {

    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        DatagramPacket recibir = new DatagramPacket(buffer, buffer.length);

        try {
            DatagramSocket socket = new DatagramSocket(6000);
            socket.receive(recibir);

            ByteArrayInputStream is = new ByteArrayInputStream(recibir.getData(),0,recibir.getLength());
            ObjectInputStream in = new ObjectInputStream(is);
            Object object = in.readObject();

            if (object instanceof Persona){
                Persona p = (Persona) object;
                System.out.println(p);
            }



        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
