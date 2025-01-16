package Ejercicio2;

public class ComandoSalida {

    static String comandoSalida = "";

    public synchronized String getComandoSalida() {
        return comandoSalida;
    }

    public synchronized void setComandoSalida(String comandoSalida) {
        this.comandoSalida = comandoSalida;
    }




}
