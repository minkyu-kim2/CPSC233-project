package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShoppingListPageController extends PageController{
	private static String pathToFxml = "src/application/ShoppingListPage.fxml";
	
    @FXML
    private Label projectGradeTextfield;
    
    @FXML
    private Button newItemButton; 
	
    @FXML
    private VBox itemStack; 
    
	/**
	 * This function is fired when the new item button is clicked from the ShoppingListPage.
	 * On clicking the button, the user is taken to the item category selection page
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void addNewItem(ActionEvent event) throws FileNotFoundException, IOException {
		Scene currentScene = applicationStage.getScene();
		String currentTitle = applicationStage.getTitle();
		CategorySelectionPageController controller = (CategorySelectionPageController) loadPage(null, CategorySelectionPageController.getPathToFxml(), applicationStage, shoppingList, "create a new item");
		controller.setPreviousScene(currentScene);
		controller.setPreviousTitle(currentTitle);
	}
	
	
	/**
	 * This function generates a row of HBox for each item in the shopping list to the ShoppingListPage.fxml file
	 */
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
	
	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}
	
	/**
	 * This function is added as an event listener for every item and gets fired when the detail button is clicked. 
	 * On clicking the button, the user is taken to the detail page for the item selected. 
	 * 
	 * @param item
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void showItemPage(Item item) throws FileNotFoundException, IOException {
		String pathToFxml;
		if (item instanceof Car) 
			pathToFxml = CarPageController.getPathToFxml();
		else
			pathToFxml = ItemPageController.getPathToFxml();
		
		super.loadPage(item, pathToFxml, applicationStage, shoppingList, "Item: " + item.getName());
	}


	/**
	 * This function fills the ShoppingListPage with the saved data as a ShoppingList object
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void fillPage() throws FileNotFoundException, IOException {
		this.appendItems();
		applicationStage.setTitle("my shopping list");
		applicationStage.show();
		
	}


	public static String getPathToFxml() {
		return ShoppingListPageController.pathToFxml;
	}
}
