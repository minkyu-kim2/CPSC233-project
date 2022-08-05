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

	@FXML
	protected Label categoryLabel;
	@FXML
	protected TextField nameInput;
	@FXML
	protected TextField priceInput;
	@FXML
	protected TextArea descriptionInput;
	@FXML
	protected TextField quantityInput;
	@FXML
	protected Label errorLabel;

	/**
	 * This function applies changes to the data.txt and takes the user back to the
	 * shopping list page.
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML
	public void save(ActionEvent event) throws FileNotFoundException, IOException {
		// checks if user provided data are all valid
		String errorMessage = validateInput();

		if (errorMessage.trim().length() == 0) {
			checkType();
			updateItemInfo();
			goToMainPage(applicationStage, shoppingList);

		} else {
			// if the errorMessage is not an empty string, do not make change to the
			// data.txt and inform the user to enter valid input
			errorLabel.setText(errorMessage);
		}
	}

	/**
	 * This function takes the user back to the ShoppingListPage without applying
	 * any change to data.txt file
	 * 
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@FXML
	public void close(ActionEvent event) throws FileNotFoundException, IOException {
		goToMainPage(applicationStage, shoppingList);
	}

	/**
	 * In case the edited item is not originally of type Item, this function
	 * converts the object type to Item.
	 * 
	 */
	public void checkType() {
		Item newItem;
		int index;

		if (item instanceof Car || item instanceof RealEstate) {
			newItem = new Item(item);
			index = getShoppingList().getItems().indexOf(getItem());
			shoppingList.getItems().remove(item);
			shoppingList.getItems().add(index, newItem);
			setItem(newItem);
		}
	}

	/**
	 * This function saves the user provided data to data.txt and ShoppingList.items
	 */
	public void updateItemInfo() {
		item.setName(nameInput.getText());
		item.setPrice(Double.parseDouble(priceInput.getText()));
		item.setQuantity(Integer.parseInt(quantityInput.getText()));
		item.setDescription(descriptionInput.getText());

		if (!shoppingList.getItems().contains(item)) {
			shoppingList.add(item);
		}
		try {
			writeToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function fills the form with an existing data for editing.
	 */
	public void fillPage() {
		nameInput.setText(item.getName());
		categoryLabel.setText(item.getCategory());
		priceInput.setText(item.getPrice() + "");
		descriptionInput.setText(item.getDescription());
		quantityInput.setText(item.getQuantity() + "");
		applicationStage.setTitle("Item: " + item.getName());
		applicationStage.show();
	}

	public static String getPathToFxml() {
		return NewItemFormController.pathToFxml;
	}

	/**
	 * 
	 * @return an empty string if user provided data are valid. Otherwise returns
	 *         message indicating what needs to be changed
	 */
	public String validateInput() {
		String name = nameInput.getText();
		String quantity = quantityInput.getText();
		String price = priceInput.getText();
		String errorMessage = "";
		int decimalCount = 0;

		// checks the name field is not empty
		if (name.trim().length() == 0) {
			errorMessage += "please enter name\n";
		}

		// checks the quantity field is not empty
		if (quantity.trim().length() == 0) {
			errorMessage += "please enter quantity\n";
		} else {
			// checks positive integer value is entered for the quantity field
			for (char c : quantity.trim().toCharArray())
				if (Character.isDigit(c) == false) {
					errorMessage += "please only enter positive integer for quantity\n";
					break;
				}
		}

		// checks the price field is not empty
		if (price.trim().length() == 0) {
			errorMessage += "please enter price\n";
		} else {
			// checks positive real number is entered for the price field
			for (char c : price.trim().toCharArray())
				if (Character.isDigit(c) == false) {
					if (c == '.' && decimalCount < 1) {
						decimalCount++;
					} else {
						errorMessage += "please only enter positive value for price\n";
						break;
					}
				}
		}
		return errorMessage;
	}

}
