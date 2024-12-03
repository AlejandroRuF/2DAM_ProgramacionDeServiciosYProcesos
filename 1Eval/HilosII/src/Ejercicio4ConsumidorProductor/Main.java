package Ejercicio4ConsumidorProductor;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DatoCompartido dato = new DatoCompartido();

        Consumidor consumidor = new Consumidor(dato);
        Productor productor = new Productor(dato);

        productor.start();
        consumidor.start();

        productor.join();

        System.out.println("Fin");

    }

}
