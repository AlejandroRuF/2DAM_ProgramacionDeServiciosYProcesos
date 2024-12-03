package Ejercicio4ConsumidorProductor;

public class Consumidor extends Thread {

    DatoCompartido dato;

    public Consumidor(DatoCompartido dato) {
        this.dato = dato;
    }


    public void run() {
        for (int i = 0; i < 10; i++) {

            dato.obtener();
            try
            {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }
}
