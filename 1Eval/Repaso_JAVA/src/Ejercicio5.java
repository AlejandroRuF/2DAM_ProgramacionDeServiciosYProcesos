import java.util.ArrayList;
import java.util.Comparator;

public class Ejercicio5 {

    public static void main(String[] args) {

        ArrayList<String> palabras = new ArrayList<>();

        // Añadir las palabras al ArrayList
        palabras.add("php");
        palabras.add("java");
        palabras.add("c");
        palabras.add("c++");
        palabras.add("c#");
        palabras.add("javascript");
        palabras.add("python");
        palabras.add("pascal");
        palabras.add("SQL");
        palabras.add("Ruby");

        palabras.stream()
                .sorted()
        .forEach(System.out::println);

    }

}
