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
                                       
      
     //  System.out.println("***Testing AntJourney class functionality with test data***\n");
//       AntJourney testAntJourney = new AntJourney("Test Ant", testJourneyData);
//       System.out.printf("%s: %s\n", testAntJourney.getId(), testAntJourney.toString());
//       System.out.printf("Total distance travelled: %.2f\n", testAntJourney.getDistanceTravelled());
//       System.out.printf("The distance of the shortest leg: %.2f\n", testAntJourney.getShortestLeg());
//       System.out.printf("The distance of the longest leg: %.2f\n\n", testAntJourney.getLongestLeg());
//       
//       System.out.println("***Testing AntJourney class functionality with ArrayList of AntJourney's***\n");
//       ArrayList<AntJourney> antJourneyList = new ArrayList<>();
//       antJourneyList.add(new AntJourney("Blue Ant", blueAntJourneyData));
//       antJourneyList.add(new AntJourney("Green Ant", greenAntJourneyData));
//       antJourneyList.add(new AntJourney("Red Ant", redAntJourneyData));
      
      // for (AntJourney journey : antJourneyList) {
//          System.out.printf("%s: %s\n", journey.getId(), journey.toString());
//          System.out.printf("Total distance travelled: %.2f\n", journey.getDistanceTravelled());
//          System.out.printf("The distance of the shortest leg: %.2f\n", journey.getShortestLeg());
//          System.out.printf("The distance of the longest leg: %.2f\n\n", journey.getLongestLeg());
//       }
//       
//       System.out.println("***Testing initFromFile functionality***\n");
      
      ArrayList<AntJourney> journeys = initFromFile("AntJourneys.txt");
      
      for (AntJourney journey : journeys) {
         System.out.printf("%s: %s\n", journey.getId(), journey.toString());
         System.out.printf("Total distance travelled: %.2f\n", journey.getDistanceTravelled());
         System.out.printf("The distance of the shortest leg: %.2f\n", journey.getShortestLeg());
         System.out.printf("The distance of the longest leg: %.2f\n\n", journey.getLongestLeg());
      }
      
      System.out.println("***Testing using initFromFile with incorrect file***\n");
      
      ArrayList<AntJourney> test = initFromFile("notafile.txt");
      
   }
   
   /*
   * Reads ant journey data from a file and creates AntJourney objects
   * from the parsed data
   * @param The file path to read ant journey data from
   * @return An ArrayList of AntJourney objects from file data
   */
   public static ArrayList<AntJourney> initFromFile(String path) {
      ArrayList<String> antStrings = new ArrayList<String>();
      
      try {
         Scanner fileScanner = new Scanner(new File(path));
         while (fileScanner.hasNextLine()) {
            antStrings.add(fileScanner.nextLine());
         }
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }
      
      ArrayList<AntJourney> journeyList = new ArrayList<>();
      
      for (String ant : antStrings) {
         String[] splitString = ant.split(": ", -2);
         ArrayList<Point> pointList = new ArrayList<Point>();
         
         for (int x = 1; x < splitString.length; x++) {
            String[] points = splitString[x].split(",", 2);
            pointList.add(new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1])));
         }
         
         journeyList.add(new AntJourney(splitString[0], pointList.toArray(Point[]::new)));
      }
      
      return journeyList;
   }
}