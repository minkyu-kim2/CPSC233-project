package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class RealEstatePageController extends ItemPageController{
	private static String pathToFxml = "src/application/RealEstatePage.fxml";
	@FXML Label classficationLabel;
	@FXML Label addressLabel;


		
	/**
	 * This function fills the RealEstatePage with the data saved in the RealEstate object
	 */
	public void fillPage() {
		classficationLabel.setText(((Car)getItem()).getModel());
		addressLabel.setText(((Car)getItem()).getMake());
		super.fillPage();
	}

	// getter function for pathToFxml
	public static String getPathToFxml() {
		return pathToFxml;
	}

}
