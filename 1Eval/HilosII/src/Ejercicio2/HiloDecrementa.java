package Ejercicio2;

public class HiloDecrementa extends Thread{

    Contador cont;
    final Object lock;

    public HiloDecrementa(Contador cont, Object lock) {

        this.cont = cont;
        this.lock = lock;
    }

    public synchronized void decrementa(){

        cont.decrementar();

    }
    public void run(){

        for (int i = 0; i < 100; i++) {
            synchronized (lock) {


                decrementa();
                System.out.println(getName() + " ----> " + cont.getValor());
                lock.notify();

            }
        }
    }

}
