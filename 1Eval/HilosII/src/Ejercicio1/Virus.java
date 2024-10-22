package Ejercicio1;

import java.util.Random;

public class Virus extends Thread{

    public int carga;
    public int[] porcentaje = {5,10};


    public Virus(int num){

        super(String.valueOf(num));

    }

    public void run(){


        int porciento;

        System.out.print("Virus "+getName()+":");

        while (carga < 100){
            Random rand = new Random();
            int aleatorio = rand.nextInt(porcentaje.length);
            porciento = porcentaje[aleatorio];
            if (carga >= 90) {

                porciento = 5;

            }
            carga += porciento;

//            System.out.print(porciento);
           if (porciento == 5){

               System.out.print("X");

           }else if (porciento == 10 ){

               System.out.print("XX");

           }


            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(" 100%");


    }

}
