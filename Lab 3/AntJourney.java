public class AntJourney {
   private String antId;
   private Point[] journey;
   
   public AntJourney(String id, Point[] journey) {
      this.antId = id;
      this.journey = journey;
   }
   
   public double getDistanceTravelled() {
      double totalDistance = 0.0;
      
      for (int x = 0; x <= journey.length; x++) {
         totalDistance += Point.distanceBetweenTwoPoint(journey[x], journey[x+1]);
      }
      
      return totalDistance;
   }
}