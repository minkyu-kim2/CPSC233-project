package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewCarFormController extends NewItemFormController {
	private static String pathToFxml = "src/application/NewCarForm.fxml";
	
	@FXML TextField modelInput;
	@FXML TextField makeInput;
	@FXML TextField yearInput;

	public void fillPage() {
		Item item; 
		if (getItem() instanceof Car) {
			modelInput.setText(((Car)getItem()).getModel());
			makeInput.setText(((Car)getItem()).getMake());
			yearInput.setText(((Car)getItem()).getYear()+"");
		}
		else {
			getShoppingList().
		}
		
		super.fillPage();
	}

	public static String getPathToFxml() {
		return pathToFxml;
	}
}
