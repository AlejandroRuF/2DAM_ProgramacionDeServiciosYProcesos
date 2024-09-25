import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String numero;
        System.out.println("Por favor, vaya introduciendo números enteros. Escribe salir para terminar");
        boolean Entero = false;
        for (int i = 0; i < 20; i++) {

            Entero= false;

            while (!Entero) {

                Entero= false;
                System.out.print(i + 1 + ": ");
                numero = sc.next();
                if (numero.equalsIgnoreCase("salir")){
                    i = 25;
                    break;
                }


                try {

                    Integer.parseInt(numero);
                    Entero = true;

                } catch (Exception e) {
//                throw new Exception("El dato introducido no es correcto, debe ser un número entero.\n" +
//                        "Por favor, inténtelo de nuevo.");
                    System.err.println("El dato introducido no es correcto, debe ser un número entero.\\n\" +\n" +
                            "Por favor, inténtelo de nuevo.\n");


                }
            }

        }


    }

}
