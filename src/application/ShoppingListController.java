package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import application.Item;
import exceptions.NoFxmlException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShoppingListController {
	private static String pathToFxml = "src/application/ShoppingList.fxml";
	private Stage applicationStage; 
	private ShoppingList shoppingList;
	
    @FXML
    private Label projectGradeTextfield;
    
    @FXML
    private Button newItemButton; 
	
    @FXML
    private VBox itemStack; 
    
	public ShoppingListController(Item item) {
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingListController() {
		
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage; 
	}
	
	public void addNewItem(ActionEvent event) {
 		
	}
	
	
	public void appendItems() {
		
		for (Item item : shoppingList.getItems()) {
        	HBox itemRow = new HBox();
        	Label itemLabel = new Label("name: " + item.getName() + " price:" + item.getPrice());
        	Button detailButton = new Button("detail");        	
        	itemRow.getChildren().addAll(itemLabel, detailButton);
        	itemStack.getChildren().add(itemRow);
    	}
	}
	
	public static String getPathToFxml() {
		return ShoppingListController.pathToFxml;
	}
	
	public void showPage() throws FileNotFoundException, IOException {
		this.appendItems();
		applicationStage.setTitle("my shopping list");
		applicationStage.show();
		
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}
	
}
