
public class Car extends GasVehicle{

	private int numOfDoors = 2;
	
	public Car(int numDoors, double gas) {
		numOfDoors = numDoors;
		setNumOfTires(4);
		setGas(gas);
	}
	
	public Car (int numDoors, String brand, String colour) {
		super(brand, 4, colour);
		numOfDoors = numDoors;
	}
	
	public void setNumOfDoors(int doors) {
		numOfDoors = doors;
	}
	
	public int getNumOfDoors() {
		return numOfDoors;
	}
	
	@Override
	public String toString() {
		return "Gas Vehicle: Car";
	}
}
