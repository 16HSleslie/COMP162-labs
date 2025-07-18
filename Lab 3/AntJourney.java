/**
* A class representing an ant and the points along its journey
*/
public class AntJourney {
   private String antId;
   private Point[] journey;
   
   
   /*
   * Constructor that creates an AntJourney object with an id
   * and array of points the ant has been to
   * @param String with id of ant
   * @param Array of all the points the ant has been to
   */
   public AntJourney(String id, Point[] journey) {
      this.antId = id;
      this.journey = journey;
   }
   
   /*
   * Gets the id of this ant journey
   * @return The id as a String
   */
   public String getId() {
      return antId;
   }
   
   /*
   * Sets the id of this ant journey
   * @param The id string of new value
   */
   public void setId(String antId) {
      this.antId = antId;
   }
   
   /*
   * Calculates the total distance tavelled by the ant
   * @return The total distance travelled as a double value
   */
   public double getDistanceTravelled() {
      double totalDistance = 0.0;
      
      for (int x = 0; x < journey.length - 1; x++) {
         totalDistance += Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
      }
      
      return totalDistance;
   }
   
   /*
   * Calculates the shortest distanced tavelled 
   * by the ant between two points
   * @return The distanceof the shortest leg as a double value
   */
   public double getShortestLeg() {
      double shortestLeg = 0.0;
      for (int x = 0; x < journey.length - 1; x++) {
         if (Point.distanceBetweenTwoPoint(journey[x], journey[x+1]) < shortestLeg || shortestLeg == 0.0) {
            shortestLeg = Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
         }
      }
      return shortestLeg;
   }
   
   /*
   * Calculates the longest distanced tavelled 
   * by the ant between two points
   * @return The distance of the longest leg as a double value
   */
   public double getLongestLeg() {
      double longestLeg = 0.0;
      for (int x = 0; x < journey.length - 1; x++) {
         if (Point.distanceBetweenTwoPoint(journey[x], journey[x+1]) > longestLeg) {
            longestLeg = Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
         }
      }
      return longestLeg;
   }
   
   /*
   * Return a string of all the points the ant has travelled to
   * @return String in format "(x, y)(x, y)..."
   */
   public String toString() {
      StringBuilder s = new StringBuilder();
      for (Point point : journey) {
         s.append(point.toString());
      }
      return s.toString();
   }
}