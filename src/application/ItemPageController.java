package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ItemPageController {
	private Item item; 
	private Stage applicationStage; 
	
	@FXML Label categoryLabel;
	@FXML Label nameLabel;
	@FXML Label priceLabel;
	@FXML Label detailLabel;
	@FXML public void delete(ActionEvent event) {}
	@FXML public void edit(ActionEvent event) {}
	@FXML public void close(ActionEvent event) {}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

}
