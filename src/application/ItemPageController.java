package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ItemPageController {
	private static String pathToFxml = "src/application/ItemPage.fxml";
	private Item item; 
	private Stage applicationStage; 
	
	@FXML Label categoryLabel;
	@FXML Label nameLabel;
	@FXML Label priceLabel;
	@FXML Label detailLabel;
	@FXML Label quantityLabel;
	@FXML public void delete(ActionEvent event) {}
	@FXML public void edit(ActionEvent event) {}
	@FXML public void close(ActionEvent event) {}


	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Stage getApplicationStage() {
		return applicationStage;
	}
	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
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
