package application;

import java.util.ArrayList;

public class ShoppingList {
	private ArrayList<Item> items;
	private double totalPrice; 
	
	public ShoppingList() {
		super();
	}
	
	public ShoppingList(ArrayList<Item> items) {
		this.items = items; 
	}
	

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	/**
	 * This function adds item to the shopping list object.
	 * 
	 * @param item
	 * @return
	 */
	public boolean add(Item item) {
		if (items == null)
			items = new ArrayList<Item>();
		return items.add(item);
	}
	
	// to be implemented
	public double getTotalPrice() {
		return 0;
	}
	
	
}
