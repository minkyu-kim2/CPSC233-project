package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CategorySelectionPageController {
    private static String pathToFxml = "src/application/CategorySelectionPage.fxml";
    private Stage applicationStage; 
	private Item item; 
	private ShoppingList shoppingList; 
    
	@FXML
    private ChoiceBox<String> categoryChoiceBox;
    
	public void ss() {
		
	}
	
	public void toMain() {
		FXMLLoader loader = new FXMLLoader();
		VBox root;
		try {
			root = loader.load(new FileInputStream(ShoppingListController.getPathToFxml()));
			Scene scene = new Scene(root,500,400);
			getApplicationStage().setScene(scene);
			getApplicationStage().setTitle("my shopping list");
			ShoppingListController shoppingListController = loader.getController(); 
			shoppingListController.setApplicationStage(getApplicationStage());
			shoppingListController.setShoppingList(getShoppingList());
			shoppingListController.fillPage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showForm() {
		if (item.getCategory() == "car") {
			
		} else if (item.getCategory() == "real estate") {
			
		} else {
			
		}
	}
	
	public void editItem(Item item) {
		
	}
	
	public void createItem() {
		
	}
    
	public void fillPage() {
		categoryChoiceBox.setValue(item.getCategory());
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@FXML public void onClickNext(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		VBox root;
		
		item.setCategory(categoryChoiceBox.getValue());
		if (item.getCategory() == "car") {
			
		} else {
			
		}
		
		try {
			//root = loader.load(new FileInputStream(NewItemFormController.getPathToFxml()));
			root = loader.load(new FileInputStream("src/application/NewItemForm.fxml"));
			
			Scene scene = new Scene(root,500,400);
			getApplicationStage().setScene(scene);
			getApplicationStage().setTitle("my shopping list");
			NewItemFormController controller = loader.getController(); 
			
			controller.setItem(item);
			
			controller.setApplicationStage(getApplicationStage());
			controller.setShoppingList(getShoppingList());
			controller.fillPage();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public Stage getApplicationStage() {
		return applicationStage;
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}
	
	
}
