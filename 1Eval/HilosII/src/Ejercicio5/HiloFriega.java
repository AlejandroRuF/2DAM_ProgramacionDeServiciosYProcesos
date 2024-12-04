package Ejercicio5;

public class HiloFriega extends Thread {

    PilaPlatos pila;
    int num;

    public HiloFriega (int num, PilaPlatos pila){

        this.num = num;
        this.pila = pila;

    }

    public void run(){

        synchronized (pila) {
            for (int i = 0; i < num; i++) {

                while (pila.platos.size() >= 5) {
                    try {
                        pila.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                pila.lavar();
                try {
                    pila.wait(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                pila.notify();

            }
        }
    }

}
