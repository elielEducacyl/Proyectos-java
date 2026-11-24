import java.util.Random;
import java.util.Scanner;

public class matrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomizer = new Random();

        System.out.println("Ingrese el numero n: ");
        int n = scan.nextInt();

        int[][] matriz = new int[n][n];

        //NOTE: Asignamos numeros aleatorios a la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = randomizer.nextInt(100);
            }
        }

        //NOTE: Imprimir la matriz
        imprimir(matriz);

        System.out.println("===============EJERCICIOS===============");

        System.out.println("=================PRIMERO================");
        maximo(matriz, n);
        System.out.println("=================SEGUNDO================");
        diagonales(matriz, n);
        System.out.println("=================TERCERO================");
        sumVectorial(matriz, n);
        System.out.println("=================CUARTO=================");
        //permutacion(matriz, n, scan);
        System.out.println("==================QUINTO================");
        transposicion(matriz, n);
        System.out.println("==================SEXTO=================");
        //transNC(scan, randomizer);
        System.out.println("==================SEPTIMO=================");
        transpDos(matriz, n);
    }

    private static void transpDos(int[][] matriz, int n) {
        int cont = 0;
        int temp = 0;

        /*
         * Toma la matriz, el condicional verifica que
         * no se ejecute otra vez en los numeros la transpuestos
         * se hace una copia basica de matrices
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cont < j) {
                   temp = matriz[i][j];
                    matriz[i][j] = matriz[j][i];
                    matriz[j][i] = temp;
                }
            }
            cont++;
        }

        imprimir(matriz);
    }

    /**
     * Transpone una matriz n*n
     * @param matriz la matriz a transponer
     * @param n el tramaño de la matriz, para evitar redundancia
     */
    private static void transposicion(int[][] matriz, int n) {
        int[][] transposicion = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposicion[i][j] = matriz[j][i];
            }
        }

        imprimir(transposicion);
    }

    /**
     * Transposición de matrices no cuadradas
     *
     * @param scan Scanner, input
     * @param rand Random, numeros aleatorios
     */
    public static void transNC(Scanner scan, Random rand) {
        // Creacion de la matriz
        System.out.println("Ingrese el numero de columnas: ");
        int n = scan.nextInt();
        System.out.println("Ingrese el numero de filas: ");
        int m = scan.nextInt();
        System.out.println();

        int[][] matriz = new int[n][m];

        //Asignamos numeros aleatorios a la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = rand.nextInt(100);
            }
        }

        imprimir(matriz);
        System.out.println();

        int[][] transposicion = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposicion[j][i] = matriz[i][j];
            }
        }

        imprimir(transposicion);
    }

    private static void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println("}");
        }
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
            System.out.print(i + ", ");
            media += i;
        }
        System.out.println(" ");

        // Saca la media
        media /= n;
        System.out.println("media = " + media);
    }

    public static void diagonales(int[][] matriz, int n) {
        int[] vectorIzq = new int[n];
        int[] vectorDer = new int[n];
        int diagonalIzq = n - 1;
        //int total = 0;

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
            System.out.println("derecha: " + vectorDer[i] + ", izquierda: " + vectorIzq[i]);
        }
    }

    public static void sumVectorial(int[][] matriz, int n) {
        int[] filas = new int[n];
        int[] columnas = new int[n];
        int contFilas = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                columnas[i] += matriz[i][j];
                filas[contFilas] += matriz[i][j];
                contFilas++;
            }
            contFilas = 0;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("filas: " + filas[i] + ", columnas: " + columnas[i]);
        }
    }

    public static void permutacion(int[][] matriz, int n, Scanner in) {
        int num1 = 0;
        int num2 = 0;

        System.out.println("ingrese el primero numero: (de 0 a " + (n - 1) + ")");
        num1 = in.nextInt();
        System.out.println("ingrese el segundo numero: (de 0 a " + (n - 1) + ")");
        num2 = in.nextInt();

        if ((num1 < 0 || num1 > n) &&
                (num2 < 0 || num2 > n)) {
            System.out.println("ingrese un numero valido");
            return;
        }

        System.out.println("Quiere permutar filas o columnas? (f/c)");
        String seleccion = in.next();
        if (seleccion.equals("f")) {
            perFila(matriz, n, num1, num2);
        } else if (seleccion.equals("c")) {
            perColumna(matriz, n, num1, num2);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void perColumna(int[][] matriz, int n, int num1, int num2) {
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = matriz[i][num1];
            matriz[i][num2] = matriz[i][num1];
            matriz[i][num1] = temp;
        }
    }

    public static void perFila(int[][] matriz, int n, int col1, int col2) {
        int[] temp;

        temp = matriz[col1];
        matriz[col1] = matriz[col2];
        matriz[col2] = temp;
    }

}
