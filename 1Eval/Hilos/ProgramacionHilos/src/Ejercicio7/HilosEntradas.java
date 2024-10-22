package Ejercicio7;

import java.util.Random;

public class HilosEntradas extends Thread{

    ReservaEntradas reserva;

    public HilosEntradas(String nombre, ReservaEntradas reserva){

        super(nombre);
        this.reserva = reserva;

    }

    public void run(){

        reserva.reservaEntradass(getName());

    }

}
