package src;

public class main {

	public static void main(String[] args) {
		calcularFatorial(10);
		
	}

	private static void calcularFatorial(Integer input) {
		Integer result = 1;
		for (Integer i = input; i > 1; i--) {
			result *= i;
			
		}
		System.out.println(result);
	}
}
