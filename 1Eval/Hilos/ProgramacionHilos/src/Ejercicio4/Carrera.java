package Ejercicio4;
import java.util.ArrayList;
import java.util.List;

public class Carrera {

    public static void main(String[] args) {

        String[] corredores = { "Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah", "Bernard Lagat", "Rashid Ramzi",
                "Ryan Gregson", "Fermín Cacho", "Teddy Flack" };


        List<HilosCarrera> hilosCorredores = new ArrayList<HilosCarrera>();

        for (int i = 0; i < corredores.length; i++) {

            hilosCorredores.add(new HilosCarrera(corredores[i]));

        }

        for (HilosCarrera participantes: hilosCorredores){

            participantes.start();

        }

    }

}
