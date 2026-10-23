package prueba3;

import java.util.Scanner;
public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		//diaDeSemana(sc);
		//cascada();
		//bucle(sc);
		//dobleBucle(sc);
		
		sum(sc);
		sc.close();
	}
	
	public static void sum(Scanner sc) {
		System.out.println("Ingrese un numero");
		int num = sc.nextInt();
		int sum = 0;
		
		do {
			System.out.println("Numero actual: " + sum);
			System.out.println("Sumas " + num + " + " + sum);
			sum += num;
			System.out.println("Acabar la suma? (0) o seguir?");
			num = sc.nextInt();
		} while (0 != num);
		System.out.println("fen.");
	}
	
	public static void bucle(Scanner sc) {
		System.out.println("Ingrese un numero mayor a 3");
		int num = sc.nextInt();
		
		if (num < 3) {
			System.out.println("Ingrese un numero mayor a 3");
			return;
		}
		for (int i = 2; i <= num; i++) {
			if ((i % 2) == 0) {
				System.out.println("El numero " + i + " es par");
			} else {
				System.out.println("el numero " + i + " es impar");
			}
		}
		System.out.println("fin del bucle");
	}
	
	public static void dobleBucle(Scanner sc) {
		System.out.println("Ingrese un numero mayor a 3");
		int num = sc.nextInt();
		
		if (num < 3) {
			System.out.println("Ingrese un numero mayor a 3");
			return;
		}
		for (int i = 2; i <= num; i += 2) {
			System.out.println("El numero " + i);

		}
		for (int j = 3; j <= num; j += 2) {
			System.out.println("El numero " + j);
		}
	}
	
	public static void diaDeSemana (Scanner sc) {
		System.out.println("Ingrese el dia de la semana");
		String dia = sc.nextLine();
		
		switch (dia) {
		case "lunes":
		case "martes":
			System.out.println("Comenzando la semana");
			break;
		case "miercoles":
		case "jueves":
			System.out.println("Mitad de la semana");
			break;
		case "viernes":
			System.out.println("Casi fin de semana");
			break;
		case "sabado":
		case "domingo":
			System.out.println("A disfrutar el fin de semana");
			break;
		default:
			System.out.println("Ingrese un dia correcto");
		}
	}
	 /*
	public static void cascada(Scanner sc) {
		int numeroMes = sc.nextInt();
    	String estacion = "", mes = "";

    	switch (numeroMes) {
    	  case 12:
    	    mes = "Diciembre";
    	    estacion = "Invierno";
    	    break;
    	  case 1:
    	    mes = "Enero";
    	    estacion = "Invierno";
    	    break;
    	  case 2:
    	    mes = "Febrero";
    	    estacion = "Invierno";
    	    break;
    	  case 3:
    	    mes = "Marzo";
    	    estacion = "Primavera";
    	    break;
    	  case 4:
    	    mes = "Abril";
    	    estacion = "Primavera";
    	    break;
    	  case 5:
    	    mes = "Mayo";
    	    estacion = "Primavera";
    	    break;
    	  case 6:
    	    mes = "Junio";
    	    estacion = "Verano";
    	    break;
    	  case 7:
    	    mes = "Julio";
    	    estacion = "Verano";
    	    break;
    	  case 8:
    	    mes = "Agosto";
    	    estacion = "Verano";
    	    break;
    	  case 9:
    	    mes = "Septiembre";
    	    estacion = "Otoño";
    	    break;
    	  case 10:
    	    mes = "Octubre";
    	    estacion = "Otoño";
    	    break;
    	  case 11:
    	    mes = "Noviembre";
    	    estacion = "Otoño";
    	    break;
    	}

    	System.out.println("El mes de " + mes + " se encuentra en la estación " + estacion);
	}*/
}
