public class Words {
    private String[][] wordArray;
    
    public Words(String[][] wordArray) {
        this.wordArray = wordArray;
    }
    
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