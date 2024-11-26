package Ejercicio2;


public class HiloIncrementa extends Thread{

    Contador cont;
    final Object lock;

    public HiloIncrementa(Contador cont, Object lock) {

        this.cont = cont;
        this.lock = lock;
    }

    public void incrementa(){

        cont.incrementar();

    }
    public  void run(){

        while (cont.getValor() < 100) {
            synchronized (lock) {


                incrementa();
                System.out.println(getName() + " ------> " + cont.getValor());

            }
        }
    }

}
