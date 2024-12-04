package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class PilaPlatos {
    int ultimoPlato;

    List<Plato> platos = new ArrayList<Plato>();

    public PilaPlatos() {
        ultimoPlato = 0;
    }

    public void lavar (){

        if (platos.size() < 5){
            Plato p = new Plato(ultimoPlato+1);
            platos.add(p);
            ultimoPlato++;

            System.out.println("Plato lavado #"+ p.idPlato+ ", total platos en la pila : "+platos.size());
        }

    }

    public void secar(){

        if (platos.size() > 0){

            Plato platoSeco = platos.getFirst();
            platos.remove(platoSeco);
            System.out.println("---Plato secado #"+ platoSeco.idPlato+ ", total platos en la pila : "+platos.size());;

        }

    }

}
