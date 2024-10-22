package Ejercicio7;

import java.util.Random;

public class ReservaEntradas {

    public static int entradasDisponibles = 100;
    public static int entradasVendidas = 0;


    public void reservaEntradass(String nombre){
        Random rand = new Random();
        int entradasAReservar = rand.nextInt(19)+1;

        if (entradasAReservar <= entradasDisponibles){

            entradasDisponibles -= entradasAReservar;
            entradasVendidas += entradasAReservar;
            System.out.println(nombre+" ha reservado "+entradasAReservar+" entradas");

        }else {

            System.out.println("Lo siento "+nombre+" ya no quedan mas entradas para vender");

        }

    }

}
