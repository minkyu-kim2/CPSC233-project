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
			modelInput.setText(((Car)getItem()).getModel());
			makeInput.setText(((Car)getItem()).getMake());
			yearInput.setText(((Car)getItem()).getYear()+"");
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
		((Car)getItem()).setModel(modelInput.getText());
		((Car)getItem()).setMake(makeInput.getText());
		((Car)getItem()).setYear(Integer.parseInt(yearInput.getText()));
		System.out.println("updateCarInfo: "+modelInput.getText()+makeInput.getText()+Integer.parseInt(yearInput.getText()));
		super.updateItemInfo();
	}

	public static String getPathToFxml() {
		return pathToFxml;
	}
}
