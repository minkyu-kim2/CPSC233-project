package application;

public class RealEstate extends Item{
	private String address;
	private String classification;

	
	public RealEstate() {
		super();
		setAddress("");
		setClassification("");

	}
	
	// constructor with all fields
	public RealEstate(String name, double price, String description, int quantity, String address, String type) {
		super(name, price, description, quantity, "real estate");
		this.setAddress(address);
		this.setClassification(type);
	}

	// constructor based on object of type Item
	public RealEstate(Item item) {
		super(item);
		address = "";
		classification = "";
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classfication) {
		this.classification = classfication;
	}
	
	

}
