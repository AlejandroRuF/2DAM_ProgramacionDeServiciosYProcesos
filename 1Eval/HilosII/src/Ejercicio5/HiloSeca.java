package Ejercicio5;

public class HiloSeca extends Thread {

    PilaPlatos pila;
    int num;

    public HiloSeca (int num, PilaPlatos pila){

        this.num = num;
        this.pila = pila;

    }

    public void run(){
        for (int i = 0; i < num; i++) {
            synchronized (pila) {


                    while (pila.platos.size() <= 0) {
                        try {
                            pila.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    pila.secar();
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    pila.notify();

            }
        }
    }

}
