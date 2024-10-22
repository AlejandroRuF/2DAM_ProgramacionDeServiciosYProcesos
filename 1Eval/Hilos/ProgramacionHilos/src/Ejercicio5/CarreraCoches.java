package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarreraCoches {

    public static void main(String[] args) {

        int competidores = 0;
        Scanner sc = new Scanner(System.in);
        String[] marcas = {"Volkswagen", "Seat","Toyota", "Ford", "Chevrolet", "BMW", "Audi", "Mercedes-Benz", "Honda", "Nissan"};
        Random rand = new Random();
        List<HiloCoches> coches = new ArrayList<>();
        System.out.print("Cuantos coches participaran en la carrera? -->  ");
        competidores = sc.nextInt();

        for (int i = 0; i < competidores; i++) {

            int num = rand.nextInt(marcas.length);
            coches.add(new HiloCoches(marcas[num],i+1));

        }

        for (HiloCoches coch : coches) {

            coch.start();

        }
        

    }

}
