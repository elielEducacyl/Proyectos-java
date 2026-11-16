import java.util.Random;
import java.util.Scanner;

public class raya {

    static final int JUGADOR = 1;
    static final int MAQUINA = 2;

    public static void main (String[] args) {
        int[][] matriz = new int[3][3];
        int[] usados = new int[9];
        boolean esCorrecto = false;
        boolean victoria = false;

        int val = 0, maquina = 0, itr = 0;

        Scanner in = new Scanner(System.in);

       /*
        * Loop principal
        * Primero recoge el input del jugador
        * Despues el de la maquina, comprovando obviamente que lo ingresado no este ya utilizado
        * Sigue en proceso
        */
       do {
           while (!esCorrecto) {
               System.out.println("Introdusca la primera x");
               val = in.nextInt();

               // Comprobamos que el valor no este usado ya
               //TODO: Terminar esto
                if (!comprovacion(matriz, val)) {

                }

               // Comprobamos que se pueda utilizar
               if (val > 0 && val < 9)
                   esCorrecto = true;
               else
                   System.out.println("Ingrese un valor entre 0 y 9");
           }

           usados[itr] = val;
           cambiarVal(matriz, val, JUGADOR);

           // Conseguimos el valor de la maquina
           maquina = valorMaquina(usados);
           cambiarVal(matriz, maquina, MAQUINA);
           usados[itr] = maquina;

           imprimir(matriz);

           switch (comprovacion(matriz)) {
               case JUGADOR:
                   System.out.println("El jugador a ganado");
                   victoria = true;
                   break;
               case MAQUINA:
                   System.out.println("El maquina a ganado");
                   victoria = true;
                   break;
           }

           esCorrecto = false;
           itr++;
       } while (!victoria && itr < 9);
    }

    //NOTE: Cambia un valor de la matriz a uno añadido
    public static int[][] cambiarVal (int[][] matriz, int val, int dato) {
        int fila = (int) val/3;
        int columna = (int) val%3;
        matriz[fila][columna] = dato;

        return matriz;
    }

    /**
     * Consigue un valor de la maquina, este no puede ser igual a otro ya utilizado
     * @param usados recibe el vector de posiciones utilizadas
     * @return devuelve un valor aleatorio que se pueda utilizar
     */
    public static int valorMaquina (int[] usados) {
        Random rand = new Random();
        int val = rand.nextInt(9) +1;
        boolean esCorrecto = false;

        while (!esCorrecto) {
            for (int i : usados){
                if (val == i) {
                    val = rand.nextInt(9) +1;
                } else {
                    esCorrecto = true;
                }
            }
        }

        return val;
    }

    public static void imprimir (int[][] matriz) {
        System.out.println("Imprimiendo matriz");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == 1) {
                    System.out.print(" X ");
                } else if (matriz[i][j] == 2) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" _ ");
                }
                System.out.print("|");
            }
            System.out.println(" ");
        }
    }

    public static int comprovacion (int[][] matriz) {
        if (rectas(matriz, JUGADOR))
            return JUGADOR;
        else if (diagonales(matriz, JUGADOR))
            return JUGADOR;
        else if (rectas(matriz, MAQUINA))
            return MAQUINA;
        else if (diagonales(matriz, MAQUINA))
            return MAQUINA;
        else return -1;

    }

    /**
     * Comprueba si alguna de las rectas (vertical o diagonal)
     * es exactamente igual al valor ingresado
     * (3 en raya)
     *
     * @param matriz Recibe la matriz utilizada (3 en ralla)
     * @param val valor a comprobar
     * @return devuelve si en caso de que exista 3 en ralla
     */
    public static boolean rectas (int[][] matriz, int val) {
        int size = matriz.length;
        int[] columnas = new int[3];
        int[] filas = new int[3];
        int contFilas = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                columnas[j] += matriz[i][j];
                filas[contFilas] += matriz[i][j];
                contFilas++;
            }
            for (int k : columnas) {
                if (k != val) {
                    return false;
                }
            }for (int k : filas) {
                if (k != val) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Comprueba las diagonales para verificar si existe un 3 en ralla
     *
     * @param matriz matriz 3x3 del 3 en raya
     * @param val valor a verificar (circulo o cruz)
     * @return true si una de las diagonales esta conformada por el valor ingresado
     */
    public static boolean diagonales (int[][] matriz, int val) {
        int n = 3;
        int [] vectorIzq = new int[n];
        int [] vectorDer = new int[n];
        int diagonalIzq = n - 1;

        //TODO: verificar q esta kgada funcione bien
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

        // si uno de los valores no es igual al ingresado, deja de ser verdadero
        for (int i : vectorIzq) {
            if (i != val) {
                return false;
            }
        }
        for (int i : vectorDer) {
            if (i != val) {
                return false;
            }
        }
        return true;
    }

    public static boolean comprovacion (int[][] matriz, int val) {
        int fila = (int) val/3;
        int columna = (int) val%3;

        return matriz[fila][columna] == 0;
    }
}

