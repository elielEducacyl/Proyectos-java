import java.util.Scanner;

public class ejer_arr {
    public static void main(String[] args){

       Scanner in = new Scanner(System.in);

       //comparacion(in);
       // esDNI(in);
       invYNormalizar(in);

       in.close();
    }



    public static String invertir(String text) {
        StringBuilder invertido = new StringBuilder();

        for(int i = text.length() -1; i > 0; i--){
            //invertido = text.charAt(i);
        }

        return invertido.toString();
    }

    private static void invYNormalizar(Scanner in) {
        System.out.println("Ingrese un texto");
        String texto = in.nextLine();

        texto = invertir(texto);

        System.out.println("El texto es: "+texto.toUpperCase()); //yo q se tio
    }

    private static void esDNI(Scanner in) {
        
    }

    /*
     * Solicite dos cadenas de texto al usuario por teclado
     * y realice las siguientes comparaciones: a) Determine si son iguales en contenido; b)
     * Compare sus longitudes; c) Determine cuál es alfabéticamente anterior.
     */
    private static void comparacion(Scanner in) {
        System.out.println("Ingrese un texto");
        String tex1 = in.nextLine();
        System.out.println("Ingrese otro texto");
        String tex2 = in.nextLine();
        int size = 0, cant1 = 0, cant2 = 0;

        // Comprobacion de tamaño
        if (tex1.equals(tex2)){
            System.out.println("El texto es igual");
        } else {
            System.out.println("El texto no es igual");
        }

        // Comprueba cual de los dos es mas largo
        if (tex1.length() == tex2.length()) {
            System.out.println("ambos son del mismo tamaño");
            size =  tex2.length();
        } else if (tex1.length() <= tex2.length()) {
            System.out.println("el primer texto es menor al segundo");
            size =  tex1.length();
        } else if (tex1.length() >= tex2.length()) {
            System.out.println("el segundo son menor al segundo aqui");
            size =  tex2.length();
        }

        tex1.toLowerCase(); tex2.toLowerCase();

        System.out.println(size);


        for  (int i = 0; i < size; i++){
            if (tex1.charAt(i) <= tex2.charAt(i)){
                cant2++;
            } else if (tex1.charAt(i) >= tex2.charAt(i)) {
               cant1++;
            }
        }

        if (cant1 >= cant2) {
            System.out.println("El texto 1 es alfabeticamente mayor");
        } else if (cant1 <= cant2) {
            System.out.println("El texto 2 es alfabeticamente mayor");
        } else {
            System.out.println("Ambos son alfabeticamente iguales");
        }

    }
}
