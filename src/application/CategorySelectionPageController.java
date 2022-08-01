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

public class CategorySelectionPageController extends PageController {
    private static String pathToFxml = "src/application/CategorySelectionPage.fxml";
    private Stage applicationStage; 
	private Item item; 
	private ShoppingList shoppingList; 
	private Scene previousScene;
    
	@FXML
    private ChoiceBox<String> categoryChoiceBox;
    
	@FXML public void onClickBack(ActionEvent event) {
		applicationStage.setScene(previousScene);		
	}
	
	public void toMain() {
		FXMLLoader loader = new FXMLLoader();
		VBox root;
		try {
			root = loader.load(new FileInputStream(ShoppingListPageController.getPathToFxml()));
			Scene scene = new Scene(root,500,400);
			getApplicationStage().setScene(scene);
			getApplicationStage().setTitle("my shopping list");
			ShoppingListPageController shoppingListController = loader.getController(); 
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
		if (item == null)
			categoryChoiceBox.setValue("other");
		else
			categoryChoiceBox.setValue(item.getCategory());
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@FXML public void onClickNext(ActionEvent event) {

		
		FXMLLoader loader = new FXMLLoader();
		VBox root;
		
		//item.setCategory(categoryChoiceBox.getValue());
		String pathToFxml;
		if (categoryChoiceBox.getValue().trim().compareTo("car") == 0) {
			pathToFxml = NewCarFormController.getPathToFxml();
			System.out.println("car selected");
			
			if (item == null)
				item = new Car();
		}
		else {
			pathToFxml = NewItemFormController.getPathToFxml();
			System.out.println("car not selected");
			
			if (item == null)
				item = new Item();
		}
		try {
			//root = loader.load(new FileInputStream(NewItemFormController.getPathToFxml()));
			item.setCategory(categoryChoiceBox.getValue().trim());
			
			System.out.println(item.getCategory());
			root = loader.load(new FileInputStream(pathToFxml));
			
			Scene scene = new Scene(root,500,400);
			getApplicationStage().setScene(scene);
			getApplicationStage().setTitle("my shopping list");
			NewItemFormController controller = loader.getController(); 
			
			controller.setItem(item);
			
			controller.setApplicationStage(getApplicationStage());
			controller.setShoppingList(getShoppingList());
			
			System.out.println("at CategorySelectionPageController" + shoppingList.getItems().size());
			
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

	public void setPreviousScene(Scene previousScene) {
		this.previousScene = previousScene;
	}

	
	
	
}
