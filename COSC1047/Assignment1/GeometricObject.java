
public class GeometricObject {

	String colour = "black";
	
	boolean filled = false;
	
	
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
	
	@Override
	public String toString() {
		return "The shapes colour is " + colour + " and it is" + (getFilled() ? "" : " not") + " filled.";
	}
}
