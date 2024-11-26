package Ejercicio3Jefe;

public class HiloJefe extends Thread {

    public static Object lock = HiloEmpleado.lock;
    String nombre;

    public HiloJefe(String nombre) {
        super(nombre);
    }

    public void run() {

        synchronized (lock) {
            HiloEmpleado.haEntrado = true;

            saludoJefe();
            lock.notifyAll();

        }
    }

    public void saludoJefe(){
        System.out.println("El Jefe ha entrado");

    }

}
