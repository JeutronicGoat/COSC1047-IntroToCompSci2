
public class Complex implements Cloneable{

	private double a;
	private double b;

	
	public Complex() {
		this(0,0);
	}
	
	public Complex(double a) {
		this.a = a;
	}

	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getRealPart() {
		return a;
	}
	
	public double getImaginaryPart() {
		return b;
	}
	
	public Complex add(Complex complex2) {
		Complex answer = new Complex(a + complex2.a, b + complex2.b);
		return answer;
	}
	
	public Complex subtract(Complex complex2) {
		Complex answer = new Complex(a - complex2.a, b - complex2.b);
		return answer;
	}
	
	public Complex multiply(Complex complex2) {
		Complex answer = new Complex((a * complex2.a) - (b * complex2.b),
				(b * complex2.a) + (a * complex2.b));
		return answer;
	}
	
	public Complex divide(Complex complex2) {
		Complex answer = new Complex(((a * complex2.a) + (b * complex2.b)) / (Math.pow(complex2.a, 2) + Math.pow(complex2.b, 2)),
				(((b * complex2.a) - (a * complex2.b)) / (Math.pow(complex2.a, 2) + Math.pow(complex2.b, 2))));
		return answer;
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	@Override
	public Complex clone() {
		try {
			return (Complex)super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Error: This clone is not supproted!!");
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "(" + a + ", " + b + "i)";
	}
}
