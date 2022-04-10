
public class ElectricVehicle extends Vehicle {

	private double chargeLevel = 0;
	
	private boolean isRunning = false;
	
	public ElectricVehicle() {
		
	}
	
	public ElectricVehicle(String brand, int numOfTires, String colour) {
		super(brand, numOfTires, colour);
	}
	
	public void setCharge(double charge) {
		chargeLevel = charge;
	}
	
	public double getCharge() {
		return chargeLevel;
	}
	
	public boolean isOn() {
		return isRunning;
	}
	
	public void turnOn() {
		isRunning = true;
	}
	
	public void turnOff() {
		isRunning = false;
	}
	
	@Override
	public String toString() {
		return "Electric Vehicle";
	}
	
}
