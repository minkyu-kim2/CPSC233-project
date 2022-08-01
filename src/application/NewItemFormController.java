package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;

public class NewItemFormController extends PageController {
	private static String pathToFxml = "src/application/NewItemForm.fxml";
	
	@FXML Label categoryLabel;
	@FXML TextField nameInput;
	@FXML TextField priceInput;
	@FXML TextArea descriptionInput;
	@FXML TextField quantityInput;
	
	/**
	 * This function deletes item from the Shopping List
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
	 * This function applies the change to the item. 
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML public void save(ActionEvent event) throws FileNotFoundException, IOException {
		checkType();
		updateItemInfo();	
		goToMainPage(applicationStage, shoppingList);
			
	}
	
	/**
	 * This function takes the user back to the ShoppingListPage
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML public void close(ActionEvent event) throws FileNotFoundException, IOException {
		goToMainPage(applicationStage, shoppingList);
	}
	
	/**
	 * In case the edited item is of type Car, this function makes sure the edited object has type Item. 
	 */
	public void checkType() {
		Item newItem;
		int index; 
		
		if (item instanceof Car) {
			newItem = new Item(item);
			index = getShoppingList().getItems().indexOf(getItem());
			System.out.println(getShoppingList().getItems().size());
			shoppingList.getItems().remove(item);
			shoppingList.getItems().add(index, newItem);
			setItem(newItem);
		}
	}

	/**
	 * This function saves the information written in the form to the item object. 
	 */
	public void updateItemInfo() {
		item.setName(nameInput.getText());
		item.setPrice(Double.parseDouble(priceInput.getText()));
		item.setQuantity(Integer.parseInt(quantityInput.getText()));
		item.setDescription(descriptionInput.getText());
		
		if (!shoppingList.getItems().contains(item)) {
			shoppingList.add(item);
		}
	}
	
	/**
	 * This function fills the form with an existing data for editing. 
	 */
	public void fillPage() {
		nameInput.setText(item.getName());
		categoryLabel.setText(item.getCategory());
		priceInput.setText(item.getPrice()+"");
		descriptionInput.setText(item.getDescription());
		quantityInput.setText(item.getQuantity()+"");
		applicationStage.setTitle("Item: " + item.getName() );
		applicationStage.show();
	}
	
	public static String getPathToFxml() {
		return NewItemFormController.pathToFxml;
	}
	
}
