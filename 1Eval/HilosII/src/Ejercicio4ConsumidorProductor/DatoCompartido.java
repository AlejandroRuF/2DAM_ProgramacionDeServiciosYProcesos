package Ejercicio4ConsumidorProductor;

public class DatoCompartido {
    int dato;
    boolean creado = false;
    public int obtener() {
        synchronized (this){
            while (!creado){
                try {
                    wait();
                }catch (Exception e){}
            }
            creado = false;
            System.out.println("Consumido --> "+ dato);
            notify();
            return dato;
        }
    }
    public void poner(int nuevoDato) {
        synchronized (this){
            while (creado) {
                try {
                    wait();
                } catch (Exception e) {
                }
            }
            creado = true;
            dato = nuevoDato;
            System.out.println("Producido --> "+ dato);
            notify();
        }

    }
}