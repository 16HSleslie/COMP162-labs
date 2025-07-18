/**
* An application class to test the Coins class
* @author Nick Meek
*/
public class CoinsApp{

   public static void main(String[] args){
      System.out.println("Testing orginal constructor");
      boolean[] coinTosses = {true, false, false, true, true, false};
      Coins c1 = new Coins(coinTosses);
      System.out.println(c1.countHeads());
      System.out.println(c1.toString());
      System.out.println(c1.countRuns());
      
      System.out.println("\nTesting string constructor");
      Coins c2 = new Coins("HHTTHT");
      System.out.println(c2.countHeads());
      System.out.println(c2.toString());
      System.out.println(c2.countRuns());
      
      System.out.println("\nTesting random constructor");
      Coins c3 = new Coins(8);
      System.out.println(c3.countHeads());
      System.out.println(c3.toString());
      System.out.println(c3.countRuns());
      
   }
}