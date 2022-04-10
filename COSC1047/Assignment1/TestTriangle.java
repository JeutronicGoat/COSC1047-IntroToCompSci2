import java.util.Scanner;

public class TestTriangle {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter three sides of a triangle: ");
		double side1 = in.nextInt();
		double side2 = in.nextInt();
		double side3 = in.nextInt();
		
		Triangle tri = new Triangle(side1, side2, side3);
		
		System.out.print("Please enter the triangles colour: ");
		in.nextLine();
		tri.setColour(in.nextLine());
		
		System.out.print("Please enter whether or not the triangle is filled: ");
		tri.setFilled(in.nextBoolean());
		
		System.out.println(tri.toString());
	}
}
