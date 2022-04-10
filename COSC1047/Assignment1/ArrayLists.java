import java.util.*;

public class ArrayLists {

	public static void shuffle(ArrayList<Integer> list) {
		int length = list.size();
		
		for(int i = 0; i <= length; i++) {
			//index's
			int randomIndex1 = random(0, length - 1);
			int randomIndex2 = random(0, length - 1);
			//numbers at the index's
			int num1 = list.get(randomIndex1);
			int num2 = list.get(randomIndex2);
			
			//switching them
			list.add(randomIndex1, num2);
			list.remove(randomIndex1 + 1);
			
			list.add(randomIndex2, num1);
			list.remove(randomIndex2 + 1);
		}
	}
	
	//random num generator
	private static int random(int low, int high) {
		return low + (int)(Math.random() * (high - low + 1));
	}
}
