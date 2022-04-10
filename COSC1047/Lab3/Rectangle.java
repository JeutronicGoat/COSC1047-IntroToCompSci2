

public class Rectangle extends GeometricObject implements Comparable<Rectangle>{

	private int width = 0;
	private int height = 0;
	
	
	public Rectangle(int width, int heigth, int coordX, int coordY) {
		this.width = width;
		this.height = height;
		setCoordX(coordX);
		setCoordY(coordY);
	}
	
	public Rectangle(String colour, boolean filled, int width, int heigth, int coordX, int coordY) {
		super(colour, filled);
		this.width = width;
		this.height = height;
		setCoordX(coordX);
		setCoordY(coordY);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int compareTo(Rectangle rec) {
		if(this.getArea() > rec.getArea()) {
			return 1;
		}
		else if(this.getArea() == rec.getArea()) {
			return 0;
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object rec) {
		if(rec instanceof Rectangle) {
			return (this.getArea() == ((Rectangle)rec).getArea());
		}
		return false;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (height + width) * 2;
	}
}
