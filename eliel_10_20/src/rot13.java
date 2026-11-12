import java.util.Scanner;

public class rot13 {
    public static final char[] ABECEDARIO = {',', '.', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main (String[] args) {

        int numero = 0;
        int size = ABECEDARIO.length;
        boolean esValido = false;
        String texto = "";
        StringBuilder result = new StringBuilder();

        Scanner in = new Scanner(System.in);

        //NOTE: Verificamos que el texto ingresado siempre sea correcto y no tenga carracteres especiales
        while (!esValido) {
            System.out.println("Ingrese un texto para cifrar");
            texto = in.nextLine();

            if (texto.matches("^[0-9A-Za-z \\.,]")) {
                esValido = true;
            } else  {
                System.out.println("Por favor ingrese un texto valido");
            }
        }
        System.out.println("Ingrese el numero de rotaciones: ");
        numero = in.nextInt();

        for (int i = 0; i<size; i++){
            result.append(root(texto.charAt(i), numero));
        }

        System.out.println(result);
    }

    /*
     * NOTE: Toma el caracter, luego busca que que posicion esta
     * en el array abecedario, luego suma la cantidad ingresada
     * En caso de que supere el tamaño del array,
     * se regresa a posicion 0
     */
    public static char root (char letra, int cant){
        int size = ABECEDARIO.length;
        int num = 0;

        //NOTE: Si el caracter es un espacio, lo saltamos
        if (letra == ' ')
            return letra;

        for (int i = 0; i<size; i++){
            if (ABECEDARIO[i] == letra){
                if ((i + cant) > size){
                   num = cant - (size - i) ;
                } else {
                    num = i + cant;
                }
                return ABECEDARIO[num];
            }
        }
        return letra;
    }
}

