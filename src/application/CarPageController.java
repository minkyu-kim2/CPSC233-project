package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class CarPageController extends ItemPageController{
	private static String pathToFxml = "src/application/CarPage.fxml";

	@FXML private Label modelLabel;
	@FXML private Label makeLabel;
	@FXML private Label yearLabel;
		
	/**
	 * This function fills the CarPage with the data saved in the car object
	 */
	public void fillPage() {
		modelLabel.setText(((Car)getItem()).getModel());
		makeLabel.setText(((Car)getItem()).getMake());
		yearLabel.setText(((Car)getItem()).getYear()+"");
		super.fillPage();
	}

	// getter function for pathToFxml
	public static String getPathToFxml() {
		return pathToFxml;
	}

}
