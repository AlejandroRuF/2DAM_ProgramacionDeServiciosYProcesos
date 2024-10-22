package Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ReservaEntradas reserva = new ReservaEntradas();

        List<HilosEntradas> compradores = new ArrayList<HilosEntradas>();

        String[] nombres = {"Juan", "María", "Carlos", "Ana", "Luis", "Sofía", "Miguel", "Laura", "Jorge", "Elena"};

        for (String nom : nombres) {

            compradores.add(new HilosEntradas(nom,reserva));

        }

        for (HilosEntradas entrada : compradores) {

            entrada.start();

        }

        Thread.sleep(1000);
        System.out.println("Total entradas vendidas: "+ReservaEntradas.entradasVendidas);

    }

}
