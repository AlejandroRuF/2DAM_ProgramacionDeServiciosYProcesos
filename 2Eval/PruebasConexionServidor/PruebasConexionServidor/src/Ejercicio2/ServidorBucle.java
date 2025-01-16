package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorBucle {
    static final int Puerto = 2000;
    static volatile boolean continuar = true;

    public static void main(String[] arg) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto " + Puerto);
            System.out.println("Escribe el Comando:");

            Thread hiloComandos = new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (continuar) {

                    String comando = sc.nextLine();
                    if (comando.equalsIgnoreCase("salir")) {
                        continuar = false;
                        try {
                            skServidor.close();
                        } catch (Exception e) {
                            System.out.println("Error al cerrar el servidor: " + e.getMessage());
                        }
                    }
                }
                sc.close();
            });

            hiloComandos.start();

            while (continuar) {
                try {
                    Socket sCliente = skServidor.accept();
                    System.out.println("Cliente conectado.");

                    // Hilo para manejar la comunicación con el cliente
                    Thread hiloMensaje = new Thread(() -> {
                        try (DataInputStream input = new DataInputStream(sCliente.getInputStream());
                             DataOutputStream output = new DataOutputStream(sCliente.getOutputStream())) {

                            while (continuar) {
                                if (input.available() > 0) {
                                    String mensaje = input.readUTF();
                                    System.out.println("Mensaje del cliente: " + mensaje);
                                    output.writeUTF("Mensaje recibido del cliente");
                                    System.out.println("Escribe el Comando:");
                                }
                            }
                        } catch (Exception e) {
                            if (continuar) {
                                System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
                            }
                        } finally {
                            try {
                                sCliente.close();
                            } catch (Exception e) {
                                System.out.println("Error al cerrar la conexión del cliente: " + e.getMessage());
                            }
                        }
                    });

                    hiloMensaje.start();


                } catch (Exception e) {
                    if (continuar) {
                        System.out.println("Error al aceptar la conexión del cliente: " + e.getMessage());
                    }
                }
            }


            // Esperar a que el hilo de comandos termine antes de finalizar el programa
            hiloComandos.join();

        } catch (Exception e) {
            if (continuar) {
                System.out.println("Error en el servidor: " + e.getMessage());
            }
        }
        System.out.println("Servidor cerrado.");
    }
}
