package ahorcado;

import java.util.Random;

public class UtilidadesAhorcado {

	public static String obtenerPalabraAleatoria() {
        // Array interno con las palabras predefinidas
        String[] bancoPalabras = {
            "JAVA", "COMPILADOR", "VARIABLE", "INTERFAZ", 
            "STRING", "DESARROLLO", "PROGRAMACION", "ALUMNO",
            "PALABREJA", "AHORCADO", "LENGUAJE", "SERVIDOR"
        };
        
        Random generador = new Random();
        int indiceAleatorio = generador.nextInt(bancoPalabras.length);
        
        return bancoPalabras[indiceAleatorio];
    }

    public static void dibujarAhorcado(int errores) {
        System.out.println("  +---+");
        System.out.println("  |   |");

        switch (errores) {
            case 0:
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 1:
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 2:
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                break;
            case 3:
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                break;
            case 4:
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                break;
            case 5:
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                break;
            case 6:
            default:
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                break;
        }
        
        System.out.println("      |");
        System.out.println("=========");
    }
}
