import java.util.Scanner;

public class TestComplex {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the first Complex number: ");
		Complex complex1 = new Complex(in.nextDouble(), in.nextDouble());
		
		System.out.print("Enter the second Complex number: ");
		Complex complex2 = new Complex(in.nextDouble(), in.nextDouble());
		
		//reassignable object for answers
		Complex answers = new Complex();
		
		answers = complex1.add(complex2);
		System.out.println("(" + complex1.getA() + " + " + complex1.getB() + "i) + (" + complex2.getA() + " + " + complex2.getB() + "i) = " +
				answers.getA() + " + " + answers.getB() + "i");
		
		answers = complex1.subtract(complex2);
		System.out.println("(" + complex1.getA() + " + " + complex1.getB() + "i) - (" + complex2.getA() + " + " + complex2.getB() + "i) = " +
				answers.getA() + " + " + answers.getB() + "i");
		
		answers = complex1.multiply(complex2);
		System.out.println("(" + complex1.getA() + " + " + complex1.getB() + "i) * (" + complex2.getA() + " + " + complex2.getB() + "i) = " +
				answers.getA() + " + " + answers.getB() + "i");
		
		answers = complex1.divide(complex2);
		System.out.println("(" + complex1.getA() + " + " + complex1.getB() + "i) / (" + complex2.getA() + " + " + complex2.getB() + "i) = " +
				answers.getA() + " + " + answers.getB() + "i");
		
		System.out.println("|(" + complex1.getA() + " + " + complex1.getB() + "i)| = " + complex1.abs());
	}
}
