import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ArrayWeavingApp {
   public static void main(String[] args) {
      String[] stringOneSplit = getFileContents("sample1.txt").split(" ", -2);
      String[] stringTwoSplit = getFileContents("sample2.txt").split(" ", -2);
      WovenStringArray test = new WovenStringArray(stringOneSplit, stringTwoSplit);
      System.out.println(Arrays.toString(test.getWovenArray()));
   }
   
   
   /*
   * Method to retrive words from file and return them as a string
   * @param path Path of file
   * @return String consisting of words retrived from the file
   */
   public static String getFileContents(String path) {
      String fileContent = "";
      
      try {
         Scanner s = new Scanner(new File(path));
         while (s.hasNextLine()) {
            fileContent = s.nextLine();
         }
      } catch (IOException e) {
         System.out.println("File not found!");
      }
      
      return fileContent;
   }
}