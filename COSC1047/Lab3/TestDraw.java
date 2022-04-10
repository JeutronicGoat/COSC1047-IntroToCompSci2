
public class TestDraw {

	public static void main(String[] args) {
		
		GeometricObject[] geoObj = new GeometricObject[4];
		
		geoObj[0] = new Rectangle("Red", true, 30, 30, 10, 10);
		geoObj[1] = new Rectangle("Blue", false, 40, 40, 10, 60);
		
		geoObj[2] = geoObj[1];
		
		geoObj[2].setColor("Green"); 
		geoObj[2].setCoordX(60); geoObj[2].setCoordY(10);
		
		for(int i = 0; i < geoObj.length; i++) {
			if(geoObj[i] instanceof Rectangle) {
				System.out.println(geoObj[i]);
				
				System.out.println(geoObj[i].hashCode());
				System.out.println();
			}
			else {
				System.out.println("It be a big ol' Nada.");
			}
		}
	}
}
