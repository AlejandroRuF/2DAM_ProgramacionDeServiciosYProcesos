package Ejercicio3Jefe;

public class Main {

    public static void main(String[] args) {

        HiloEmpleado emp1 = new HiloEmpleado("Juan");
        HiloEmpleado emp2 = new HiloEmpleado("Alberto");
        HiloEmpleado emp3 = new HiloEmpleado("Nacho");
        HiloJefe jefe = new HiloJefe("Pepe");
        HiloEmpleado emp4 = new HiloEmpleado("Jose");
        HiloEmpleado emp5 = new HiloEmpleado("Alejandro");
        HiloEmpleado emp6 = new HiloEmpleado("Prudencio");

        emp1.start();
        emp2.start();
        emp3.start();
        emp4.start();
        emp5.start();
        emp6.start();
        jefe.start();

    }

}
