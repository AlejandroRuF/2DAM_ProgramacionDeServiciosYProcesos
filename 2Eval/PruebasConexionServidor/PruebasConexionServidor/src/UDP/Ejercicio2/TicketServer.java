package UDP.Ejercicio2;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketServer {

    static byte[] buffer = new byte[1024];
    static DatagramPacket recibir = new DatagramPacket(buffer, buffer.length);
    static  HashMap<String, String> butacasOcupadas = new HashMap<>();
    static List<String> enEspera = new ArrayList<String>();

    public static void main(String[] args) {
        int puertoServer = 12345;
        int butacasDisponibles = 4;
        butacasOcupadas.put("1", "Vacio");
        butacasOcupadas.put("2", "Vacio");
        butacasOcupadas.put("3", "Vacio");
        butacasOcupadas.put("4", "Vacio");
        String comando = "";



        try (DatagramSocket socket = new DatagramSocket(puertoServer)) {
            System.out.println("Servidor activo en el puerto " + puertoServer);

            while (!comando.equalsIgnoreCase("salir")) {

                String opcionMenu = recibirMensaje(socket);

                switch (opcionMenu) {
                    case "1":

                        enviarRespuesta(disponibilidad(), socket);
                        enviarRespuesta("seguir", socket);

                        break;

                    case "2":
                        enviarRespuesta("Introduce tu nombre", socket);
                        enviarRespuesta("escribe", socket);
                        String nombre = recibirMensaje(socket);
                        boolean estaReserva = estaReserva(nombre);
                        boolean estaEspera = estaEspera(nombre);


                        if (butacasDisponibles > 0 && !estaReserva) {

                            butacasOcupadas.put(String.valueOf((butacasOcupadas.size()-butacasDisponibles)+1), nombre);
                            butacasDisponibles--;
                            enviarRespuesta("seguir", socket);


                        } else if (!estaEspera){
                            enEspera.add(nombre);
                            enviarRespuesta("No hay butacas disponibles, te pondremos en la lista de espera" +
                                    "\n"+disponibilidad(), socket);
                            enviarRespuesta("seguir", socket);

                        }else {
                            enviarRespuesta("Ya tienes una butaca reservada o estas en la lista" +
                                    " de espera", socket);
                            enviarRespuesta("seguir", socket);

                        }
                        break;

                    case "3":
                        enviarRespuesta("Introduce tu nombre", socket);
                        enviarRespuesta("escribe", socket);

                        String nombre2 = recibirMensaje(socket);
                        boolean estaEsperas = estaEspera(nombre2);
                        boolean estaReservas = estaReserva(nombre2);

                        if (estaReservas) {
                            for (String clave : butacasOcupadas.keySet()) {
                                if (butacasOcupadas.get(clave).equalsIgnoreCase(nombre2)) {
                                    butacasOcupadas.put(clave, "Vacio");
                                    butacasDisponibles++;
                                    break;
                                }
                            }
                            enviarRespuesta("Butaca liberada" +
                                    "\n"+disponibilidad(), socket);
                            enviarRespuesta("seguir", socket);

                        } else if (estaEsperas) {
                            enEspera.remove(nombre2);
                            enviarRespuesta("No tienes una butaca reservada, pero has sido eliminado de la lista de espera", socket);
                            enviarRespuesta("seguir", socket);

                        } else {
                            enviarRespuesta("No tienes una butaca reservada", socket);
                            enviarRespuesta("seguir", socket);

                        }

                        break;

                    case "4":

                        enviarRespuesta("Saliendo del servidor", socket);
                        enviarRespuesta("seguir", socket);
                        break;

                    case "123":
                        enviarRespuesta("Servidor apagado, apagando cliente", socket);
                        System.out.println("Apagando Servidor");
                        enviarRespuesta("seguir", socket);

                        comando = "salir";
                        break;

                    default:
                        enviarRespuesta("Opción no válida", socket);
                        enviarRespuesta("seguir", socket);
                        break;


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviarRespuesta(String mensaje, DatagramSocket socket) {
        try {
            byte[] respuestaBuffer = mensaje.getBytes();
            InetAddress clientAddress = recibir.getAddress();
            int clientPort = recibir.getPort();
            DatagramPacket envio = new DatagramPacket(respuestaBuffer, respuestaBuffer.length, clientAddress, clientPort);

            socket.send(envio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean estaEspera(String nombre){
        boolean esta = false;

        for (String nom: enEspera) {
            if (nom.equals(nombre)) {
                esta = true;
            }
        }
        return esta;

    }
    public static boolean estaReserva(String nombre){

        boolean esta = false;

        for (String nom : butacasOcupadas.values()) {
            if (nom.equalsIgnoreCase(nombre)) {
                esta = true;
            }
        }

        return esta;
    }

    public static String recibirMensaje(DatagramSocket socket){

        try {
            socket.receive(recibir);
            String respuesta = new String(recibir.getData(), 0, recibir.getLength()).trim();
            return respuesta;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String disponibilidad() {
        String ocupadas = "Estado de las butacas:\n";
        for (String clave : butacasOcupadas.keySet()) {
            ocupadas += (clave + " -> " + butacasOcupadas.get(clave) + "\n");
        }
        if (enEspera.size() > 0) {

            ocupadas += "\nClientes en espera para conseguir una Butaca:\n";
            for (String cliente : enEspera) {
                ocupadas += cliente + "\n";
            }
        } else {
            ocupadas += "No hay clientes en espera\n";
        }

        return ocupadas;
    }

}


