package ahorcado;

import static ahorcado.UtilidadesAhorcado.obtenerPalabraAleatoria;
import static ahorcado.UtilidadesAhorcado.dibujarAhorcado;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//String palabra = obtenerPalabraAleatoria();
		String palabra = "HOLA";
		char[] cPalabra = palabra.toCharArray();
		int lonPalabra = palabra.length();
		String letraStr = " ";
		char letra = ' ';
		
		char[] respuesta = new char[lonPalabra];
		
		boolean esCorrecto = false;
		
		int errores = 0;
		int itr = 0;
		
		for (int i=0 ; i < lonPalabra; i++) {
			respuesta[i] = '_';
		}
		
		
		while (!esCorrecto && errores <= 6 && itr != lonPalabra) {
			
			dibujarAhorcado(errores);
			System.out.println("Ingrese una letra");
			letraStr = in.next();
			letraStr = letraStr.toUpperCase();
			
			letra = letraStr.charAt(0);
			
			if (letra == cPalabra[itr]) {
				System.out.println("La letra es correcta, siguiente letra");
				respuesta[itr] = letra;
			} else {
				errores++;
			} 
			
			itr++;
			System.out.println("Correctas: ");
			for (char i : respuesta) {
				System.out.print(i+", ");
			}
			System.out.println(" ");
		}
		
		for (int i = 0; i < lonPalabra ; i++) { 
			
			if (respuesta[i] == cPalabra[i]) {
				esCorrecto = true;
				System.out.println("e velda");
			} else 
				System.out.println("no e velda");
		}
		
		if (esCorrecto) {
			System.out.println("la respuesta es correcta");
		} else {
			System.out.println("La respuesta no es correcta");
			System.out.println(palabra);
		}
		
		in.close(); 
	}
}
