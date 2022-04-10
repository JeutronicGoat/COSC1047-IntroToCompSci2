
public class TestSquare {

	public static void main(String[] args) {
		
		GeometricObject[] geoObjs = new GeometricObject[5];
		
		for(int i = 0; i < 5; i++) {
			geoObjs[i] = new Square(randomSize(2,10));
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println("The area is: " + geoObjs[i].getArea() + ".");
			
			if(geoObjs[i] instanceof Colourable) {
				System.out.println(((Square)geoObjs[i]).howToColour());
			}
		}
	}
	
	//makes a random size for square
	public static int randomSize(int low, int high) {
		if(low > high) {
			int temp = low;
			low = high;
			high = low;
		}
		
		return (int)(Math.random() * (high - low + 1)) + low;
	}
}
