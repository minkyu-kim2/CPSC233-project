package application;

public class Car extends Item {
	private String model; 
	private String make;
	private int year; 
	public Car() {
		super();
		model = "";
		make = "";
		year = 2020;
	}
	public Car(String name, double price, String description, int quantity, String model, String make, int year) {
		super(name, price, description, quantity, "car");
		this.model = model;
		this.make = make;
		this.year = year;
	}
	public Car(Item item) {
		super(item);
		model = "";
		make = "";
		year = 2020;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
