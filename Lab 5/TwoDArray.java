public class TwoDArray {
   public static void main(String[] args) {
      String[][] words = {
         {"Apple", "Aardvark", "Albatross"},
         {"Bear", "Baby", "Box"},
         {"Candy", "Cave", "Cube"},
         {"Dog", "Desk"}
      };
      
      System.out.println("\n***Testing printing each elemenet in 2D array***\n");
      for (String[] row : words) {
         for (String word : row) {
            System.out.print(word + " ");
         }
         System.out.println();
      }
      
      System.out.println("\n***Testing findChar method with different chars and edge cases***\n");
      findChar('B', words);
      findChar('a', words);
      findChar('A', words);
      findChar('V', words);
      
      System.out.println("\n***Testing findLongestWord method***\n");
      findLongestWord(words);
   }
   
   /*
   * Method to find each word containing a given character and 
   * print each word out
   * @param c Character to match with words in the array
   * @param words Reference to 2D array containg various words
   */
   public static void findChar(char c, String[][] words) {
      String letter = String.valueOf(c).toLowerCase();
      
      System.out.printf("Finding letter %s: ", letter);
      for (String[] row : words) {
         for (String word : row) {
            if (word.toLowerCase().contains(letter)) {
               System.out.print(word + " ");
            }
         }
      }
      System.out.println();
   }
   
   /*
   * Method to find the longest word in each row of the array
   * and print each rows longest word
   * @param words Refernce to 2D array containing various words
   */
   public static void findLongestWord(String[][] words) {
      for (String[] row : words) {
         String longestWord = "";
         for (String word : row) {
            if (word.length() > longestWord.length()) {
               longestWord = word;
            }
         }
         System.out.println(longestWord);
      }
   }
}