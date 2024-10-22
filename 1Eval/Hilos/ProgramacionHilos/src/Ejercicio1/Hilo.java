package Ejercicio1;

public class Hilo extends Thread{

    public Hilo(String nombre){

        super(nombre);

    }

    public void contador(){

        for (int i = 0; i < 100; i++) {

            System.out.println(getName()+"Nº"+i);

        }

    }

    public void run(){

        contador();

    }

    public static void main(String[] args) {

        Hilo a = new Hilo("Proceso 1");
        a.start();
        Hilo b = new Hilo("Proceso 2-----");
        b.start();

//        a.start();
//        b.start();

    }

}
