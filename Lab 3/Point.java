/**
* A class representing a point in space with integer coordinates
*/
public class Point {
   private int x, y;
   
   /**
   * Default constructor that creates a point at (0, 0)
   */
   public Point() {
      this.x = 0;
      this.y = 0;
   }
   
   /**
   * Constructor that creates a point at specified coordinates
   * @param x The x-coordinate of the point
   * @param y The y-coordinate of the point
   */
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   /**
   * Accessor method that gets the x-coordinate of this point
   * @return The x-coordinate as an integer
   */
   public int getX() {
      return x;
   }
   
   /**
   * Accessor method that gets the y-coordinate of this point
   * @return The y-coordinate as an integer
   */
   public int getY() {
      return y;
   }
   
   /**
   * Mutator method that sets the x-coordinate of this point
   * @param x The new x-coordinate value
   */
   public void setX(int x) {
      this.x = x;
   }
   
   /**
   * Mutator method that sets the y-coordinate of this point
   * @param y The new y-coordinate value
   */
   public void setY(int y) {
      this.y = y;
   }
   
   /**
   * Calculates the distance from this point to another point
   * @param p The other point to calculate distance to
   * @return The distance as a double value
   */
   public double distanceToOtherPoint(Point p) {
      int distanceX = (this.x - p.x);
      int distanceY = (this.y - p.y);
      return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
   }
   
   /**
   * Static method to calculate distance between two points
   * @param p1 The first point
   * @param p2 The second point
   * @return The distance between the two points as a double value
   */
   public static double distanceBetweenTwoPoint(Point p1, Point p2) {
      int distanceX = (p1.x - p2.x);
      int distanceY = (p1.y - p2.y);
      return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
   }
   
   /**
   * Returns a string of this point
   * @return String in format "(x, y)"
   */
   public String toString() {
      return "(" + x + ", " + y + ")";
   }
}