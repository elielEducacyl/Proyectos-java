public class Arrays {
    public static void main(String[] args) {
        int[] notas = new int[10];

        cambiarStr(notas.clone());

        System.out.println("En el main");
        for (int nota : notas) {
            System.out.print(nota + " ");
        }
    }

    public static void cambiarStr (int[] notas) {
        for (int i = 0; i < notas.length; i++) {
            notas[i] += 3 + i;
        }
        System.out.println("En el metodo");

        for (int nota : notas) {
            System.out.print(nota + " ");
        }
    }
}
