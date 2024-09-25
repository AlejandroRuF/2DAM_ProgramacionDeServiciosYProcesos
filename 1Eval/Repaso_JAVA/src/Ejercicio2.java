public class Ejercicio2 {

    public static void main(String[] args) {

        int [][] numeros = new int[3][6];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[0].length; j++) {

                numeros[i][j] = 0;

            }
        }

        numeros[0][1] = 30;
        numeros[0][2] = 2;
        numeros[0][5] = 5;
        numeros[1][0] = 75;
        numeros[2][2] = -2;
        numeros[2][5] = 11;
        numeros[2][3] = 9;

        for (int i = 0; i < numeros[0].length; i++) {

            System.out.printf("%15s","Columna"+i);
        }
        System.out.println();

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("%-10s","Fila"+i);
            for (int j = 0; j < numeros[0].length; j++) {

                System.out.printf("%-15s",numeros[i][j]);

            }
            System.out.println();

        }



    }

}
