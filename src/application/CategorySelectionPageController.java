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

	// when the back button is clicked, user is taken back to the previous page
	@FXML
	public void onClickBack(ActionEvent event) {
		applicationStage.setTitle(previousTitle);
		applicationStage.setScene(previousScene);
	}

	// when the next button is clicked, a new form is loaded to add an item of
	// various types
	@FXML
	public void onClickNext(ActionEvent event) throws FileNotFoundException, IOException {
		String pathToFxml;

		// checks if "car" is selected as the category from drop down menu
		if (categoryChoiceBox.getValue().trim().compareTo("car") == 0) {
			pathToFxml = NewCarFormController.getPathToFxml();
			// if item is null, then a new Car object needs to be created
			if (item == null)
				item = new Car();
		} else {
			pathToFxml = NewItemFormController.getPathToFxml();

			// if item is null, then a new Item object needs to be created
			if (item == null)
				item = new Item();
		}
		item.setCategory(categoryChoiceBox.getValue().trim());

		// loads the form to edit the selected item or add a new item
		loadPage(item, pathToFxml, applicationStage, shoppingList, "create or edit");
	}

	// sets the previous page that led to the category selection page
	public void setPreviousScene(Scene previousScene) {
		this.previousScene = previousScene;
	}

	// sets the title of the page
	public void setPreviousTitle(String previousTitle) {
		this.previousTitle = previousTitle;
	}

	// selects the category of the item being edited. If a new item is being
	// created, the default category is set to other
	public void fillPage() {
		if (item == null)
			categoryChoiceBox.setValue("other");
		else
			categoryChoiceBox.setValue(item.getCategory());
	}

	// getter function to pathToFxml
	public static String getPathToFxml() {
		return pathToFxml;
	}
}
