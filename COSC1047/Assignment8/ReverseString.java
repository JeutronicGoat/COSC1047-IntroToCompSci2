import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a String to be reversed: ");		
		reverseDisplay(in.nextLine());
	}
	
	public static void reverseDisplay(String value) {
		
		if(value.length() == 1) {
			System.out.print(value);
		}
		else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}
}
