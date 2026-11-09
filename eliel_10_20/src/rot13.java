import java.util.Scanner;

public class rot13 {
    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese un texto para cifrar");
        String texto = in.nextLine();

        char[] abecedario = {',', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
         'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
         'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] rot13 = {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};

        int size = texto.length();
        char[] codificado = new char[size];
        char[] codificado2 = new char[size];

        int letra = 0;
        String regex = "[ ,.][0-9][A-Z][a-z]";
        String regexInv = "[ ,.][9-0][Z-A][z-a]";

        String otroTexto = texto.replaceAll("A-Za-z", "N-ZA-Mn-za-m");
        System.out.println(otroTexto);

        for (int i = 0; i<size; i++){
            if (texto.matches(regex)){
                letra = (int) texto.charAt(i);
                letra += 13;
                codificado[i] = (char) letra;
            }
        }

        for (int i = 0; i<size; i++){
           for (int j = 0; j < abecedario.length; j++){
               if (texto.charAt(i) == abecedario[i]){
                  codificado2[i] = rot13[j];
               }
           }
        }

        for (int i = 0; i<size; i++){
            System.out.print(codificado2[i]);
        }

        for (int i = 0; i<size; i++){
            System.out.print((char) codificado[i]);
        }
    }
}
