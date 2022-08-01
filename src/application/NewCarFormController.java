package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewCarFormController extends NewItemFormController {
	private static String pathToFxml = "src/application/NewCarForm.fxml";
	
	@FXML TextField modelInput;
	@FXML TextField makeInput;
	@FXML TextField yearInput;

	public void fillPage() {

		if (getItem() instanceof Car) {
			modelInput.setText(((Car)item).getModel());
			makeInput.setText(((Car)item).getMake());
			yearInput.setText(((Car)item).getYear()+"");
		}
		super.fillPage();
	}
	

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
