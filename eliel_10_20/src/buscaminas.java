import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class buscaminas {

    //TODO Crear metodo para ingreo del usuario
    //TODO Crear metodo para detectar que tan cerca estan las minas

    static char MINA = '*';

    public static void main(String[] args) {

        System.out.println("Ingrese el tamaño del tablero: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        char[][] tablero  = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = '-';
            }
        }

        int[] posMinas = crearMinas(tablero, n);

        imprimirTablero(tablero);

        rastrear(tablero);

        imprimirTablero(tablero);

    }

    /**
     * Crea una nueva matriz la cual tenga las minas
     * la crea consiguendo un numero aleatorio dependiendo del tamaño
     * de la matriz creada
     *
     * @param tablero tablero inicial, se usa para sber la cantidad de minas que crear
     * @param n para crear la nueva matriz
     * @return Devuelve donde se encuentran las minas
     */
    private static int[] crearMinas(char[][] tablero, int n) {
        Random rand = new Random();

        // NOTE: conseguimos una cantidad de minas aleatorea
        int cantMinas = n-1;
        int[] posMinas = new int[cantMinas]; // Aqui guardaremos las direcciones de las minas

        //NOTE: conseguimos la direccion de las minas
        for (int i = 0; i < cantMinas; i++) {
            posMinas[i] = rand.nextInt(n*n);
        }
        //for (int i : posMinas) System.out.println(i); //Debuggin

        for (int  i=0; i < cantMinas; i++) {
            colocar(tablero, posMinas[i], MINA);
       }

        return posMinas;
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    /**
     * Coloca el caracter ingresado dentro de la matriz, dada una posiciòn en el trablero
     * convierte la posicion en cordenadas (x, y) y coloca el caracter en esa posiciòn
     *
     * @param tablero matriz en la cual se coloca el elemento
     * @param posicion donde se coloca el elemento
     * @param caracter elemento a colocar
     */
    public static void colocar (char[][] tablero, int posicion, char caracter) {
        int size = tablero.length;

        int fila = posicion/size;
        int col = posicion%size;


        tablero[fila][col] = caracter;
    }

    //TODO terminar esto
    public static void rastrear (char[][] tablero) {
        int size = tablero.length; // hola

        // Va directamente a la mina y analiza todos los cuadrados a su alrededor, colocandoles un contador
        // En caso de ya tener, les suve uno
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (tablero[i][j] == MINA) {

                    if ()
                    try {
                        if (tablero[i-1][j] == '-') tablero[i][j] = '1';
                        else if (tablero[i-1][j] == '1') tablero[i][j] = '2';
                        else if (tablero[i-1][j] == '2') tablero[i][j] = '3';
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        if (tablero[i+1][j] == '-') tablero[i][j] = '1';
                        else if (tablero[i+1][j] == '1') tablero[i][j] = '2';
                        else if (tablero[i+1][j] == '2') tablero[i][j] = '3';
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        if (tablero[i][j+1] == '-') tablero[i][j] = '1';
                        else if (tablero[i][j+1] == '1') tablero[i][j] = '2';
                        else if (tablero[i][j+1] == '2') tablero[i][j] = '3';
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        if (tablero[i][j-1] == '-') tablero[i][j] = '1';
                        else if (tablero[i][j-1] == '1') tablero[i][j] = '2';
                        else if (tablero[i][j-1] == '2') tablero[i][j] = '3';
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
 }
