import java.util.Scanner;

public class RecursiveLab {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("Please enter a number and a base: ");
			int dec = in.nextInt();
			int base = in.nextInt();
			
			if(dec == 0) break;
			if(base < 2) break;
			
			System.out.println(dec + " in base " + base + " is " + decToBase(dec, base));
		}
		
	}
	
	public static String decToBase(int dec, int base) {
		
		if(dec == 0) return "";
		
		
		return decToBase(dec/base, base) + ((dec % base) > 9 ? "" +('A' + ((dec % base) - 10)) : Integer.toString(dec % base));
		
	}
	
}
