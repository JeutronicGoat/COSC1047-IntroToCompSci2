
public class Scooter extends ElectricVehicle{

	private int currentGear = 1;
	
	public Scooter(String brand, String colour) {
		super(brand, 2, colour);
	}
	
	public Scooter(int gear, double charge) {
		currentGear = gear;
		setNumOfTires(2);
		setCharge(charge);
	}
	
	public void setGear(int gear) {
		currentGear = gear;
	}
	
	public int getGear() {
		return currentGear;
	}
	
	@Override
	public String toString() {
		return  super.toString() + ": Scooter";
	}
	
}
