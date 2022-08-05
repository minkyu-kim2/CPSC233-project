package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewCarFormController extends NewItemFormController {
	private static String pathToFxml = "src/application/NewCarForm.fxml";

	@FXML
	private TextField modelInput;
	@FXML
	private TextField makeInput;
	@FXML
	private TextField yearInput;

	/**
	 * In case the edited item is originally of type Item, this function converts
	 * the object type to Car.
	 */
	public void checkType() {
		Car car;
		int index;

		if (getItem() instanceof Car == false) {
			index = getShoppingList().getItems().indexOf(getItem());
			// creates a new Car object based on the existing data
			car = new Car(getItem());

			// removes the original item from the ShoppingList.items
			getShoppingList().getItems().remove(getItem());
			// adds the new Car object to the ShoppingList.items
			getShoppingList().getItems().add(index, car);
			setItem(car);
		}
	}

	/**
	 * This function saves the information provided by the user to items field in
	 * the ShoppingList object.
	 */
	public void updateItemInfo() {
		((Car) item).setModel(modelInput.getText());
		((Car) item).setMake(makeInput.getText());
		((Car) item).setYear(Integer.parseInt(yearInput.getText()));
		super.updateItemInfo();
	}

	/**
	 * This function fills the form with an existing data for editing.
	 */
	public void fillPage() {

		if (getItem() instanceof Car) {
			modelInput.setText(((Car) item).getModel());
			makeInput.setText(((Car) item).getMake());
			yearInput.setText(((Car) item).getYear() + "");
		}
		super.fillPage();
	}

	// getter function for pathToFxml
	public static String getPathToFxml() {
		return pathToFxml;
	}

	/**
	 * on top of functionality from the validateInput method from the parent class,
	 * it also validates for correct input to the year and
	 * 
	 * @return empty string if there is no error. otherwise returns a detailed error
	 *         message that is visible to the user
	 */

	public String validateInput() {
		String errorMessage = super.validateInput();
		String year = yearInput.getText();

		// year field should not be left empty
		if (year.trim().length() == 0) {
			errorMessage += "please enter year\n";
		} else {
			// checks that the year is provided as an integer number.
			for (char c : year.trim().toCharArray())
				if (Character.isDigit(c) == false) {
					errorMessage += "please only enter positive integer for year\n";
					break;
				}
		}

		return errorMessage;

	}
}
