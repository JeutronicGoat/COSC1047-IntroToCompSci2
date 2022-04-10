import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//num of elements
		System.out.print("Please enter the number of elements you want in the list: ");
		int numberOfInts = in.nextInt();
		
		ArrayList list1 = new ArrayList<Integer>();
		
		//values of elements
		System.out.print("Please enter the values: ");
		for(int i = 0; i < numberOfInts; i++) {
			list1.add(in.nextInt());
		}
		
		ArrayLists.shuffle(list1);
		System.out.println(list1.toString());
	}
}
