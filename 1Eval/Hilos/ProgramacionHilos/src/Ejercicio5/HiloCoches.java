package Ejercicio5;

import java.util.Random;

public class HiloCoches extends Thread {

    private Random rand = new Random();
    private int recorrido = 0;
    private boolean meta = false;

    public HiloCoches(String nombre,int numero) {

        super(nombre+"("+String.valueOf(numero)+")");

    }

    public void run() {

        while(recorrido < 500) {
        recorrido += rand.nextInt(100);

            if (recorrido < 500){
            System.out.println(getName()+" lleva recorrido: "+recorrido);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("--------------------------------------------------------------------\n"+getName()+" ha finalizado el recorrido al recorrer "+recorrido);
        meta = true;
//            Thread.currentThread().interrupt();



    }

}
