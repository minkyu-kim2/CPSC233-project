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
import javafx.scene.layout.GridPane;

public class ShoppingListPageController extends PageController{
	private static String pathToFxml = "src/application/ShoppingListPage.fxml";
	
    @FXML
    private Button newItemButton; 
	
    @FXML
    private VBox itemStack;

	@FXML 
	private GridPane grid;

	@FXML Label totalPriceLabel; 
    
    
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
	 * fills items in the shopping list to the grid row by row	
	 */
	public void fillGrid() {
		
		//source 
		//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		//accessed on August 4 2022
		Label nameLabel = new Label("name");
		Label categoryLabel = new Label("cateogry");
		Label priceLabel = new Label("price ($)");
		Label quantityLabel = new Label("quantity");
		GridPane.setConstraints(priceLabel, 2, 0);	
		GridPane.setConstraints(categoryLabel, 1, 0);
		GridPane.setConstraints(nameLabel, 0, 0);
		GridPane.setConstraints(quantityLabel, 3, 0);

		grid.getChildren().addAll(nameLabel, categoryLabel, priceLabel, quantityLabel);
		
		int row = 1;
		
		// fills items in the shopping list to the grid row by row	
		for (Item item : shoppingList.getItems()) {
			nameLabel =  new Label(item.getName());
			categoryLabel = new Label(item.getCategory());
			priceLabel = new Label(String.format("%.2f", item.getPrice()));
			quantityLabel = new Label(String.format("%d", item.getQuantity()));
			Button detailButton = new Button("detail");  
			
			GridPane.setConstraints(nameLabel, 0, row);
			GridPane.setConstraints(categoryLabel, 1, row);
			GridPane.setConstraints(priceLabel, 2, row);	
			GridPane.setConstraints(quantityLabel, 3, row);
			GridPane.setConstraints(detailButton, 4, row);
			
			grid.getChildren().addAll(nameLabel, categoryLabel, priceLabel, quantityLabel, detailButton);
        	
        	// source
			// https://www.baeldung.com/javafx-button-eventhandler#reusing-event-handlers
			// accessed on August 1 2022
        	detailButton.setOnAction(e -> {
        		try {
					showItemPage(item);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	});
        	
        	row++;
    	}
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
		fillGrid();
		applicationStage.setTitle("my shopping list");
		applicationStage.show();		
	}

	//methods below are setters and getters 
	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public static String getPathToFxml() {
		return ShoppingListPageController.pathToFxml;
	}
}
