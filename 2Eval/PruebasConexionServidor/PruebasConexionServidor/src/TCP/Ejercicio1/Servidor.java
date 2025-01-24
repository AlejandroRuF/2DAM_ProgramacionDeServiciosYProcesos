package TCP.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
            final String comandoSalida = "";



            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto "+Puerto);
            System.out.println("Escuchando al TCP.Ejercicio1.Cliente 1 ");

            Socket sCliente1 = skServidor.accept();
//            System.out.println("Escuchando al TCP.Ejercicio1.Cliente 2 ");
//            Socket sCliente2 = skServidor.accept();

            DataInputStream input = new DataInputStream(sCliente1.getInputStream());
            DataOutputStream output = new DataOutputStream(sCliente1.getOutputStream());


            String mensaje = input.readUTF();
            System.out.println("Mensaje del cliente 1: " + mensaje);

            if (mensaje != null) {
                output.writeUTF("Mensaje recibido del cliente 1");
            }

            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("TCP.Ejercicio1.Servidor cerrado. ");
    }



}