package application;
	
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MinkyuMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,500,500);
			
			ShoppingCartViewer sampleCart = createSampleCart(); 
			sampleCart.setApplicationStage(primaryStage);
			sampleCart.show();
			
			// primaryStage.setScene(scene);
			// primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public ShoppingCartViewer createSampleCart() {
		Item item1 = new Item("Rav4", 50000, "brand new", 1);
		Item item2 = new Item("Iphone 13", 1000, "normal model", 1);
		Item item3 = new Item("Banana", 5, "weighs 2kg", 1);
		ArrayList<Item> itemList = new ArrayList<Item>(Arrays.asList(item1, item2, item3));
		
		return new ShoppingCartViewer(itemList); 
	}
}
