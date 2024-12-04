package Ejercicio5;

public class Main {

    public static void main(String[] args) {

        PilaPlatos pilaPlatos = new PilaPlatos();
        HiloSeca hiloSeca = new HiloSeca(20, pilaPlatos);
        HiloFriega hiloFriega = new HiloFriega(20, pilaPlatos);

        hiloSeca.start();
        hiloFriega.start();

    }

}
