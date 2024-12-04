package Ejercicio5;

public class Main {

    public static void main(String[] args) {
        int numPlatos = 20;

        PilaPlatos pilaPlatos = new PilaPlatos();
        HiloSeca hiloSeca = new HiloSeca(numPlatos, pilaPlatos);
        HiloFriega hiloFriega = new HiloFriega(numPlatos, pilaPlatos);

        hiloSeca.start();
        hiloFriega.start();

    }

}
