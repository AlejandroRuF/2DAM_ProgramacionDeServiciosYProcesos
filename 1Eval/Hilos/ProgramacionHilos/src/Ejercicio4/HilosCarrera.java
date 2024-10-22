package Ejercicio4;

public class HilosCarrera extends Thread {
    private int progreso = 0;

    public HilosCarrera(String nombre){

        super(nombre);

    }

    public void run(){

        for (int i = 0; i < 1500; i++) {

            progreso ++;

        }
        System.out.println(getName() + " ha terminado la carrera");


    }

}
