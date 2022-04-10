
public class GasVehicle extends Vehicle {

	private double gasInTank = 0;
	
	private boolean isRunning = false;
	
	public GasVehicle() {	
	}
	
	public GasVehicle(String brand, int numOfTires, String colour) {
		super(brand, numOfTires, colour);
	}
	
	public void setGas(double gas) {
		gasInTank = gas;
	}
	
	public double getGas() {
		return gasInTank;
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
		return "Gas Vehicle";
	}
}
