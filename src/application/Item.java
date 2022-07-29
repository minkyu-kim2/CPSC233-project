package application;

public class Item {
	private String name;
	private double price;
	private String category;
	private String description;
	private int quantity;
	
	public Item(String name, double price, String description, int quantity) {
		setName(name);
		setPrice(price);
		setDescription(description);
		setQuantity(quantity);
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
	
	public int getQuantity() {
		return quantity; 
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity; 
	}
	
	
}
