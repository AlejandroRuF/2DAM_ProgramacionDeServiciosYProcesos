import java.util.ArrayList;
import java.util.Scanner;

public class MovAlfil {
    public static void main(String[] args) {

        String[][] tablero = new String[8][8];
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String posicion;

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                tablero[i][j] = letras[j]+String.valueOf(8-i);


                System.out.printf("%1s", tablero[i][j] + " ");
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posicion del alfil en el tablero");
        posicion = sc.nextLine();


        boolean letraCorrecto = false;
        boolean numCorrecto = false;
        boolean posok = false;

        while (!posok) {

            for (int i = 0; i < 8; i++) {

                if ((posicion.charAt(0) + "").equalsIgnoreCase(letras[i])) {
                    letraCorrecto = true;
                }

            }

            for (int i = 0; i < 8; i++) {

                if ((posicion.charAt(1) + "").equalsIgnoreCase(String.valueOf(i + 1))) {
                    numCorrecto = true;
                }

            }

            if (!letraCorrecto || !numCorrecto || (posicion.length() != 2)) {

                System.out.println("La Posicion introducida no existe, introduce una posicion Correcta");
                posicion = sc.nextLine();


            } else {
                posok = true;
            }

        }
        int columna = 0;
        int fila = 8 - (Integer.parseInt(posicion.charAt(1) + ""));

        for (int i = 0; i < letras.length; i++) {

            if ((posicion.charAt(0) + "").equalsIgnoreCase(letras[i])) {
                columna = i;

            }

        }

       // System.out.println(columna + "" + fila);

        ArrayList<String> poscionesPosibles = new ArrayList();
        int filaDiagonal = fila;
        int columnaDiagonal = columna;

        while (filaDiagonal != 0 && columnaDiagonal != 0) {

            filaDiagonal = filaDiagonal - 1;
            columnaDiagonal = columnaDiagonal - 1;


        }

        if (filaDiagonal != fila && columnaDiagonal != columna) {

            poscionesPosibles.add(letras[filaDiagonal]+""+(8-columnaDiagonal));

        }


        while (filaDiagonal != 7 && columnaDiagonal != 7) {

            filaDiagonal = filaDiagonal + 1;
            columnaDiagonal = columnaDiagonal + 1;

            if (filaDiagonal != fila && columnaDiagonal != columna) {

                poscionesPosibles.add(letras[filaDiagonal]+""+(8-columnaDiagonal));

            }


        }

        int filaDiagonalInversa = fila;
        int columnaDiagonalinversa = columna;

        while (filaDiagonalInversa != 0 && columnaDiagonalinversa != 7) {

            filaDiagonalInversa = filaDiagonalInversa - 1;
            columnaDiagonalinversa = columnaDiagonalinversa + 1;


        }

        if (filaDiagonalInversa != fila && columnaDiagonalinversa != columna) {

            poscionesPosibles.add(letras[filaDiagonalInversa]+""+(8-columnaDiagonalinversa));

        }

        while (filaDiagonalInversa != 7 && columnaDiagonalinversa != 0) {

            filaDiagonalInversa = filaDiagonalInversa + 1;
            columnaDiagonalinversa = columnaDiagonalinversa - 1;

            if (filaDiagonalInversa != fila && columnaDiagonalinversa != columna) {

                poscionesPosibles.add(letras[filaDiagonalInversa]+""+(8-columnaDiagonalinversa));

            }


        }

        System.out.println("Las posiciones posibles del alfil son: ");

        for (String pos : poscionesPosibles){

            System.out.print(pos+" ");

        }

    }
}


