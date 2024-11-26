package Ejercicio3Jefe;

public class HiloEmpleado extends Thread {

    public static boolean haEntrado = false;
    public String nombre;
    public static Object lock = new Object();

    public HiloEmpleado(String nombre) {

        super(nombre);

    }

    public void run() {
        synchronized (lock) {

            if (!haEntrado) {

                System.out.println(getName()+" ha entrado a trabajar");
                try {
                    lock.wait();
                } catch (InterruptedException e) {

                }

            }

           saludoEmpleado();

        }
    }

    public  void saludoEmpleado(){
        System.out.println(getName()+": Buenos Dias jefe!");

    }
}
