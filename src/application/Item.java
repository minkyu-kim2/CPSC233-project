package application;

public class Item {
	private String name;
	private double price;
	private String category;
	private String description;
	private int quantity;
	
	// constructor called when no argument is provided.
	public Item() {
		setName("");
		setPrice(0);
		setDescription("");
		setQuantity(1);
		setCategory("other");
	}
	
	// constructor called when all the field data is provided from the argument list
	public Item(String name, double price, String description, int quantity, String category) {
		setName(name);
		setPrice(price);
		setDescription(description);
		setQuantity(quantity);
		setCategory(category);
	}
	
	// constructor used for creating a copy of an existing Item object 
	public Item(Item item) {
		setName(item.name);
		setPrice(item.price);
		setDescription(item.description);
		setQuantity(item.quantity);
		setCategory(item.category);
	}
	
	// methods below are setters and getters
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
