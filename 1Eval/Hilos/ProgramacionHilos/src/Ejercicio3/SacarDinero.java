package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class SacarDinero {

    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta();
        List<Hilos> nombres = new ArrayList<Hilos>();
        nombres.add(new Hilos("Juan",cuenta));
        nombres.add(new Hilos("Ana",cuenta));

        for (Hilos hilo : nombres) {
            hilo.start();

        }

    }

}
