import java.util.Scanner;

public class FibProblem {

	static int count;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter the number you want to calculate the fib of: ");
		int i = in.nextInt();
		
		System.out.println("The Fib of " + i  + " is: " + calcFib(i));
		System.out.println("The number of times the Fib method was called is: " + count);
	}
	
	public static int calcFib(int i) {
		count++;
		
		if(i == 1) return 1;
		if(i == 0) return 0;
		
		return calcFib(i - 1) + calcFib(i - 2);
	}
}
