
	abstract class GeometricObject {

	private String colour = "black";
	
	private boolean filled = false;
	
	
	public GeometricObject() {}
	
	public GeometricObject(String colour, boolean filled) {
		this.colour = colour;
		this.filled = filled;
	}
	
	public void setColour(String s) {
		colour = s;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setFilled(boolean f) {
		filled = f;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public abstract double getArea();
	
	public abstract int getPerimeter();
	
	@Override
	public String toString() {
		return "The shapes colour is " + colour + " and it is" + (getFilled() ? "" : " not") + " filled.";
	}

	
}
