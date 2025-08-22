import java.io.*; 
import java.nio.file.*;

   /** Attempts to open a specified file, read what is in it,  and return the contents a single string 
	* Returns an empty string if the file is not found.
	* @param fileName The name of the file to be read.
	* @return The contents of the file as a single string.
	*/
   public static String getFileContents(String fileName){
      String fileContents = "";
      try {
         fileContents = Files.readString(Path.of(fileName));
      } catch (IOException e) {
         System.out.println("File not found.");
      }
      return fileContents;
   }