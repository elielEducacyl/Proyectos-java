import java.util.Random;
import java.util.Scanner;

public class matrices {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomizer = new Random();

        System.out.println("Ingrese el numero n: ");
        int n = scan.nextInt();

        int[][] matriz = new int[n][n];

        //NOTE: Asignamos numeros aleatorios a la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = randomizer.nextInt(100)+1;
            }
        }

        //NOTE: Imprimir la matriz
        for (int[] ints : matriz) {
            System.out.print("{ ");
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println("},");
        }

        System.out.println("===============EJERCICIOS===============");

        //maximo(matriz, n);
        diagonales(matriz, n);

    }

    /*
     * Suma los numeros en las matrices de la segunda dimencion en un solo vector
     * Luego saca la media de estos
     */
    public static void maximo(int[][] matriz, int n) {
       int[] vector = new int[n];
       int media = 0;

       //NOTE: sumar los valores de los arrays segundarios en un vector
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vector[i] += matriz[i][j];
            }
        }

        // imprimie y los suma en una sola variable
        for (int i : vector) {
            System.out.print(i +", ");
            media += i;
        }
        System.out.println(" ");

        // Saca la media
        media /= n;
        System.out.println("media = " + media);
    }

    public static void diagonales (int[][] matriz, int n) {
       int [] vectorIzq = new int[n];
       int [] vectorDer = new int[n];
       int diagonalIzq = n - 1;
       int total = 0;

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (diagonalIzq == j) {
                   vectorIzq[i] += matriz[i][j];
                   diagonalIzq--;
               }
               if (i == j) {
                   vectorDer[i] += matriz[i][j];
               }
           }
       }

       for (int i = 0; i < n; i++) {
            total = vectorIzq[i] + vectorDer[i];
       }

        System.out.println("Derecha: ");
       for (int i = 0; i < n; i++) {
           System.out.println("derecha: " + vectorDer[i]);
       }
       for (int i = 0; i < n; i++) {
           System.out.println("Izquierda: " + vectorIzq[i]);
       }
        System.out.println("Total: " + total);
    }
}
