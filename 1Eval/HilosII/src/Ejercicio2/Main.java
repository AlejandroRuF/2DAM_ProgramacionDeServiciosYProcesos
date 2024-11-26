package Ejercicio2;

public class Main {

    public static void main(String[] args) {
//        Contador contador = new Contador(0);
        Object lock = new Object();
//
//        HiloDecrementaWaitAndNotify decrementaconWait = new HiloDecrementaWaitAndNotify(contador,lock);
//        HiloIncrementaWaitAndNotify incrementaConWait = new HiloIncrementaWaitAndNotify(contador,lock,decrementaconWait);
//
//
//        decrementaconWait.start();
//        incrementaConWait.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Contador cont = new Contador(0);

        HiloIncrementa incrementa = new HiloIncrementa(cont,lock);
        HiloDecrementa decrementa = new HiloDecrementa(cont,lock);

        decrementa.start();
        incrementa.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Valor Total "+cont.getValor());

    }
}
