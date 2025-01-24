package TCP.Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        try{

            Socket sCliente = new Socket( Host, Puerto );
            Scanner sc = new Scanner(System.in);
            String producto = "";

            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());

            DataOutputStream output = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream input = new DataInputStream(sCliente.getInputStream());
            do {
                System.out.println("Escribe productos para añadir a la lista de la compra o salir cuando acabes");
                producto = sc.nextLine();

                output.writeUTF(producto);

                if (!producto.equalsIgnoreCase("salir")) {
                    String respuesta = input.readUTF();
                    System.out.println("Respuesta del servidor: " + respuesta);
                }
            }while (!producto.equalsIgnoreCase("salir")) ;


                System.out.println("Cerrando Cliente...");


            sCliente.close();
        } catch( Exception e ) {
            System.err.println( e.getMessage() );
        }
    }
}