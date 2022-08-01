package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import application.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShoppingListPageController extends PageController{
	private static String pathToFxml = "src/application/ShoppingListPage.fxml";
	
    @FXML
    private Label projectGradeTextfield;
    
    @FXML
    private Button newItemButton; 
	
    @FXML
    private VBox itemStack; 
    
	
	public void addNewItem(ActionEvent event) throws FileNotFoundException, IOException {
		Scene currentScene = applicationStage.getScene();
		CategorySelectionPageController controller = (CategorySelectionPageController) loadPage(null, CategorySelectionPageController.getPathToFxml(), applicationStage, shoppingList, "create a new item");
		controller.setPreviousScene(currentScene);
	}
	
	
	public void appendItems() {
		
		for (Item item : shoppingList.getItems()) {
        	HBox itemRow = new HBox();
        	Label itemLabel = new Label("name: " + item.getName() + " price:" + item.getPrice());
        	Button detailButton = new Button("detail");        	
        	
        	//adding event listeners to detail buttons
        	detailButton.setOnAction(e -> {
        		try {
					showItemPage(item);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	});
        	
        	itemRow.getChildren().addAll(itemLabel, detailButton);
        	itemStack.getChildren().add(itemRow);
    	}
	}
	
	public static String getPathToFxml() {
		return ShoppingListPageController.pathToFxml;
	}
	
	public void fillPage() throws FileNotFoundException, IOException {
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
	
	public void showItemPage(Item item) throws FileNotFoundException, IOException {
		String pathToFxml;
		if (item instanceof Car) 
			pathToFxml = CarPageController.getPathToFxml();
		else
			pathToFxml = ItemPageController.getPathToFxml();
		
		super.loadPage(item, pathToFxml, applicationStage, shoppingList, "Item: " + item.getName());
	}
}
