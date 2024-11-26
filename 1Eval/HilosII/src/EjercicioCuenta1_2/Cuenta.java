package EjercicioCuenta1_2;

public class Cuenta {

    private int saldo = 10000;

    public int getSaldo(){
        return saldo;
    }

    public void restar(int valor){
        saldo -= valor;
    }

    public void sumar(int valor){
        saldo += valor;
    }

    public void retirarDinero(int valor, String nom, int operacion) {

        if (operacion == 0) {

            if (valor <= this.getSaldo()) {

                restar(valor);
                System.out.println(nom + " RETIRO ->" + valor + " SE VA A RETIRAR SALDO \n(ACTUAL ES:" + getSaldo() + ")");

            } else {

                System.out.println(nom + " No puede retirar dinero, NO HAY SALDO\n(saldo actual: " + getSaldo() + ")");

            }

        }if (operacion == 1) {

            sumar(valor);
            System.out.println(nom + " INGRESO ->" + valor + " SE VA A Ingresar SALDO \n(ACTUAL ES:" + getSaldo() + ")");

        }
    }


}
