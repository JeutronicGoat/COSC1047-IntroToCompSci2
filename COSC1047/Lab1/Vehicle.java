

public class Vehicle {

	private java.util.Date date = new java.util.Date();
	
	private String brand = "Unspecified";
	
	private int numOfTires = 0;
	
	private String colour = "Black";
	
	public Vehicle() {
		
	}
	
	public Vehicle(String brand, int numOfTires, String colour) {
		this.brand = brand;
		this.numOfTires = numOfTires;
		this.colour = colour;
	}
	
	public Vehicle(int numOfTires) {
		this.numOfTires = numOfTires;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumOfTires() {
		return numOfTires;
	}
	
	public void setNumOfTires(int numOfTires) {
		this.numOfTires = numOfTires;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public java.util.Date getCreationDate(){
		return date;
	}
}
