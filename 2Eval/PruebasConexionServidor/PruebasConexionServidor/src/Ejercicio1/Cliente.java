package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        try{

            Socket sCliente = new Socket( Host, Puerto );

            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());

            DataOutputStream output = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream input = new DataInputStream(sCliente.getInputStream());

            output.writeUTF("Hola Ejercicio1.Servidor");

            String respuesta = input.readUTF();
            System.out.println("Respuesta del servidor: "+respuesta);

            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}