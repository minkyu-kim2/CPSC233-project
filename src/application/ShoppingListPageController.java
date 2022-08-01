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

public class ShoppingListPageController {
	private static String pathToFxml = "src/application/ShoppingList.fxml";
	private Stage applicationStage; 
	private ShoppingList shoppingList;
	
    @FXML
    private Label projectGradeTextfield;
    
    @FXML
    private Button newItemButton; 
	
    @FXML
    private VBox itemStack; 
    
	public ShoppingListPageController(Item item) {
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingListPageController() {
		
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage; 
	}
	
	public void addNewItem(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		VBox root;
		try {
			Scene currentScene = applicationStage.getScene();
			
			root = loader.load(new FileInputStream(CategorySelectionPageController.getPathToFxml()));
			Scene scene = new Scene(root,500,400);
			applicationStage.setScene(scene);
			applicationStage.setTitle("my shopping list");
			CategorySelectionPageController controller = loader.getController(); 
			
			controller.setPreviousScene(currentScene);
			controller.setItem(null);
			
			controller.setApplicationStage(applicationStage);
			controller.setShoppingList(shoppingList);
			
			System.out.println("at ShoppingListController" + shoppingList.getItems().size());
			
			controller.fillPage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void appendItems() {
		
		for (Item item : shoppingList.getItems()) {
        	HBox itemRow = new HBox();
        	Label itemLabel = new Label("name: " + item.getName() + " price:" + item.getPrice());
        	Button detailButton = new Button("detail");        	
        	
        	//on button click, load the item detail page
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
		
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream(pathToFxml));
		Scene scene = new Scene(root,500,400);
		ItemPageController itemPageController = loader.getController(); 
		itemPageController.setItem(item);
		itemPageController.setApplicationStage(applicationStage);
		itemPageController.fillPage();
		itemPageController.setShoppingList(shoppingList);
		applicationStage.setScene(scene);
	}
	
}
