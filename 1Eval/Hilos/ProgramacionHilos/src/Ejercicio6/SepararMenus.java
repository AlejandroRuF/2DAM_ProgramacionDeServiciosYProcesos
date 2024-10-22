package Ejercicio6;

public class SepararMenus {

    public static void main(String[] args) {

        HiloPrimeros hiloPrimeros = new HiloPrimeros();
        HiloSegundos hiloSegundos = new HiloSegundos();
        HiloPostres hiloPostres = new HiloPostres();

        hiloPrimeros.start();
        hiloSegundos.start();
        hiloPostres.start();

    }

}
