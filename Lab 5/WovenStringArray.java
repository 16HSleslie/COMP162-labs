/*
* Class that weaves two string arrays by alternating elements
*/
public class WovenStringArray {
   private String[] wovenArray;
   
   /*
   * Constructor that creates a WovenStringArray object by weaving two arrays together
   * Alternates taking elements from each array until both arrays are fully processed
   * @param a1 First string array to be woven
   * @param a2 Second string array to be woven
   */
   public WovenStringArray(String[] a1, String[] a2) {
      wovenArray = new String[a1.length + a2.length];
      int i1 = 0, i2 = 0, index = 0;
      
      while (i1 < a1.length || i2 < a2.length) {
         if (i1 < a1.length) {
            wovenArray[index++] = a1[i1++];
         }
         if (i2 < a2.length) {
            wovenArray[index++] = a2[i2++];
         }
      } 
   }
   
   /*
   * Accessor method that gets the woven string array
   * @return String array consisting of alternating elements from input arrays
   */
   public String[] getWovenArray() {
      return wovenArray;
   }
}