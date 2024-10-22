package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Simple extends Thread {
    private static int contador = 0;

    public Simple(String nombre){
        super(nombre);
    }


    public void run(){

        for (int i = 0; i < 1000; i++) {
            contador++;
        }
    }

    public static int getContador() {
        return contador;
    }

    public static void main(String[] args) throws InterruptedException {

        List<Simple> lista = new ArrayList<Simple>();

        for (int i = 0; i < 5; i++) {

            lista.add(new Simple("Ejercicio1.Hilo"+i));

        }
        for (int i = 0; i < lista.size(); i++) {

            lista.get(i).start();

        }

        System.out.println(getContador());
    }

}
