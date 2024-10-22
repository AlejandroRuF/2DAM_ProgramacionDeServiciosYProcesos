package Ejercicio3;

import java.util.Random;

public class Hilos extends Thread {
    private Cuenta cuenta;
    private Random rand = new Random();

    public Hilos(String nombre, Cuenta cuenta){

        super(nombre);
        this.cuenta = cuenta;

    }


    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName());
            int aRetirar = rand.nextInt(41);
            cuenta.retirarDinero(aRetirar,getName());
        }
    }



}
