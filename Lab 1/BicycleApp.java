public class BicycleApp {
   public static void main(String[] args) {
      Bicycle[] bicycleArray = {new Bicycle(697, true), 
                                new Bicycle(660, false), 
                                new Bicycle(610, false)};
      for (Bicycle bicycle : bicycleArray) {
         System.out.println(bicycle.toString());
      }
      getLargestBicycle(bicycleArray);
   }
      
   /**
   * A method to get information of the largest bike
   * and print a as a string
   * @param Array of bicycles objects
   * @return The bike info as a string
   */
   public static void getLargestBicycle(Bicycle[] bicycleArray) {
      Bicycle largestBicycle = bicycleArray[0];
      for (int i = 1; i < bicycleArray.length; i++) {
         if (bicycleArray[i] != null && 
            bicycleArray[i].getMetric() > largestBicycle.getMetric()) {
            largestBicycle = bicycleArray[i];
         }
      }
      System.out.println(largestBicycle.toString());
   }
}

/*
1. The boolean representation is more convenient that using a String of 'H' and 'T'.
They provides faster comparisons and are also type-safe preventing invalid chars being
accidentily included

2. You can create a loop that generates Coins objects with 1000 coins and then call countRuns()
adding the result to a total, you then would divid the total by the amount Coins objects generated.

To find the average longest run you would need to create a method in the Coins class that finds the longest
sequence of the same result. Then you coulde use the same approche as before, creating lots of random Coins
objects and record the longest run for each and dividing by the amount of Coins objects created.

3. To handle if the coin lands on its edge you could use a int array with constants defind for each possible outcome.
This would allow the coin toss to have 3 possible states instead of 2.
*/