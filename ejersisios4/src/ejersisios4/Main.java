package ejersisios4;

import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		//conteoCifras(in);
		//sumaImpar(in);
		//actualizarRelog(in);
		//enteroOPrimo(in);
		//mostrarPrimos();
		//aprovados(in);
		//numeroMayor(in);
		//leerDigitos(in);
		//vuelto(in);
		//adivinar(in);
		cifrasmayores(in);
		
		in.close();
	}
	
	/*
	 * Determinar el número de cifras de un número entero 
	 * (positivo o negativo) introducido por teclado, 
	 * utilizando un bucle que divida el número sucesivamente.
	 */
	public static void conteoCifras (Scanner in) {
		System.out.println("Ingrese un numero: ");
		int num = in.nextInt();
		int contador = 10;
		
		for (int i = 0; i <= 10; i++) {
			if (num < contador) {
				System.out.println("El numero tiene: " + (i+1) + " cifras");
				return;
			} else {
				contador *= 10;
			}
		}
	}
	
	/*
	 * Sumar todos los números impares que existen entre 
	 * dos números cualquiera (A y B) pedidos por teclado.
	 */
	
	public static void sumaImpar (Scanner in) {
		System.out.println("Ingrese el primer numero");
		int inicio = in.nextInt();
		
		System.out.println("Ingrese el segundo numero");
		int fin = in.nextInt();
		
		int suma = 0;
		
		if (0 == (inicio % 2)) {
			inicio+=1; 
		}
		
		for (int i = inicio; i <= fin ; i+=2) {
			System.out.println("Estamos sumando: " + suma + " + " + i);
			suma+=i;
		}
		System.out.println("El resultado es: " + suma);
		
	}
	
	/*
	 * Dada una hora (H:M:S) por teclado,
	 * realizar el algoritmo que muestre la hora después de incrementarle un segundo,
	 * gestionando el acarreo de minutos, horas y el ciclo de 24 horas.
	 */
	
		public static void actualizarRelog (Scanner in) {
			System.out.println("Ingrese las horas");
			int hora = in.nextInt();
			System.out.println("Ingrese los minutos");
			int minuto = in.nextInt();
			System.out.println("Ingrese los segundos");
			int segundo = in.nextInt();
			
			segundo++; // segundo que tenemos que añadir 
			
			// si es igual o mayor a 60, se reinicia y suma un minuto
			if (segundo >= 60) { 
				minuto++;
				segundo = 0;
			}
			if (minuto >= 60) {
				hora++;
				minuto=0;
			} 
			// Si es igual o mayor a 24, se regresa a 0
			// en caso de ser mayor se resta a 24
			if (hora >= 24) { 
				hora-=24;
			}
			System.out.println("La hora es: " + hora + ":" + minuto + ":" + segundo);
		}	
		
		/*
		 * Determinar si un número entero introducido por teclado es primo, 
		 * utilizando un bucle controlado por un indicador (bandera o flag).
		 */
		
		public static void enteroOPrimo (Scanner in) {
			System.out.println("Ingrese un numero");
			int num = in.nextInt();
			
			boolean esPrimo = false;
			
			// Si el numero es par, no puede ser primo
			if (0 == (num % 2)) {
				esPrimo = false;
				System.out.println("El numero " + num + " no es primo");
				return;
			} 
			
			// Sacamos la raiz cuadrada del numero
			double raiz = Math.sqrt(num);
			
			// Conseguimos el residuo de el numero para 2 
			// hasta la raiz del numero
			for (int i = 2; i <= raiz; i++) {
				// si es divisible para i, no es primo
				if (0 == (num % i)) {
					esPrimo = false;
					break;
				} else { // si no lo es, sera verdadero por defecto
					esPrimo = true;
				}
			}
			
			if (esPrimo) {
				System.out.println("El numero " + num + " es primo");
			} else {
				System.out.println("El numero " + num + " no es primo");
			}

		}
		
		/*
		 * Reutilizar la lógica de la comprobación de número primo 
		 * para mostrar todos los números primos que hay entre 1 y 1000.
		 */
		
		public static void mostrarPrimos () {
			int num = 1;
			for (int i = 0; i <= 99; i++) {
				esPrimo(num);
				num++;
			}
		}
		
		public static void esPrimo(int num) {
	
			// Si el numero es par, no puede ser primo
			if (0 == (num % 2)) {
				return;
			} else if (num < 2) {
				System.out.println(num);
			}
		
			// Sacamos la raiz cuadrada del numero
			double raiz = Math.sqrt(num);
		
			// Conseguimos el residuo de el numero para 2
			// hasta la raiz del numero
			for (int i = 2; i <= raiz; i++) {
				// si es divisible para i, no es primo
				if (0 == (num % i)) {
					return;
				}
			}
			System.out.println(num);
		}
		
		/*
		 * Calcular la media de una cantidad indefinida de números.
		 * El programa parará cuando se introduzca un número negativo (el centinela), 
		 * y al final debe mostrar la media de los números válidos introducidos. 
		 */
		
		public static void mediaInfinita(Scanner in) {
			int numeros[] = new int[20];
			int i = 1;
			boolean esNegativo = false;
			do {
				System.out.println("Ingrese un numero");
				int num = in.nextInt();

				if (num <= 0) {
					esNegativo = true;
					break;
				}
				numeros[i] = num;
				i++;
			} while (!esNegativo);
			double total = 0;
			int size = numeros.length;
			for (int j : numeros) {
				total += j;
			}
			double media = total / size;
			System.out.println("La media es: " + media);
		}
		
		/*
		 * Introducir las notas de N alumnos hasta que se ingrese una nota negativa (centinela). 
		 * Indicar al final cuántos aprobados y cuántos suspensos hay.
		 */
		
		public static void aprovados(Scanner in) {
			int numeros[] = new int[20];
			int cant = 1;
			boolean esNegativo = false;
			do {
				System.out.println("Ingrese la nota (base 10)");
				int num = in.nextInt();

				if (num <= 0) {
					esNegativo = true;
					break;
				} else if (num > 10) {
					System.out.println("El numero es muy grande, se califica en base a 10");
				}
				numeros[cant] = num;
				cant++;
			} while (!esNegativo);
			
			int aprovados = 0, reprovados = 0;

			for (int i : numeros) {
				if (numeros[i] >= 5) {
					aprovados++;
				} else {
					reprovados++;
				}
			}
			System.out.println("Hay: " + aprovados + " y: " + reprovados + " reprovados");
		}
		
		/*
		 * Diseñar un algoritmo que determine el mayor valor de una serie de números enteros
		 * introducidos por teclado. La serie finaliza cuando se introduce el número 0.
		 */
		public static void numeroMayor (Scanner in) {
			int numeros[] = new int[20];
			int cant = 1;
			boolean esCero = false;
			do {
				System.out.println("Ingrese un numero");
				int num = in.nextInt();

				if (num == 0) {
					esCero = true;
					break;
				}
				numeros[cant] = num;
				cant++;
			} while (!esCero);
			
			int mayor = 0;
			for (int i : numeros) {
				if (i > mayor) {
					mayor = i;
				}
			}
			System.out.println("El numero mayor es: " + mayor);
		}
		
		/*
		 * Leer un número entero positivo. 
		 * Determinar si el número contiene al menos un dígito que sea par. 
		 * El programa debe recorrer el número dígito a dígito y utilizar una bandera (flag lógico).
		 */
		public static void leerDigitos (Scanner in) {
			System.out.println("Ingrese un numero");
			int num = in.nextInt();
			boolean esPar = false;
			
			while (num > 0) {
				int digito = num % 10;
				if (0 == (digito % 2)) {
					esPar = true;
				}
				num /= 10;
			}
			
			if (esPar) {
				System.out.println("el numero tiene digitos pares");
			} else {
				System.out.println("El numero no tiene digitos pares");
			}
	
		}
		/*
		 * Simular el mecanismo de devolución de monedas de una máquina expendedora. 
		 * El programa pregunta una cantidad de dinero en euros (ej. 3,47 €) 
		 * y calcula la cantidad mínima de monedas necesarias para devolverla 
		 * (ej. 1 de 2€, 1 de 1€, 2 de 20cts, etc.).
		 */
		public static void vuelto(Scanner in) {
			System.out.println("Ingrese la cantidad de euros");
			double euros = in.nextDouble();
			
			int centimos = (int) Math.round(euros * 100);
			
			int[] monedas = {200, 100, 50, 20, 10, 5, 1};
			
			for (int moneda : monedas) {
				if (centimos >= moneda) {
					int cantidad = centimos / moneda;
					centimos = centimos % moneda;
					
					if (moneda >= 100) {
						System.out.println(cantidad + " de " + (moneda / 100) + " euros");
					} else {
						System.out.println(cantidad + " de " + moneda + " cetimos");
					}
				}
			}
	
		} // ! =
		
		/*
		 * El ordenador "piensa" un número al azar del 1 al 100. 
		 * El usuario intenta adivinarlo. El programa debe dar pistas ("mayor" o "menor"). 
		 * Al final, se pregunta al usuario si quiere jugar de nuevo (bucle exterior).
		 */
		
		public static void adivinar (Scanner in) {
			// Flags
			boolean adivinado = false;
			boolean denuevo = false;
			
			// primer bucle de juego
			do {
				// creamos un numero aleatorio para que el usuario adivine
				int numeroAleatorio = (int) (Math.random() * 100) + 1;
				do {
					System.out.println("Adivina el numero");
					int num = in.nextInt();

					// si hacierta el numero, rompe el bucle
					// caso contrario, dice si es mayor o menor
					if (num == numeroAleatorio) {
						adivinado = true;
						break;
					} else if (num > numeroAleatorio) {
						System.out.println("El numero es menor");
					} else if (num < numeroAleatorio) {
						System.out.println("El numero es mayor");
					}
				} while (!adivinado);
				System.out.println("El numero es: " + numeroAleatorio);
				System.out.println("quieres volver a jugar? (y/n)");
				
				String resp = in.next();
				if (resp == "s") {
					denuevo = true;
				}
				
			} while (denuevo);
		}
		
		/*
		 * Introducir un número por teclado y el ordenador deberá 
		 * indicar si todas las cifras son mayores de 5.
		 */
		
		public static void cifrasmayores (Scanner in) {
			System.out.println("Ingrese un numero");
			int num = in.nextInt();
			boolean mayora5 = false;
				
			while (num > 0) {
				int digito = num % 10;
				if (digito > 5) {
					mayora5 = true;
				}
				num /= 10;
			}
			if (mayora5) {
				System.out.println("Todos los numeros son mayores a 5");
			} else {
				System.out.println("No todos los numeros son mayores a 5");
			}
		
		}
	
}
