package Ejercicio4ConsumidorProductor;

public class Productor extends Thread {

    DatoCompartido dato;

    public Productor(DatoCompartido dato) {
        this.dato = dato;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {

            dato.poner(i);
            try
            {
                Thread.sleep(10);
            } catch (Exception e) {}

        }

    }

}
