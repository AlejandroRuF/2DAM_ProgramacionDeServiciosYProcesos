package Ejercicio2;


public class HiloIncrementaWaitAndNotify extends Thread{

    Contador cont;
    final Object lock;
    HiloDecrementaWaitAndNotify decre;

    public HiloIncrementaWaitAndNotify(Contador cont, Object lock, HiloDecrementaWaitAndNotify decre) {

        this.cont = cont;
        this.lock = lock;
        this.decre = decre;
    }

    public void incrementa(){

        cont.incrementar();

    }
    public  void run(){

        while (cont.getValor() < 100) {
            synchronized (lock) {


                incrementa();
                System.out.println(getName() + " ------> " + cont.getValor());
                lock.notify();


                try {
                    if (decre.isAlive()){
                        lock.wait();
                    }
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
