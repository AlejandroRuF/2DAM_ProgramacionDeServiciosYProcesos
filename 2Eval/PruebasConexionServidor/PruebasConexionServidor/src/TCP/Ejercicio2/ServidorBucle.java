package TCP.Ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBucle {
    static final int Puerto = 2000;
    static volatile boolean continuar = true;
    static volatile String comando = "";

    public static void main(String[] arg) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto " + Puerto);

            Thread hiloComandos = new Thread(() -> {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    while (continuar) {
                        System.out.print("Escribe el Comando: ");
                        while (System.in.available() == 0 && continuar) {
                            Thread.sleep(100);
                        }
                        if (!continuar) break;

                        comando = br.readLine();

                        if (comando.equalsIgnoreCase("salir")) {
                            continuar = false;
                            skServidor.close();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error en la lectura del comando: " + e.getMessage());
                }
            });

            hiloComandos.setDaemon(true);
            hiloComandos.start();

            while (continuar) {
                try {
                    Socket sCliente = skServidor.accept();
                    System.out.println("Cliente conectado.");

                    Thread hiloMensaje = new Thread(() -> {
                        try (DataInputStream input = new DataInputStream(sCliente.getInputStream());
                             DataOutputStream output = new DataOutputStream(sCliente.getOutputStream())) {

                            while (continuar) {
                                if (input.available() > 0) {
                                    String mensaje = input.readUTF();
                                    System.out.println("Mensaje del cliente: " + mensaje);
                                    output.writeUTF("Mensaje recibido del cliente");

                                    if (mensaje.equalsIgnoreCase("salir")) {
                                        continuar = false;
                                        skServidor.close();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
                        }
                    });

                    hiloMensaje.setDaemon(true);
                    hiloMensaje.start();
                } catch (Exception e) {
                    if (continuar) {
                        System.out.println("Error al aceptar la conexión del cliente: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
        System.out.println("Servidor cerrado.");
    }
}
