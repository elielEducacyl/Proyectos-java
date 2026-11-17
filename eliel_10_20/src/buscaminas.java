import java.util.Random;
import java.util.Scanner;

public class buscaminas {

    static char MINA = 'm';

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        char[][] tablero  = new char[n][n];

        char cantMinas = crearMinas(tablero, n);

    }

    private static int crearMinas(char[][] tablero, int n) {
        Random rand = new Random();
        char[][] minas = new char[n][n];

        int cantMinas = rand.nextInt(n/2) + 1;
        int[] minas = new int[cantMinas];

        for (int i = 0; i < cantMinas; i++) {
            nuevaMina = rand.nextInt(n/2) + 1;

        }
    }

    public static char[][] crearMina(char[][] tablero) {}


 }
