import java.util.Random;
import java.util.Scanner;

public class raya {
    public static void main (String[] args) {
        int[][] matriz = new int[3][3];
        int[] usados = new int[9];
        boolean esCorrecto = false;
        boolean victoria = false;

        int val = 0, maquina = 0, itr = 0;

        Scanner in = new Scanner(System.in);

        // Colocamos todos los valores a 0
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = 0;
            }
        }

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
               for (int i : usados){
                   if (val == i) {
                       System.out.println("El valor ya esta usado, introdusca otro");
                       esCorrecto = false;
                       break;
                   }
               }

               // Comprobamos que se pueda utilizar
               if (val > 0 && val < 9)
                   esCorrecto = true;
               else
                   System.out.println("Ingrese un valor entre 0 y 9");
           }

           usados[itr] = val;
           cambiarVal(matriz, val);

           // Conseguimos el valor de la maquina
           maquina = valorMaquina(usados);
           cambiarVal(matriz, maquina);
           usados[itr] = maquina;

           itr++;
       } while (!victoria);
    }

    //NOTE: Cambia un valor de la matriz a uno añadido
    public static int[][] cambiarVal (int[][] matriz, int val) {
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp++;
                if (temp == val) {
                    matriz[i][j] = 1;
                }
            }
        }
        return matriz;
    }

    // Consigue un valor de la maquina, este no puede ser igual a otro ya utilizado
    public static int valorMaquina (int[] usados) {
        Random rand = new Random();
        int val = 0;
        val = rand.nextInt(9) +1;

        for (int i : usados){
            if (val == i) {
                val = rand.nextInt(9) +1;
            }
        }

        return val;
    }

    public static void imprimir (int[][] matriz) {
        //TODO: encontrar como imprimir esta kgada
    }

    public static boolean comprovacion (int[][] matriz) {
        //TODO: encontrar como yo compruebo esta mierda tio
        return true;
    }

    public static boolean rectas (int[][] matriz, int val) {
        int[] columnas = new int[3];
        int[] filas = new int[3];
        int contFilas = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                contFilas++;
                columnas[j] += matriz[i][j];
                filas[contFilas] += matriz[i][j];
            }
            for (int k : columnas) {
                if (k != val) {
                    return true;
                }
            }for (int k : filas) {
                if (k != val) {
                    return true;
                }
            }
        }
        return false;
    }

    // TODO: convertir este metodo a uno que diga si la diagonal es igual
    public static boolean diagonales (int[][] matriz, int val) {
        int n = 3;
        int [] vectorIzq = new int[n];
        int [] vectorDer = new int[n];
        int diagonalIzq = n;

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
    }
}
