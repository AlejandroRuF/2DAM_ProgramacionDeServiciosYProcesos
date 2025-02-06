package TCPObjetos.Ejercicio2;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        try{
            ArrayList<Persona> clientes = new ArrayList<>();
            clientes.add(new Persona("Juan Pérez", 19));
            clientes.add(new Persona("María López"));
            clientes.add(new Persona("Carlos García", 33));
            clientes.add(new Persona("Ana Martínez", 25));


            Socket sCliente = new Socket( Host, Puerto );



            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());

            ObjectOutputStream output = new ObjectOutputStream(sCliente.getOutputStream());
            DataInputStream input = new DataInputStream(sCliente.getInputStream());


                output.writeObject(clientes);
                System.out.println("Objeto enviado al servidor: Lista de Personas");

                String respuesta = input.readUTF();
                System.out.println("Respuesta del servidor: " + respuesta);

                System.out.println("Cerrando Cliente...");


            sCliente.close();
        } catch( Exception e ) {
            System.err.println( e.getMessage() );
        }
    }
}