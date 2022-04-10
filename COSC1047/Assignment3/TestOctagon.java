import java.util.Scanner;

public class TestOctagon {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//get data
		System.out.print("Please enter an integer for size: ");
		Octagon oct = new Octagon(in.nextInt());
		
		System.out.println("Octagon1:\n" + oct.toString());
		
		//clone
		Octagon oct2 = (Octagon) oct.clone();
		
		System.out.println();
		
		//comparing  with compareTo
		int compare = oct.compareTo(oct2);
		if(compare == 1) {
			System.out.println("Octagon1's area is greater than Octagon2's");
		}
		else if(compare == 0) {
			System.out.println("Octagon1's area is the same as Octagon2's");
		}
		else {
			System.out.println("Octagon1's area is less than Octagon2's");
		}
		
		//equals
		System.out.println("Octagon1 = Octagon2: " + oct.equals(oct2));
	}
	
}
