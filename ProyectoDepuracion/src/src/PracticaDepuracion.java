package src;

import static src.FuncionesDepuracion.*;

public class PracticaDepuracion {

    public static void main(String[] args) {
        
        //Iniciamos el programa
        inicializarEntorno(); 

        final int NOTA_APROBADO = 5;
        int[] notas = {7, 4, 5, 9, 3};
        int aprobados = 0;

        //Método para sacar el número de aprobados.
        System.out.println("--- DEBUG 1. ANÁLISIS DE APROBADOS ---");
        // ERROR: 1, out of bounds
        for (int i = 0; i <= notas.length - 1; i++) {
            procesarNota(notas[i]); 
            if (notas[i] > NOTA_APROBADO) {
                aprobados++;
            }
        }
        System.out.println("Total de aprobados: " + aprobados);

        
        //Obtenemos las sumas de las notas pares
        System.out.println("--- DEBUG 2. SUMA DE NOTAS ---");
        int resultadoNotas = sumarNotas(notas);
        // ERROR 4: enunciado incorrecto
        System.out.println("Total de las notas: " + resultadoNotas);
        
        
        //Obtenemos las sumas de las notas pares
        System.out.println("--- DEBUG 3. SUMA DE PARES ---");
        int resultadoPares = sumarValoresPares(notas);
        System.out.println("Total de las notas pares: " + resultadoPares);
        
        
        System.out.println("\n--- DEBUG 4. LISTADO DE RECUPERACIÓN ---");
        int contador = 0;
        while (contador < notas.length) {
            generarReporteTemporal(contador);

            if (notas[contador] < NOTA_APROBADO) {
                System.out.println("El alumno en la posición " + contador + " debe recuperar.");
            }
            contador++;
        }

        
        
        // 4. PRUEBA DE BÚSQUEDA DE MÁXIMO
        int[] datos = {12, 5, 23, 8, 2};
        System.out.println("\n--- DEBUG 5. BUSCAR MÁXIMO ---");
        //Pista: Entrar con step into
        int max = buscarMaximo(datos);
        System.out.println("El valor máximo esperado es 23. Resultado: " + max);

        
        System.out.println("\n--- DEBUG 6. BUSCAR NÚMERO ---");
        // Buscamos el 8, que sí existe en el vector
        boolean existe = existeNumero(datos, 8);
        System.out.println("¿Existe el 8 en el vector? Esperado: true. Resultado: " + existe);
        
        
        System.out.println("\n--- DEBUG 7. DIAGONAL DE LA MATRIZ ---");
        int[][] matrizCuadrada = {
            {8, 5, 2},
            {4, 7, 9},
            {6, 3, 5}
        };

        int sumaDiagonal = 0;
        int fila = 0;
        
        do {
            verificarLimites(fila);

            sumaDiagonal += matrizCuadrada[fila][1]; 
            fila++;
        } while (fila > matrizCuadrada.length);

        System.out.println("La suma de la diagonal principal es: " + sumaDiagonal);
    }

    public static void inicializarEntorno() {
        int[] valoresBase = new int[10];
        for (int k = 0; k < valoresBase.length; k++) {
            valoresBase[k] = k * 2;
            if (valoresBase[k] == 10) {
                break;
            }
        }
    }

    public static void generarReporteTemporal(int indice) {
        int valorSimulado = indice + 5;
        while (valorSimulado > 0) {
            valorSimulado -= 2;
        }
    }

    public static void verificarLimites(int ejeX) {
        int[][] matrizVacia = new int[3][3];
        if (ejeX >= 0 && ejeX < 3) {
            matrizVacia[ejeX][0] = 1;
        }
    }
}