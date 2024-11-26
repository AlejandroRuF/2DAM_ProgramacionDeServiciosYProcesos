package Ejercicio2;

public class HiloDecrementaWaitAndNotify extends Thread{

    Contador cont;
    final Object lock;

    public HiloDecrementaWaitAndNotify(Contador cont, Object lock) {

        this.cont = cont;
        this.lock = lock;
    }

    public void decrementa(){

        cont.decrementar();

    }
    public void run(){

        for (int i = 0; i < 100; i++) {
            synchronized (lock) {


                decrementa();
                System.out.println(getName() + " ----> " + cont.getValor());
                lock.notify();


                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized (lock) {
            lock.notify();
        }

    }

}
