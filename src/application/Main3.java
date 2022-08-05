package application;
	
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			
			PageController pageController = new PageController();
			pageController.loadFromFile();
			
			for (Item item: pageController.getShoppingList().getItems()) {
				System.out.println(item.getCategory());
				System.out.println(item.getName());
				System.out.println(item.getPrice()+"");
				System.out.println(item.getQuantity()+"");
				System.out.println(item.getDescription());
				
				if (item.getCategory().compareTo("car") == 0) {
					System.out.println(((Car)item).getModel());
					System.out.println(((Car)item).getMake());
					System.out.println(((Car)item).getYear()+"");
				}
				System.out.println("");
				
			
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * This function creates a sample shopping list for demo
	 * 
	 * @return
	 */
	public ShoppingList createSampleList() {
		Item item1 = new Car("Rav4", 50000, "brand new", 1, "Rav4", "Toyota", 2022);
		Item item2 = new Item("Iphone 13", 1000, "normal model", 1, "electronic");
		Item item3 = new Item("Banana", 5, "weighs 2kg", 1, "grocery");
		ArrayList<Item> itemList = new ArrayList<Item>(Arrays.asList(item1, item2, item3));
		ShoppingList sample = new ShoppingList(itemList);

		
		return sample; 
	}
}
