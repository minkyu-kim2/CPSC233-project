package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;

public class ItemPageController extends PageController {
	private static String pathToFxml = "src/application/ItemPage.fxml";

	@FXML protected Label categoryLabel;
	@FXML protected Label nameLabel;
	@FXML protected Label priceLabel;
	@FXML protected Label detailLabel;
	@FXML protected Label quantityLabel;
	
	
	/**
	 * on clicking the delete button, the item is removed from the shopping list and the user is taken back to the ShoppingListPage.
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML public void delete(ActionEvent event) throws FileNotFoundException, IOException{
		shoppingList.getItems().remove(item);
		close(event);
	}
	
	
	/**
	 * This function is fired when the edit button is clicked. On clicking the function, the user is taken to the category selection page. 
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML public void edit(ActionEvent event) throws FileNotFoundException, IOException {
		Scene currentScene = applicationStage.getScene();
		String currentTitle = applicationStage.getTitle();
		CategorySelectionPageController controller = (CategorySelectionPageController) loadPage(item, CategorySelectionPageController.getPathToFxml(), applicationStage, shoppingList, "create a new item");
		controller.setPreviousScene(currentScene);
		controller.setPreviousTitle(currentTitle);
	}
	
	
	/**
	 * This function takes the user back to the ShoppingListPage
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML public void close(ActionEvent event) throws FileNotFoundException, IOException{
		goToMainPage(applicationStage, shoppingList);
	}

	/**
	 * This function fills the ItemPage with the data saved in the item object
	 */
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


}
