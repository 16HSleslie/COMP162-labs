public class AntJourney {
   private String antId;
   private Point[] journey;
   
   public AntJourney(String id, Point[] journey) {
      this.antId = id;
      this.journey = journey;
   }
   
   public String getId() {
      return antId;
   }
   
   public void setId(String antId) {
      this.antId = antId;
   }
   
   public double getDistanceTravelled() {
      double totalDistance = 0.0;
      
      for (int x = 0; x < journey.length - 1; x++) {
         totalDistance += Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
      }
      
      return totalDistance;
   }
   
   public double getShortestLeg() {
      double shortestLeg = 0.0;
      for (int x = 0; x < journey.length - 1; x++) {
         if (Point.distanceBetweenTwoPoint(journey[x], journey[x+1]) < shortestLeg || shortestLeg == 0.0) {
            shortestLeg = Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
         }
      }
      return shortestLeg;
   }
   
   public double getLongestLeg() {
      double longestLeg = 0.0;
      for (int x = 0; x < journey.length - 1; x++) {
         if (Point.distanceBetweenTwoPoint(journey[x], journey[x+1]) > longestLeg) {
            longestLeg = Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
         }
      }
      return longestLeg;
   }
   
   public String toString() {
      StringBuilder s = new StringBuilder();
      for (Point point : journey) {
         s.append(point.toString());
      }
      return s.toString();
   }
}