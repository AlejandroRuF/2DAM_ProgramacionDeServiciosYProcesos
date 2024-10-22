package Ejercicio1;

public class Ejercicio1 extends Thread {

    public Ejercicio1(String nombre) throws InterruptedException {

        super(nombre);
        System.out.print("\nCreando Ejercicio1.Hilo " + getName());

        for (int i = 0; i < 10; i++) {

            Thread.sleep(100);
            System.out.print(".");

        }

    }

    public void contador() {

        for (int i = 0; i < 100; i++) {
            System.out.println("Ejercicio1.Hilo: "+getName() + "= " +i);
        }


    }

    public void run() {

        contador();

    }

    public static void main(String[] args) throws InterruptedException {

        Ejercicio1 hilo1 = new Ejercicio1("Hilo1");
        Ejercicio1 hilo2 = new Ejercicio1("Hilo2----");
        Ejercicio1 hilo3 = new Ejercicio1("Hilo3---------");

        hilo1.start();
        hilo2.start();
        hilo3.start();


    }

}
