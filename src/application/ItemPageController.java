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

public class ItemPageController extends PageController {
	private static String pathToFxml = "src/application/ItemPage.fxml";

	@FXML protected Label categoryLabel;
	@FXML protected Label nameLabel;
	@FXML protected Label priceLabel;
	@FXML protected Label detailLabel;
	@FXML protected Label quantityLabel;
	@FXML public void delete(ActionEvent event) throws FileNotFoundException, IOException{
		shoppingList.getItems().remove(item);
		close(event);
	}
	
	@FXML public void edit(ActionEvent event) throws FileNotFoundException, IOException {
		loadPage(item, CategorySelectionPageController.getPathToFxml(), applicationStage, shoppingList, "select a category");
	}
	
	
	@FXML public void close(ActionEvent event) throws FileNotFoundException, IOException{
		goToMainPage(applicationStage, shoppingList);
	}

	
	public void fillPage() {
		nameLabel.setText(item.getName());
		categoryLabel.setText(item.getCategory());
		priceLabel.setText(item.getPrice()+"");
		detailLabel.setText(item.getDescription());
		quantityLabel.setText(item.getQuantity()+"");
		applicationStage.setTitle("Item: " + item.getName() );
		applicationStage.show();
		
	}
	public static String getPathToFxml() {
		return pathToFxml;
	}


}
