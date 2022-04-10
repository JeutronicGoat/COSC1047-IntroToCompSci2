import java.util.*;

public class SmallestIntegers {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.print("Enter an integer m: ");
		int m = in.nextInt();
		
		//all the factors
		for(int i = 2, tempM = m; tempM > 1; i++) {
			
			if(tempM % i == 0) {
				tempM /= i;
				list.add(i);
				i = 1;
			}
		}

		//what elements occur an odd amount of times
		ArrayList<Integer> listOfOddOccuringNums = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++) {
			
			if(listOfOddOccuringNums.contains(list.get(i))) {
				listOfOddOccuringNums.remove(list.get(i));
			}
			else {
				listOfOddOccuringNums.add(list.get(i));
			}
		}
		
		//calculating value of n
		int n = 1;
		for(int i = 0; i < listOfOddOccuringNums.size(); i++) {
			n *= listOfOddOccuringNums.get(i);
		}
		
		//answer output
		System.out.println("The smallest number n for m * n to be a perfect square is " + n + " m * n is " + (m * n) + ".");
		System.out.println("The value " + (int)Math.sqrt(m * n) + " squared equals " + (m * n) + ".");
		
	}
}
