package EjercicioCuenta1_2;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.List;

public class SacarDinero {

    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta();
        List<Thread> nombres = new ArrayList<Thread>();
        nombres.add(new HilosRetirar("Juan",cuenta));
        nombres.add(new HilosRetirar("Ana",cuenta));
        nombres.add(new HilosIngresar("Manola",cuenta));
        nombres.add(new HilosIngresar("Jose",cuenta));

        for (Thread hilo : nombres) {
            hilo.start();

        }

    }

}
