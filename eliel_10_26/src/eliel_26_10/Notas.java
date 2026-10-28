package eliel_26_10;

import java.util.Arrays;
import java.util.Scanner;

public class Notas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		mediaNotas(in);
		in.close();
	}
	
	public static void mediaNotas (Scanner in) {
		
		int numA = 0; //Numero actual del alumno

		int[] num = new int[10]; 
		int cant = 0;
		boolean continuar = true;
		
		// Se pide ingresar cada nota por la cantidad de 
		// alumnos que se alla ingresado anteriormente 
		do {
			System.out.println("ingrese un numero");
			try {
				numA = in.nextInt();
				continuar = calcularNota(numA);
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				numA=0;
			}
			num[cant] = numA;
			cant++;
			System.out.println("Quedan: "+(num.length-cant)+" numeros");
		} while(continuar && cant < num.length);
		
		for (var nota : num) {
			System.out.println(nota);
		}
		
		System.out.println("Se han terminado de introducir las notas");
		int cantMax = 0;
		int cantActual = 0;
		int media = 0;
		int moda = 0;
		
		Arrays.sort(num);
		
		int mediana = (int) cant / 2;
		mediana = num[mediana];
		
		for (int i = 0; i < cant; i++) {
			
			media += num[i];
			
			for (int j = 0; j < cant; j++) {
				if (num[i] == num[j] && 
					num[i] != 0 && num[j] != 0)
					cantActual++;
			}
			if (cantActual > cantMax) {
				moda = num[i];
				cantMax = cantActual;
			}
		}
		
		media/= cant;
		
		System.out.println("media: "+media+" mediana: "+mediana+" moda: "+moda);
		
	}

	private static boolean calcularNota(int num) throws IllegalArgumentException {
		if (num < 0 || num > 10) {
			throw new IllegalArgumentException("El numero no puede ser ni mayor a 10, ni menor a 0");
		} else {
			return true;
		}
		
	} 
}
