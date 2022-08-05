package application;

import java.util.ArrayList;

public class ShoppingList {
	private ArrayList<Item> items;
	private double totalPrice;

	public ShoppingList() {
		this.items = new ArrayList<Item>();
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
	 * @return true is item gets added succesfully
	 */
	public boolean add(Item item) {
		if (items == null)
			items = new ArrayList<Item>();
		return items.add(item);
	}

	/**
	 * to be implemented
	 * 
	 * @return sum of the price of all items in the Shopping List
	 */
	public double getTotalPrice() {
		return 0;
	}

}
