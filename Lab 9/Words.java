/*
* A class to represent a 2D array of words
* This array can then be scanned for each lexicographical
* word in inner arrays
*/
public class Words {
    private String[][] wordArray;
    
    /*
    * Constructor method to initalise the object with
    * a 2D array
    * @param wordArray Takes a 2d array of String
    */
    public Words(String[][] wordArray) {
        this.wordArray = wordArray;
    }
    
    /*
    * Method to convert 2D array into a String
    * Each line contains a series of word in an
    * inner array
    * @return String of contents inside of each inner array
    */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String[] row : wordArray) {
            for (String words: row) {
                result.append(words + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
    
    /*
    * Method to find the first lexicongraphical word
    * inside each of the inner array
    * @return String array of each top word from the inner arrays
    */
    public String[] getAlphaWords() {
        String[] result = new String[10];
        
        for (int x = 0; x < wordArray.length; x++) {
            String lexiWord = wordArray[x][0];
            
            for (String word : wordArray[x]) {
                if (word.compareToIgnoreCase(lexiWord) < 0) {
                    lexiWord = word;
                }
            }
            result[x] = lexiWord;
        }
        return result;
    }
}