package Ejercicio7;

public class Sumador {

    public static int opera(int num1, int num2) {

        int resultado = 0;
        int mayor;
        int menor;
        if (num1 > num2) {
            mayor = num1;
             menor = num2;
        } else if (num2 > num1) {
            mayor = num2;
            menor = num1;

        }else {

            return num1;

        }

        for (int i = menor; i <= mayor ; i++) {

            resultado = resultado + i;

        }

        return resultado;
    }

    public static void main(String[] args) {

        try {

            int num = Integer.parseInt(args[0]);
            int num0 = Integer.parseInt(args[1]);

            System.out.println("El sumatorio entre los números existentes de los numeros proporcionados es "+opera(num,num0));

        }catch (Exception e){

            try {
                throw new Exception("Introduce los datos correctamente porfavor");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }


    }


}
