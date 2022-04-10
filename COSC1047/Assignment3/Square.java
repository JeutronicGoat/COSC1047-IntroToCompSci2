
public class Square extends GeometricObject implements Colourable{

	private int size = 1;

	public Square() {}
	
	public Square(int size) {
		this.size = size;
	}
	
	public Square(String colour, boolean filled, int size) {
		super(colour, filled);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getArea() {
		return size * size;
	}
	
	public int getPerimeter() {
		return size * 4;
	}
	
	@Override
	public String howToColour() {
		return "Colour all four sides.";
	}
	
	@Override
	public String toString() {
		return "This square's size is " + size + " and its area is " + getArea() + ".";
	}
	
}
