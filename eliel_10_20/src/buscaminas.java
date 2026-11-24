import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class buscaminas {

    //TODO Crear metodo para ingreo del usuario
    //TODO Crear metodo para detectar que tan cerca estan las minas

    static final char MINA = '*';
    static final char JUGADOR = 'X';

    public static void main(String[] args) {

        System.out.println("Ingrese el tamaño del tablero: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean victoria = false;
        boolean esCorrecto = false;

        int[] jugado = new int[n];

        int introducido = 0;

        char[][] tablero  = new char[n][n];

        // Llenar la matriz con el caracter '-'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = '-';
            }
        }

        int[] posMinas = crearMinas(tablero, n);


        // Loop principal del juego
        do {
            // Input del usuario
            while (!esCorrecto) {
                System.out.println("Ingrese el la comprobacion tablero: ");
                introducido = in.nextInt();

                if (introducido > 0 && introducido < (n*n) - 1) {
                    esCorrecto = true;
                    //TODO codigo para añadir
                } else {
                    System.out.println("Ingrese un numero mayor a 0 y menor a " + (n*n - 1));
                }
            }
            if (comprobar(tablero, introducido)) {
                System.out.println("Se a pisado una mina, fin del juego");
                colocar(tablero, introducido, JUGADOR);
                victoria = true;
            } else {
                colocar(tablero, introducido, JUGADOR);
            }

            imprimirTablero(tablero);
            esCorrecto = false;
        } while (!victoria);
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

        if (tablero[fila][col] == MINA)
            tablero[fila][col] = 'O';
         else
            tablero[fila][col] = caracter;
    }

    public static boolean comprobar (char[][] tablero, int posicion) {
        int size = tablero.length;
        int fila = posicion/size;
        int col = posicion%size;

        return tablero[fila][col] == MINA;
    }
 }

