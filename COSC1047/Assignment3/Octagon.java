
public class Octagon extends GeometricObject
	implements Comparable<Octagon>, Cloneable{

	private int size = 1;
	
	
	public Octagon() {}
	
	public Octagon(int size) {
		this.size = size;
	}
	
	public Octagon(String colour, boolean filled, int size) {
		super(colour, filled);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * size * size;
	}

	@Override
	public int getPerimeter() {
		return size * 8;
	}

	@Override
	public int compareTo(Octagon oct) {
		if(getArea() > oct.getArea()) {
			return 1;
		}
		else if(getArea() == oct.getArea()) {
			return 0;
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object oct) {
		if(oct instanceof Octagon) {
			return (getArea() == ((Octagon)oct).getArea());
		}
		return false;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} 
		catch (CloneNotSupportedException cnse) {
			System.out.println("Error: This clone is not supported.");
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "The size is " + size + ", the area is " + getArea() + " and the perimeter is " + getPerimeter() + ".";
	}

	
}
