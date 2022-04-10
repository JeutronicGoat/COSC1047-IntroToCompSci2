
public class MyRectangle2D {

	double x = 0;
	
	double y = 0;
	
	int width = 1;
	
	int height = 1;
	
	
	public MyRectangle2D() {	
	}
	
	public MyRectangle2D(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setX (double x) {
		this.x = x;
	}
	
	public void setY (double y) {
		this.y = y;
	}
	
	public double getX () {
		return x;
	}
	
	public double getY () {
		return y;
	}
	
	public void setWidth (int w) {
		width = w;
	}
	
	public void setHeight (int h) {
		height = h;
	}
	
	public double getWidth () {
		return width;
	}
	
	public double getHeight () {
		return height;
	}
	
	public int getArea() {
		return width * height;
	}
	
	public int getPerimeter() {
		return (width + height) * 2;
	}
	
	public boolean contains(double x, double y) {
		if (x < this.x + (width / 2.0)
				&& x > this.x - (width / 2.0)
				&& y < this.y + (height / 2.0)
				&& y > this.y - (height / 2.0)) {
			return true;
		}
		else {
			return false;

		}
	}
	
	public boolean contains(MyRectangle2D r) {
		if(contains(r.x, r.y) && contains(r.x + r.width, r.y + r.height)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean overlaps(MyRectangle2D r) {
		if(contains(r.x, r.y) ^ contains(r.x + r.width, r.y + r.height)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Rectangle centered at (" + x + "," + y + ") with a width of " + width + " and height of " + height 
				//top left corner
				+ " with corners at (" + (x - (width / 2.0)) + ", " + (y + (height / 2.0)) + "), (" 
				//top right corner
				+ (x + (width / 2.0)) + ", " + (y + (height / 2.0)) + "), ("
				//bottom left corner
				+ (x - (width / 2.0)) + ", " + (y - (height / 2.0)) + "), ("
				//bottom right corner
				+ (x + (width / 2.0)) + ", " + (y - (height / 2.0)) + ").";
	}
}
