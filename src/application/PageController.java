package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PageController {
	protected Item item; 
	protected ShoppingList shoppingList;
	protected Stage applicationStage;
	
	/**
	 * Sets the page to the main page
	 * 
	 * @param applicationStage
	 * @param shoppingList
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void goToMainPage(Stage applicationStage, ShoppingList shoppingList) throws FileNotFoundException, IOException {
		loadPage(null, ShoppingListPageController.getPathToFxml(), applicationStage, shoppingList, "my shopping list");
	}
	
	/**
	 * load the page whose path is specified in the argument
	 * 
	 * @param item
	 * @param filePath
	 * @param applicationStage
	 * @param shoppingList
	 * @param pageTitle
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public PageController loadPage(Item item, String filePath, Stage applicationStage, ShoppingList shoppingList, String pageTitle) throws FileNotFoundException, IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream(filePath));
		Scene scene = new Scene(root,500,400);
		PageController pageController = loader.getController(); 
		pageController.setItem(item);
		pageController.setApplicationStage(applicationStage);
		pageController.setShoppingList(shoppingList);
		pageController.fillPage();
		applicationStage.setScene(scene);
		applicationStage.setTitle(pageTitle);
		return pageController; 

	}
	
	public void fillPage() throws FileNotFoundException, IOException {
		
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public ShoppingList getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}
	public Stage getApplicationStage() {
		return applicationStage;
	}
	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}

}
