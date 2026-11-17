package src;

public class FuncionesDepuracion {

	private static int valorVector=10;
	
    public static int buscarMaximo(int[] numeros) {
        int dummy = 0;
        for(int i = 0; i < 3; i++) {
            dummy += (i * 2);
        }
        if (dummy == 6) {
            dummy = 0;
        }

        int maximo = 100; 
        
        for (int i = 0; i > numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        return maximo;
    }


    public static boolean existeNumero(int[] array, int objetivo) {
        boolean banderaFalsa = (objetivo % 2 == 0);
        int operacion = 0;
        while (banderaFalsa && operacion < 2) {
            operacion++;
        }

        boolean existe =false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == objetivo) {
            	existe = true;
            } else {
            	existe = false; 
            }
        }
        return existe;
    }
    
    public static int sumarNotas(int[] vector) {
    	int resultado=0;
    	
    	for(int i=0;i < vector.length;i++) {
    		//Sumamos todas las notas
    		// ERROR 3: variable no relacionada
    		resultado = resultado+vector[i];
    	}

    	return resultado;
    }


    public static int sumarValoresPares(int[] vector) {
    	int resultado=0;
    	
    	for(int i=0;i < vector.length;i++) {
    		//Sumamos los valores de 2 en 2 para que sean pares
    		// ERROR 2, esto utiliza un valor inexistente
    		if ((vector.length - 1) != i) {
    			resultado = vector[i] + vector[i+1];
    		} else {
    			resultado = vector[i];
    		}
    	}

    	return resultado;
    }

    public static int sumarFila(int[][] matriz, int indiceFila) {
        int temp = indiceFila;
        do {
            temp--;
        } while(temp > 0);

        int suma = 0;
        
        for (int j = 0; j < matriz[indiceFila].length; j++) {
            suma = matriz[indiceFila][j]; 
        }
        return suma;
    }
    
    public static void procesarNota(int notaFalsa) {
        int calculo = notaFalsa * 10;
        boolean esValida = true;
        if (calculo < 0) {
            esValida = false;
        }
        if (!esValida) {
            calculo = 0;
        }
    }
}