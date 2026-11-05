public class Ejerarray {
    public static void main(String args[]) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] capicua = {5, 4, 3, 4, 5};
        int[] arr2 = {5,45, 6, 3,4};

        int[] invertido = invertir(array);

        for (int inv : invertido) {
            System.out.print(inv + " ");
        }

        capicua(array);
        capicua(capicua);
        capicua(arr2);

        primitiva();
    }

    private static void primitiva() {
        int[] primitiva = new int[5];
        int cant = 0;
        for (int i = 0; i < primitiva.length; i++) {
            cant = (int) (Math.random() * 49) + 1;
            for (int j : primitiva) {
                if (cant == j) {
                    cant = (int) (Math.random() * 49) + 1;
                }
            }
            primitiva[i] = cant;
        }

        for (int i : primitiva) {
            System.out.print(i + " ");
        }
    }

    public static int[] invertir(int[] array) {
        //int mitad = (array.length / 2) - 1;
        int rest = array.length -1;
        for (int i = 0; i < rest; i++) {
           int temp = array[i];
           array[i] = array[rest];
           array[rest] = temp;
           rest--;
        }
        return array;
    }

    public static void capicua(int[] array) {
        int[] invertido = invertir(array);
        int i = 0;
        int iguales = 0;
        for (int inv : invertido) {
            if (inv == array[i]){
                iguales++;
            }
            i++;
        }
        if (iguales == array.length){
            System.out.println("el vector es capicua");
        } else {
            System.out.println("el vector no es capicua");
        }
    }
}
