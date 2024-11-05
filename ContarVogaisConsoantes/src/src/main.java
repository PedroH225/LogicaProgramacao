package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class main {

	public static void main(String[] args) {
		contarVogalConsoante("Jabuticaba");
		contarVogalConsoante("Psst");


	}
	
	public static void contarVogalConsoante (String palavra) {
		List<String> vogais = Arrays.asList("a", "e", "i", "o", "u");
		List<String> consoantes = Arrays.asList(
			    "b", "c", "d", "f", "g", "h", "j", "k", "l", "m",
			    "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"
			);
		
		Integer countVogais = 0;
		Integer countConsoantes = 0;
		
		String[] lowerSplitPalavra =  palavra.toLowerCase().split("");
		
		for (String letra : lowerSplitPalavra) {
			if (vogais.contains(letra)) {
				countVogais++;
			}
			if (consoantes.contains(letra)) {
				countConsoantes++;
			}
		}
		
		System.out.printf("A palavra: %s, possúi %d vogais e %d consoantes.%n", palavra, countVogais, countConsoantes);
			
	}

}
