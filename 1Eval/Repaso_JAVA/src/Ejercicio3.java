import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio3 {

    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<String>();

        nombres.add("Emilia");
        nombres.add("Nacho");
        nombres.add("Enrique");
        nombres.add("Alejandro");
        nombres.add("Prudencio");

        Iterator<String> iteratorNombres = nombres.iterator();
        while (iteratorNombres.hasNext()) {
            System.out.println(iteratorNombres.next());
        }
    }

}
