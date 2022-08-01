package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;

public class ItemPageController {
	private static String pathToFxml = "src/application/ItemPage.fxml";
	private Item item; 
	private Stage applicationStage; 
	private ShoppingList shoppingList; 
	
	@FXML Label categoryLabel;
	@FXML Label nameLabel;
	@FXML Label priceLabel;
	@FXML Label detailLabel;
	@FXML Label quantityLabel;
	@FXML public void delete(ActionEvent event) {}
	@FXML public void edit(ActionEvent event) {}
	
	
	@FXML 
	public void close(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		VBox root;
		try {
			root = loader.load(new FileInputStream(ShoppingListController.getPathToFxml()));
			Scene scene = new Scene(root,500,400);
			applicationStage.setScene(scene);
			applicationStage.setTitle("my shopping list");
			ShoppingListController shoppingListController = loader.getController(); 
			shoppingListController.setApplicationStage(applicationStage);
			shoppingListController.setShoppingList(shoppingList);
			shoppingListController.fillPage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Stage getApplicationStage() {
		return applicationStage;
	}
	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}
	
	public void fillPage() {
		nameLabel.setText(item.getName());
		categoryLabel.setText(item.getCategory());
		priceLabel.setText(item.getPrice()+"");
		detailLabel.setText(item.getDescription());
		quantityLabel.setText(item.getQuantity()+"");
		applicationStage.setTitle("Item: " + item.getName() );
		applicationStage.show();
		
	}
	public static String getPathToFxml() {
		return pathToFxml;
	}
	public ShoppingList getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

}
