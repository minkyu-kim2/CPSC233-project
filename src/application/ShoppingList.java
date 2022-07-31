package application;

import java.util.ArrayList;

public class ShoppingList {
	private ArrayList<Item> items;
	private double totalPrice; 
	
	public ShoppingList() {
		// TODO Auto-generated constructor stub
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
	
	public void addItem(Item item) {
		if (items == null)
			items = new ArrayList<Item>();
		items.add(item);
	}

	public double getTotalPrice() {
		return 0;
	}
	
}
