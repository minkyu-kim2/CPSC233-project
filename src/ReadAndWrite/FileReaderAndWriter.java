package ReadAndWrite;
/* I know, a java example with the imports listed out !   shocking !! */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public abstract class FileReaderAndWriter {
	
	private void writeToFile() throws IOException {
	      File myObj = new File("src/ReadAndWrite/sampleFile.txt");
	      myObj.createNewFile();
	      FileWriter myWriter = new FileWriter("src/ReadAndWrite/sampleFile.txt");
	      
	      String message = "car";
	      message += ","+"a brand new model, white";
	      
	      
	      myWriter.write(message);
	      myWriter.write(message);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	}
	
	
	// source
	// https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
	// written by granadaCoder
	// accessed on August 2022
	private void loadFromFile() {

		   Collection<MyCustomObject> items = new ArrayList<MyCustomObject>();
		   int lineNumber = 0;
		   String nextValue  = "";
		   try {

		       ClassLoader classLoader = getClass().getClassLoader();
		       File file = new File(classLoader.getResource("MyFile.txt").getFile());
		       Scanner input = new Scanner(file)
		               .useDelimiter(",|\\R")
		               .useLocale(Locale.ENGLISH);
		       ;

		       /* skip the header */
		       input.nextLine();

		       while (input.hasNext()) {
		           lineNumber++;
		           nextValue = input.next().replace("\"", "");
		           String zipCodeValue =nextValue;

		           nextValue = input.next().replace("\"", "");
		           String city = nextValue;

		           nextValue = input.next().replace("\"", "");
		           String usaState = nextValue;

		           nextValue = input.next().replace("\"", "");
		           double latitude = Double.valueOf(nextValue);

		           nextValue = input.next().replace("\"", "");
		           double longitude = Double.valueOf(nextValue);

		           nextValue = input.next().replace("\"", "");
		           int population = Integer.valueOf(nextValue);

		           items.add(new MyCustomObject(zipCodeValue, city, usaState, latitude, longitude, population));
		       }
		   } catch (Exception ex) {
		       throw new RuntimeException(String.format("Line number '%s, nextValue '%s''", lineNumber, nextValue), ex);
		   }


		}
}
