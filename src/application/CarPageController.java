package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;

public class CarPageController extends ItemPageController{
	private static String pathToFxml = "src/application/CarPage.fxml";

	@FXML Label modelLabel;
	@FXML Label makeLabel;
	@FXML Label yearLabel;
		
	public void fillPage() {
		modelLabel.setText(((Car)getItem()).getModel());
		makeLabel.setText(((Car)getItem()).getMake());
		yearLabel.setText(((Car)getItem()).getYear()+"");
		super.fillPage();
	}

	public static String getPathToFxml() {
		return pathToFxml;
	}

}
