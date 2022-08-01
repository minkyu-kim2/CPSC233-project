package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CategorySelectionPageController extends PageController {
    private static String pathToFxml = "src/application/CategorySelectionPage.fxml";
	private Scene previousScene;
	private String previousTitle; 
    
	@FXML
    private ChoiceBox<String> categoryChoiceBox;
    
	@FXML public void onClickBack(ActionEvent event) {
		applicationStage.setTitle(previousTitle);
		applicationStage.setScene(previousScene);		
	}

	public void fillPage() {
		if (item == null)
			categoryChoiceBox.setValue("other");
		else
			categoryChoiceBox.setValue(item.getCategory());
	}

	@FXML public void onClickNext(ActionEvent event) throws FileNotFoundException, IOException {
		String pathToFxml;
		if (categoryChoiceBox.getValue().trim().compareTo("car") == 0) {
			pathToFxml = NewCarFormController.getPathToFxml();
			System.out.println("car selected");
			
			if (item == null)
				item = new Car();
		}
		else {
			pathToFxml = NewItemFormController.getPathToFxml();
			System.out.println("car not selected");
			
			if (item == null)
				item = new Item();
		}
		item.setCategory(categoryChoiceBox.getValue().trim());
		loadPage(item, pathToFxml, applicationStage, shoppingList, "create or edit");
	}

	public static String getPathToFxml() {
		return pathToFxml;
	}


	public void setPreviousScene(Scene previousScene) {
		this.previousScene = previousScene;
	}


	public void setPreviousTitle(String previousTitle) {
		this.previousTitle = previousTitle;
	}
}
