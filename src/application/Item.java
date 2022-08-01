package application;

public class Item {
	private String name;
	private double price;
	private String category;
	private String description;
	private int quantity;
	
	public Item() {
		setName("");
		setPrice(0);
		setDescription("");
		setQuantity(1);
		setCategory("other");
	}
	
	public Item(String name, double price, String description, int quantity, String catogory) {
		setName(name);
		setPrice(price);
		setDescription(description);
		setQuantity(quantity);
		setCategory(category);
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
