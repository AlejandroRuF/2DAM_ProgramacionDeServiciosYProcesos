package Ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio8 {

    public static void main(String[] args) {
        Thread pares = new Thread(() -> {

            System.out.print("Pares ->  ");

            IntStream.rangeClosed(1,50)
                    .filter(n -> n % 2 == 0)
                    .forEach(n -> System.out.printf("%3d",n));

        });

        pares.run();

        System.out.println();

        Thread impares = new Thread(() -> {

            System.out.print("Impares ->");

            IntStream.rangeClosed(1,50)
                    .filter(n -> n % 2 != 0)
                    .forEach(n -> System.out.printf("%3d",n));

        });

        impares.run();
    }




}
