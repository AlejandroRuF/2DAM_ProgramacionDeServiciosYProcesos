package Ejercicio1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int crearVirus = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de virus que quieres soltar en el pentagono");
        while (crearVirus == 0) {
            try {
                crearVirus = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Introduce un numero valido");
            }
        }



        int finalCrearVirus = crearVirus;
        Thread cargaVirus = new Thread(() -> {
            System.out.println("Numero de virus a ejecutar: " + finalCrearVirus);

            for (int i = 0; i < finalCrearVirus; i++) {

                Virus virus = new Virus(i+1);
                virus.run();

            }

        });
        cargaVirus.run();

    }

}
