public class Ejerarray {
    public static void main(String args[]) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] invertido = invertir(array);

        for (int inv : invertido) {
            System.out.print(inv + " ");
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

        if (invertido == array){
            System.out.println("es capicua");
        }
    }
}
