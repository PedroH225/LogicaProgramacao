package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class main {
	
	public static void main(String[] args) {
		List<Integer> listNum = new ArrayList<Integer>(Arrays.asList(20,3,2,1,1,10,5,4));
		
		List<Integer> listOrdenada = ordenarNum(listNum);
		
		System.out.println(listOrdenada);
		
		
	}
	public static List<Integer> ordenarNum(List<Integer> listNum) {
		List<Integer> ordenadoNums = new ArrayList<Integer>();
		Integer size = listNum.size();
		
		while (ordenadoNums.size() <  size) {
			Integer menorNum = listNum.get(0);

			for (int i = 1; i < listNum.size(); i++) {
				if (listNum.get(i) <= menorNum) {
					menorNum = listNum.get(i);
					
				}
			}
			
			ordenadoNums.add(menorNum);
			listNum.remove(menorNum);
			
		}
		
		return ordenadoNums;
	}
}
