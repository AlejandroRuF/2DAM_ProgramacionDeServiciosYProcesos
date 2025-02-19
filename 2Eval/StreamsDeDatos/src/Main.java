import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String opcion = "";
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scChar = new Scanner(System.in);
        List<Profesional> profesionales = new ArrayList<>();
        try {
            profesionales.add(new Profesional("Carlos Pérez", 30, 'M', 1));
            profesionales.add(new Profesional("Ana Gómez", 28, 'F', 2));
            profesionales.add(new Profesional("Luis Rodríguez", 35, 'M', 3));
            profesionales.add(new Profesional("María López", 40, 'F', 1));
            profesionales.add(new Profesional("Pedro Martínez", 25, 'M', 2));
            profesionales.add(new Profesional("Sofía Herrera", 33, 'F', 3));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        while (!opcion.equals("4")){

            System.out.print("SOFTWARE DE GESTIÓN DEL IBIS SPORT CLUB\n" +
                    "=======================================\n" +
                    "1. Introducir datos de un profesional\n" +
                    "2. Consulta con filtro\n" +
                    "3. Listado de nombres\n" +
                    "4. Salir\n" +
                    "Introduce una Opcion -> ");

            opcion = scString.nextLine();

            switch (opcion){

                case "1":
                    System.out.println("Introduce los datos del profesional");
                    String nombre = "";
                    int edad = 0;
                    char genero = ' ';
                    int profesional = 0;
                    System.out.println("Introduce el nombre del profesional:");
                    nombre = scString.nextLine();
                    System.out.println("Introduce la edad del profesional:");
                    edad = scInt.nextInt();
                    System.out.println("Introduce el genero del profesional (M/F):");
                    genero = scChar.next().charAt(0);
                    System.out.println("Introduce el tipo de profesional (1: Jugador, 2: Directivo, 3: Fisio):");
                    profesional = scInt.nextInt();
                    try {
                        Profesional p = new Profesional(nombre, edad, genero, profesional);
                        profesionales.add(p);
                        System.out.println("Profesional añadido correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    String opcion2 = "";
                    while (!opcion2.equalsIgnoreCase("4")) {
                        System.out.println("Submenú de Consultas\n" +
                                "--------------------\n" +
                                "1. Profesionales por género\n" +
                                "2. Profesionales por tipo\n" +
                                "3. Profesionales por edad\n" +
                                "4. Volver");

                        opcion2 = scString.nextLine();
                        switch (opcion2){
                            case "1":
                                System.out.println("Profesionales genero masculino:");
                                profesionales.stream()
                                    .filter(p -> p.getGenero() == 'M' || p.getGenero() == 'm')
                                    .forEach(p-> System.out.println(p));
                                System.out.println("Profesionales genero femenino:");
                                profesionales.stream()
                                    .filter(p -> p.getGenero() == 'F' || p.getGenero() == 'f')
                                    .forEach(p-> System.out.println(p));
                                break;

                            case "2":
                                System.out.println("Profesionales tipo Jugador:");
                                profesionales.stream()
                                    .filter(p -> p.getProfesional() == 1)
                                    .forEach(p-> System.out.println(p));
                                System.out.println("Profesionales tipo Directivo:");
                                profesionales.stream()
                                    .filter(p -> p.getProfesional() == 2)
                                    .forEach(p-> System.out.println(p));
                                System.out.println("Profesionales tipo Fisio:");
                                profesionales.stream()
                                    .filter(p -> p.getProfesional() == 3)
                                    .forEach(p-> System.out.println(p));
                                break;

                            case "3":
                                System.out.println("Introduce la edad mínima:");
                                int edadMin = scInt.nextInt();
                                System.out.println("Introduce la edad máxima:");
                                int edadMax = scInt.nextInt();

                                profesionales.stream()
                                    .filter(p -> p.getEdad() >= edadMin && p.getEdad() <= edadMax)
                                    .forEach(p-> System.out.println(p));
                                break;

                            case "4":
                                System.out.println("Saliendo al menu principal");
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("Listado de nombres:");
                    profesionales.stream()
                            .map(p -> p.getNombre())
                            .forEach(System.out::println);
                    break;

                case "4":
                    System.out.println("Saliendo del programa");
                    break;
            }

        }

    }

}
