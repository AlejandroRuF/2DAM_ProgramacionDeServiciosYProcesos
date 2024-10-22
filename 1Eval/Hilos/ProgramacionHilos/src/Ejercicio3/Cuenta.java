package Ejercicio3;

public class Cuenta {

    private int saldo = 10000;

    public int getSaldo(){
        return saldo;
    }

    public void restar(int valor){
        saldo -= valor;
    }

    public void retirarDinero(int valor, String nom){

        if (valor <= this.getSaldo()){

            restar(valor);
            System.out.println(nom+" retira ->"+valor+" SE VA A RETIRAR SALDO (ACTUAL ES:\n"+getSaldo()+")");

        }else {

            System.out.println(nom+" No puede retirar dinero, NO HAY SALDO(\nsaldo actual: "+getSaldo()+")");

        }

    }


}
