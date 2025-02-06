package TCPObjetos.Ejercicio1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        try{
            ArrayList<String> clientes = new ArrayList<>();
            clientes.add("Juan Pérez");
            clientes.add("María López");
            clientes.add("Carlos García");
            clientes.add("Ana Martínez");


            Socket sCliente = new Socket( Host, Puerto );



            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());

            ObjectOutputStream output = new ObjectOutputStream(sCliente.getOutputStream());
            DataInputStream input = new DataInputStream(sCliente.getInputStream());


                output.writeObject(clientes);
                System.out.println("Objeto enviado al servidor: Lista de clientes");

                String respuesta = input.readUTF();
                System.out.println("Respuesta del servidor: " + respuesta);

                System.out.println("Cerrando Cliente...");


            sCliente.close();
        } catch( Exception e ) {
            System.err.println( e.getMessage() );
        }
    }
}