package eliel_26_10;

public class Arrays {
	public static void main(String[] args) {
		
		String[] diasSemana = {"L", "M", "X", "J", "V"};
		
		System.out.println("--- Recorrido FOREACH ---");
		for (var dia : diasSemana) {
		System.out.println("Día: " + dia);
		}
		int itr = 0;
		for (var dia : diasSemana) {
			diasSemana[itr] = "V";
			System.out.println(dia);
			itr++;
		}
		for (var dia : diasSemana) {
		System.out.println("Día: " + dia);
		}
	}
}
