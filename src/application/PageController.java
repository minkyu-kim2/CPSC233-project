package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	public void goToMainPage(Stage applicationStage, ShoppingList shoppingList)
			throws FileNotFoundException, IOException {
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
	 * @return a PageController object
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public PageController loadPage(Item item, String filePath, Stage applicationStage, ShoppingList shoppingList,
			String pageTitle) throws FileNotFoundException, IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream(filePath));
		Scene scene = new Scene(root, 500, 400);
		PageController pageController = loader.getController();
		pageController.setItem(item);
		pageController.setApplicationStage(applicationStage);
		pageController.setShoppingList(shoppingList);
		pageController.fillPage();
		applicationStage.setScene(scene);
		applicationStage.setTitle(pageTitle);
		return pageController;

	}

	/**
	 * This function is used to write data stored in items field in ShoppingList
	 * object to data.txt in CSV format. This function allows data stored in the
	 * current session to be accessible in next session.
	 * 
	 * source https://www.w3schools.com/java/java_files_create.asp accessed on
	 * August 4 2022
	 * 
	 * @throws IOException
	 */
	public void writeToFile() throws IOException {
		File myObj = new File("src/application/data.txt");
		myObj.createNewFile();
		FileWriter myWriter = new FileWriter("src/application/data.txt");
		String rowData;

		// save items as rows of CSV in the following order:
		// category, name, price, quantity, description
		for (Item item : shoppingList.getItems()) {
			// enclose fields of type string in "" to bypass potential errors with comma
			// when reading the data
			rowData = "\"" + item.getCategory() + "\"" + "," + "\"" + item.getName() + "\"" + "," + item.getPrice()
					+ "," + item.getQuantity() + "," + "\"" + item.getDescription() + "\"";

			// write additional data for Car object:
			// model, maker, year
			if (item.getCategory().compareTo("car") == 0) {
				rowData += "," + "\"" + ((Car) item).getModel() + "\"" + "," + "\"" + ((Car) item).getMake() + "\""
						+ "," + ((Car) item).getYear();
			// write additional data for RealEstate object:
			// classification, address
			} else if (item.getCategory().compareTo("real estate") == 0) {
				rowData += "," + "\"" + ((RealEstate) item).getClassification() + "\"" + "," + "\""
						+ ((RealEstate) item).getAddress() + "\"";
			}

			// append a new line character at the end and write the row to the file
			rowData += "\n";
			myWriter.write(rowData);
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	}

	/**
	 * 
	 * This function is used to load data from data.txt file and the data is
	 * assigned to items field in ShoppingList object. This function allows data
	 * from previous session to be accessible in the current session.
	 * 
	 * source https://www.baeldung.com/java-csv-file-array#scanner accessed on
	 * August 04 2022
	 */
	public void loadFromFile() {

		try {
			ArrayList<Item> items = new ArrayList<Item>();
			Item item;
			Car car;
			RealEstate realEstate; 
			Scanner scanner = new Scanner(new File("src/application/data.txt"));

			while (scanner.hasNextLine()) {
				// parses row written in comma separated sequence as List of String data
				List<String> rowData = getRecordFromLine(scanner.nextLine());
				item = new Item();

				// set the following fields to the item object
				// category, name, price, quantity, description
				item.setCategory(rowData.get(0).replace("\"", ""));
				item.setName(rowData.get(1).replace("\"", ""));
				item.setPrice(Double.parseDouble(rowData.get(2)));
				item.setQuantity(Integer.parseInt(rowData.get(3)));
				item.setDescription(rowData.get(4).replace("\"", ""));

				// if the category is car, set additional information:
				// model, maker, year
				if (item.getCategory().toLowerCase().compareTo("car") == 0) {
					// create a new Car object that retains all the information in item variable
					car = new Car(item);
					car.setModel(rowData.get(5).replace("\"", ""));
					car.setMake(rowData.get(6).replace("\"", ""));
					car.setYear(Integer.parseInt(rowData.get(7)));
					items.add(car);
				} else if (item.getCategory().toLowerCase().compareTo("real estate") == 0) {
					// create a new Car object that retains all the information in item variable
					realEstate = new RealEstate(item);
					realEstate.setClassification(rowData.get(5).replace("\"", ""));
					realEstate.setAddress(rowData.get(6).replace("\"", ""));
					items.add(realEstate);
				}
				
				else {
					// if the category is not of type Car, just add the item as is
					items.add(item);
				}
			}

			// create a ShoppingList object with data imported from data.txt file and set it
			// in the shoppingList instance field
			this.shoppingList = new ShoppingList(items);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			// if data.txt file is not found, then create a ShoppingList object with no item
			// stored.
			this.shoppingList = new ShoppingList();

		}
	}

	/**
	 * This is a helper function for loadFromFile parses a line of data separated by
	 * a comma and returns them as a list of String
	 * 
	 * source: https://www.baeldung.com/java-csv-file-array#scanner accessed on
	 * August 04 2022
	 * 
	 * @param line
	 * @return parsed comma separated string as List of String object
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

	// fills the page when data to be displayed is available
	public void fillPage() throws FileNotFoundException, IOException {

	}

	// methods below are setters and getters
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
