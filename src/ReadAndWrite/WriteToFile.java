package ReadAndWrite;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

//https://www.w3schools.com/java/java_files_create.asp
public class WriteToFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("src/ReadAndWrite/sampleFile.txt");
      myObj.createNewFile();
      FileWriter myWriter = new FileWriter("src/ReadAndWrite/sampleFile.txt");
      
      String message = "car";
      message += ","+"a brand new model, white";
      
      
      myWriter.write(message);
      myWriter.write(message);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}