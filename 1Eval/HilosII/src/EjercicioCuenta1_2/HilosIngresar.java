package EjercicioCuenta1_2;

import java.util.Random;

public class HilosIngresar extends Thread {
    private Cuenta cuenta;
    private Random rand = new Random();

    public HilosIngresar(String nombre, Cuenta cuenta){

        super(nombre);
        this.cuenta = cuenta;

    }


    public void run(){
        synchronized(cuenta){
            for (int i = 0; i < 100; i++){
                System.out.println(Thread.currentThread().getName());
                int aRetirar = rand.nextInt(41);
                cuenta.retirarDinero(aRetirar,getName(),1);
            }
        }

    }



}
