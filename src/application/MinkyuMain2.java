package application;
	
import java.io.FileInputStream;
import java.util.ArrayList;

import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

//import controllers.ShoppingListController;

public class MinkyuMain2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,500,500);
			
			
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream(ShoppingListController.getPathToFxml()));
			
			Scene scene = new Scene(root,500,400);
			primaryStage.setScene(scene);
			ShoppingListController shoppingListController = loader.getController(); 
			shoppingListController.setApplicationStage(primaryStage);
			
			ArrayList<Item> sampleCart = createSampleList(); 
			shoppingListController.setItems(sampleCart);
			shoppingListController.appendItems();
			shoppingListController.showPage();
			
			
			// primaryStage.setScene(scene);
			// primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public ArrayList<Item> createSampleList() {
		Item item1 = new Item("Rav4", 50000, "brand new", 1);
		Item item2 = new Item("Iphone 13", 1000, "normal model", 1);
		Item item3 = new Item("Banana", 5, "weighs 2kg", 1);
		ArrayList<Item> itemList = new ArrayList<Item>(Arrays.asList(item1, item2, item3));
		
		return itemList; 
	}
}
