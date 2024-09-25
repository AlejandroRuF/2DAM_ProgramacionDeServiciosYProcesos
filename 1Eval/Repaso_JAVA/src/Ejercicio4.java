import java.util.ArrayList;
import java.util.Random;

public class Ejercicio4 {

    public static void main(String[] args) {

        Random random = new Random();

        int repeticiones = random.nextInt(11)+10;

        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for (int i = 0; i < repeticiones; i++) {

            numeros.add(random.nextInt(100) );
            System.out.println(numeros.get(i));
        }

        int suma = numeros.stream()
                .mapToInt(a -> a).sum();

        int maximo = numeros.stream().mapToInt(a -> a).max().getAsInt();

        int minimo = numeros.stream().mapToInt(a -> a).min().getAsInt();

        int media = (int)numeros.stream().mapToInt(a -> a).average().getAsDouble();

    }

}
