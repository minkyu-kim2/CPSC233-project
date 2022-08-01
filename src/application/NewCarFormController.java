package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewCarFormController extends NewItemFormController {
	private static String pathToFxml = "src/application/NewCarForm.fxml";
	
	@FXML TextField modelInput;
	@FXML TextField makeInput;
	@FXML TextField yearInput;

	/**
	 * This function fills the form with an existing data for editing. 
	 */
	public void fillPage() {

		if (getItem() instanceof Car) {
			modelInput.setText(((Car)item).getModel());
			makeInput.setText(((Car)item).getMake());
			yearInput.setText(((Car)item).getYear()+"");
		}
		super.fillPage();
	}
	
	/**
	 * In case the edited item is of type item, this function makes sure the edited object has type Car. 
	 */
	public void checkType() {
		Car car; 
		int index; 
		
		if (getItem() instanceof Car == false) {
			index = getShoppingList().getItems().indexOf(getItem());
			car = new Car(getItem());
			
			getShoppingList().getItems().remove(getItem());
			getShoppingList().getItems().add(index, car);
			setItem(car);
		}
	}
	
	/**
	 * This function saves the information written in the form to the item object. 
	 */
	public void updateItemInfo() {
		((Car)item).setModel(modelInput.getText());
		((Car)item).setMake(makeInput.getText());
		((Car)item).setYear(Integer.parseInt(yearInput.getText()));
		super.updateItemInfo();
	}

	public static String getPathToFxml() {
		return pathToFxml;
	}
}
