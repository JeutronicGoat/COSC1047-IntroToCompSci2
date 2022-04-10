
public class Triangle extends GeometricObject{

	double side1 = 1.0;
	
	double side2 = 1.0;

	double side3 = 1.0;

	
	public Triangle() {
		
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	@Override
	public String toString() {
		String s = "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 " + side3 + ".";
		if(validCheck()) {
			return s + "\n" + super.toString(); //calls GeometricObject's toString
		}
		else {
			return "The area = ZERO and perimeter = ZERO.\n" + s + "\nINVALID.";
		}
	}
	
	//chack if any 2 sides are greater than the remaining side
	private boolean validCheck() {
		if(side1 + side2 < side3
				|| side1 + side3 < side2
				|| side2 + side3 < side1) {
			return false;
		}
		else {
			return true;
		}
	}
}
