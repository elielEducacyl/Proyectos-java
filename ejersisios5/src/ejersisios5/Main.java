package ejersisios5;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		//cuadrado(in);
//		verificarNumero(in);
		temperatura(in);
		
		in.close();
	}
	
	public static void cuadrado (Scanner in) {
		System.out.println("Ingrese el lado del cuadrado: ");
		int lado = in.nextInt();
		
		int area = areaCuadrado (lado);
		System.out.println("El area del cuadrado es: " + area);
		
		int perimetro = perimetroCuadrado(lado);
		System.out.println("El perimetro del cuadrado es: " + perimetro);
	}
	
	public static int areaCuadrado (int lado) {
		int resultado;
		
		resultado = lado * lado;
		
		return resultado;
	}
	
	public static int perimetroCuadrado (int lado) {
		int resultado;
		
		resultado = lado * 4;
		
		return resultado;
	}
	
	public static void verificarNumero (Scanner in) {
		System.out.println("Ingrese un numero: ");
		int num = in.nextInt();
		
		if (verificador(num)) {
			System.out.println("El numero " + num + " es positivo");
		} else {
			System.out.println("El numero " + num + " es negativo ");
		}

	}
	
	public static boolean verificador (int num) {
		if (0 == (num % 2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void temperatura (Scanner in) {
		int seleccion;
		boolean eFarenheit = false;
		boolean eCelsius = false;
		boolean continuar = true;
		
		do {
			System.out.println("Quiere convertir de Celsius a Farenheit (1) o Farenheit a Celsius? (2)");
			seleccion = in.nextInt();
			
			switch (seleccion) {
			case 1: 
				System.out.println("Se convertira de Calsius a Farenheit");
				eCelsius = true;
				continuar = false;
				break;
			case 2: 
				System.out.println("Se convertira de Farenehit a Celsius");
				eFarenheit = true;
				continuar = false;
				break;
			default: 
				System.out.println("Seleccione correctamente");
				continuar = true;
			}
		} while (continuar);
		
		System.out.println("Ingrese la temperatura: ");
		double temp = in.nextDouble();
		double tempConvertida;
		
		if (eCelsius) {
			tempConvertida = cenAFar(temp);
			System.out.println("Los " + temp + "º C son " + tempConvertida + "º en Farenheit");
		} else {
			tempConvertida = farACen(temp);
			System.out.println("Los " + temp + "º F son " + tempConvertida + "º en Celsius");
		}
	}
	
	public static double cenAFar (double c) {
		double farenheit;
		
		farenheit = Math.round(c * ( 5 / 9 ) + 32);
		return farenheit;
	}
	
	public static double farACen (double f) {
		double celsios;
		
		celsios = Math.round((f - 32)*(5 / 9));
		return celsios;
	}

}