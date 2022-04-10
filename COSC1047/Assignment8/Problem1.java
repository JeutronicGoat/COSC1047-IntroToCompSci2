import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a number for i: ");
		double i = in.nextDouble();
		
		System.out.printf("The loop solution is: %3.3f", loopSolution(i));
		System.out.printf("\nThe recursive solution is: %3.3f", recursiveSolution(i));
	}
	
	public static double loopSolution(double i) {
		double solution = 0;
		for( ; i > 1; i--) {
			solution += (2 * i) / (3 * i - 1);
		}
		return solution + 1;
	}
	
	public static double recursiveSolution(double i) {
		
		if(i == 1) return 1;
		
		return (2 * i) / (3 * i - 1) + recursiveSolution(i - 1);
	}
}
