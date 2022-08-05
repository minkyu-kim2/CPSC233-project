package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
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

	@FXML public void onClickNext(ActionEvent event) throws FileNotFoundException, IOException {
		String pathToFxml;
		if (categoryChoiceBox.getValue().trim().compareTo("car") == 0) {
			pathToFxml = NewCarFormController.getPathToFxml();
			
			if (item == null)
				item = new Car();
		}
		else {
			pathToFxml = NewItemFormController.getPathToFxml();
			
			if (item == null)
				item = new Item();
		}
		item.setCategory(categoryChoiceBox.getValue().trim());
		loadPage(item, pathToFxml, applicationStage, shoppingList, "create or edit");
	}

	public void setPreviousScene(Scene previousScene) {
		this.previousScene = previousScene;
	}


	public void setPreviousTitle(String previousTitle) {
		this.previousTitle = previousTitle;
	}

	public void fillPage() {
		if (item == null)
			categoryChoiceBox.setValue("other");
		else
			categoryChoiceBox.setValue(item.getCategory());
	}

	public static String getPathToFxml() {
		return pathToFxml;
	}
}
