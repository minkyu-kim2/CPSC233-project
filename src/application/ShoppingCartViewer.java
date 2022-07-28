package application;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// receives list of items and displays the items and the total price 
public class ShoppingCartViewer {
	private ArrayList<Item> items;
	private double totalPrice; 
	private Stage applicationStage; 
	
	public ShoppingCartViewer(ArrayList<Item> items) {
		setItems(items);
	}
	
	public void show() {
		VBox allRows = new VBox(); 
    	for (Item item : this.items) {
        	HBox itemRow = new HBox();
        	Label itemLabel = new Label("name: " + item.getName() + " price:" + item.getPrice());
        	Button detailButton = new Button("detail");        	
        	itemRow.getChildren().addAll(itemLabel, detailButton);
        	allRows.getChildren().add(itemRow);
    	}
    	
    	Label itemLabel = new Label(String.format("Total price: %.2f", totalPrice));
    	Button newItemButton = new Button("Add a new item");
    	//newItemButton.setOnAction(doneEvent -> addItem());
    	allRows.getChildren().addAll(itemLabel, newItemButton);
    	
    	Scene cartScene = new Scene(allRows, 500, 500);
    	getApplicationStage().setScene(cartScene);
    	getApplicationStage().show();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	private void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Stage getApplicationStage() {
		return applicationStage;
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}
	
}
