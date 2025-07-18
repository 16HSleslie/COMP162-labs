import java.util.*;
import java.io.*;
import java.nio.file.*;


public class AntStudyApp {
   public static void main(String[] args) {
      Point[] testJourneyData = {new Point(0, 0),new Point(4, 0),new Point(4, 3),new Point(0, 0)};
      Point[] blueAntJourneyData  = {new Point(0, 0), new Point(2, 1), new Point(3, 4), new Point(1, 6), new Point(4, 7), 
                                     new Point(6, 4), new Point(3, 1), new Point(1, 4), new Point(0, 0),};
      
      Point[] greenAntJourneyData  = {new Point(0, 0), new Point(3, 3), new Point(4, 5), new Point(8, 8), new Point(7, 13), 
                                      new Point(11, 14), new Point(14, 18), new Point(19, 14), new Point(14, 11), new Point(19, 9), 
                                      new Point(14, 7), new Point(10, 2), new Point(0, 0)};
                                                    
      Point[] redAntJourneyData = {new Point(0, 0), new Point(12, 12), new Point(10, 16), new Point(6, 17), new Point(1, 13),
                                   new Point(6, 11), new Point(1, 10), new Point(0, 0)};
                                   
      Point[] purpleAntJourneyData  = {new Point(0, 0), new Point(6, 2), new Point(9, 8), new Point(16, 7), new Point(12, 1), 
                                       new Point(7, 4), new Point(9, 1), new Point(0, 0)};
                                       
      
      ArrayList<AntJourney> journeys = new ArrayList<AntJourney>();
      journeys.add(new AntJourney("Blue Ant", blueAntJourneyData));
      journeys.add(new AntJourney("Red Ant", redAntJourneyData));
      journeys.add(new AntJourney("Green Ant", greenAntJourneyData));
      journeys.add(new AntJourney("Purple Ant", purpleAntJourneyData));
      
      for (AntJourney journey : journeys) {
         System.out.printf("%s: %s\n", journey.getId(), journey.toString());
         System.out.printf("Total distance travelled: %s\n", journey.getDistanceTravelled());
         System.out.printf("The distance of the shortest leg: %s\n", journey.getShortestLeg());
         System.out.printf("The distance of the longest leg: %s\n\n", journey.getLongestLeg());
      }
   }
   
   public static AntJourney[] initFromFile(String path) {
      ArrayList<String> antStrings = new ArrayList<String>();
      
      try {
         Scanner fileScanner = new Scanner(new File(path));
         while (fileScanner.hasNextLine()) {
            antStrings.add(fileScanner.nextLine());
         }
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }
      return null;
   }
}