package application;

public class Item {
	private String name;
	private double price;
	private String category;
	private String description;
	
	public Item(String name, double price, String description) {
		setName(name);
		setPrice(price);
		setDescription(description);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
