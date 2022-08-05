package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import ReadAndWrite.MyCustomObject;
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
	
	private void writeToFile() throws IOException {
		File myObj = new File("src/application/data.txt");
		myObj.createNewFile();
		FileWriter myWriter = new FileWriter("src/application/data.txt");
		String rowData; 
		
		// save items as rows of CSV in the following order:
		// category, name, price, quantity, description
		for (Item item : shoppingList.getItems()) {
			//enclose fields of type string in "" to bypass potential errors with comma when reading the data
			rowData = "\"" + item.getCategory() + "\""+ "," 
			+ "\"" + item.getName() + "\""+ "," 
			+ item.getPrice() + "," 
			+ item.getQuantity() + "," 
			+ "\""+ item.getDescription() + "\""; 
	
			// write additional data for Car object:
			// model, maker, year
			if (item.getCategory() == "car") {
				rowData += "," + "\""+ ((Car)item).getModel()  + "\"" + "," 
				+ "\""+ ((Car)item).getMake()  + "\""+ "," 
				+ ((Car)item).getYear();	
			} 
			
			// append a new line character at the end and write the row to the file 
			rowData += "\n";
			myWriter.write(rowData);
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file."); 
	}
	
	
	private void loadFromFile2() throws FileNotFoundException {
	   Item item; 
	   String category; 
	   String name; 
	   String price;
	   String quantity; 
	   String description; 
	   String model; 
	   String make; 
	   String year; 
		
		Scanner scanner = new Scanner(new File("src/application/data.txt")); 
	    while (scanner.hasNextLine()) {
	    	
	    	item = new Item();
	    	
	        String rowData = scanner.nextLine();
	        Scanner rowScanner = new Scanner(rowData);
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	        	
	            category = rowScanner.next();
	            
	        }
	        
	    }
		
	}
	
	
	// source
	// https://www.baeldung.com/java-csv-file-array#scanner
	// accessed on August 04 2022
	private void loadFromFile() throws FileNotFoundException {
		   ArrayList<Item> items = new ArrayList<Item>();
		   // category, name, price, quantity, description
		   Item item; 
		   String category; 
		   String name; 
		   double price;
		   int quantity; 
		   String description; 
		   String model; 
		   String make; 
		   String year; 

		   Scanner scanner = new Scanner(new File("src/application/data.txt")); 
		       while (scanner.hasNextLine()) {
		    	   List<String> rowData = getRecordFromLine(scanner.nextLine());
		    	   item = new Item();
		    	   
		    	   item.setCategory(rowData.get(0).replace("\"",""));     	  
		    	   item.setName(rowData.get(1).replace("\"",""));
		    	   item.setPrice(Double.parseDouble(rowData.get(2)));
		    	   item.setQuantity(Integer.parseInt(rowData.get(3)));
		    	   item.setDescription(rowData.get(4).replace("\"",""));
		    	   
		    	   // if the category is object, set additional information
		    	   // model, maker, year
		    	   if (item.getCategory().toLowerCase() == "car") {
		    		   ((Car)item).setModel(rowData.get(5));
		    		   ((Car)item).setMake(rowData.get(6));
		    		   ((Car)item).setYear(Integer.parseInt(rowData.get(7)));
		    	   }
		    	   items.add(item);
		       }
		   
		   
		   return records;
		}

	/**
	 * parses a line of data separated by a comma and returns them as a list of String
	 * 
	 * source:
	 * https://www.baeldung.com/java-csv-file-array#scanner
	 * accessed on August 04 2022
	 * 
	 * @param line
	 * @return
	 */
	private List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<String>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    return values;
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
