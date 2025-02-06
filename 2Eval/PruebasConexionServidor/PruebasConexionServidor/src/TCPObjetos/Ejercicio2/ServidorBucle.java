package TCPObjetos.Ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorBucle {
    static final int Puerto = 2000;
    static volatile boolean continuar = true;
    static volatile String comando = "";

    public static void main(String[] arg) throws IOException {

        try (ServerSocket skServidor = new ServerSocket(Puerto)) {
            System.out.println("Escuchando en el puerto " + Puerto);
            AtomicBoolean comprobado = new AtomicBoolean(false);

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
                        try (InputStream entrada = sCliente.getInputStream();
                             ObjectInputStream input = new ObjectInputStream(entrada);
                             DataOutputStream output = new DataOutputStream(sCliente.getOutputStream())) {

                            while (continuar) {
                                String mensaje = "";
                                if (entrada.available() > 0) {
                                    Object objetoRecibido = input.readObject();
                                    if (objetoRecibido instanceof ArrayList) {
                                        ArrayList<Persona> lista = (ArrayList<Persona>) objetoRecibido;
                                        System.out.println("Mensaje del Cliente:");
                                        for (Persona persona: lista){
                                            if (persona instanceof Persona ){
                                                System.out.println("    "+persona);

                                            }
                                        }

                                        System.out.println("Escribe el comando salir para apagar el servidor");
                                    }

                                    if (mensaje.equalsIgnoreCase("salir")) {
                                        output.writeUTF("Mensaje recibido del cliente");
                                        continuar = false;
                                        skServidor.close();
                                    } else {

                                        output.writeUTF("Mensaje recibido del cliente\n" + mensaje);
                                    }
                                }
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
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

    public static String fechaHoy() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatear);
    }
}