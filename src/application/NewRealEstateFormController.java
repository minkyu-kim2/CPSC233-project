package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewRealEstateFormController extends NewItemFormController {
	private static String pathToFxml = "src/application/NewRealEstateForm.fxml";

	@FXML
	private TextField classificationInput;

	@FXML
	private TextField addressInput;

	/**
	 * In case the edited item is originally of type Item, this function converts
	 * the object type to RealEstate.
	 */
	public void checkType() {
		RealEstate realEstate;
		int index;

		if (getItem() instanceof RealEstate == false) {
			index = getShoppingList().getItems().indexOf(getItem());
			// creates a new RealEstate object based on the existing data
			realEstate = new RealEstate(getItem());

			// removes the original item from the ShoppingList.items
			getShoppingList().getItems().remove(getItem());
			// adds the new Real Estate object to the ShoppingList.items
			getShoppingList().getItems().add(index, realEstate);
			setItem(realEstate);
		}
	}

	/**
	 * This function saves the information provided by the user to items field in
	 * the ShoppingList object.
	 */
	public void updateItemInfo() {
		((RealEstate) item).setClassification(classificationInput.getText());
		((RealEstate) item).setAddress(addressInput.getText());
		super.updateItemInfo();
	}

	/**
	 * This function fills the form with an existing data for editing.
	 */
	public void fillPage() {

		if (getItem() instanceof RealEstate) {
			classificationInput.setText(((RealEstate) item).getClassification());
			addressInput.setText(((RealEstate) item).getAddress());
		}
		super.fillPage();
	}

	// getter function for pathToFxml
	public static String getPathToFxml() {
		return pathToFxml;
	}

}
