import java.util.*;
import java.io.*;
import java.nio.file.*;

public class WordsApp {
    public static void main(String[] args) {
        String[][] wordArray = new String[10][];
        
        try {
            Scanner s = new Scanner(new File("goodScrabbleWords.txt"));
            
            for (int x = 0; x < 10; x++) {
                wordArray[x] = s.nextLine().split(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        
        Words wordsClass = new Words(wordArray);
        System.out.println(wordsClass.toString());
        System.out.println(Arrays.toString(wordsClass.getAlphaWords()));
        System.out.println(wordsClass.toString());
    }
}