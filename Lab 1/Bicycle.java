import java.util.Scanner;

public class Bicycle {
   private int wheelDia;
   private boolean electric;
   private String colour;
   
   
   /**
   * Constructor for Bicycle class
   * @param wheelDia The wheel diameter
   * @param electric Bike electic status
   */
   public Bicycle(int wheelDia, boolean electric) {
      this.wheelDia = wheelDia;
      this.electric = electric;
      setColour();
   }
   
   /**
   * A method to set the colour of the bike
   */
   public void setColour() {
      Scanner sc = new Scanner(System.in);
      System.out.print("Please enter the colour of the bike: ");
      colour = sc.next();
      System.out.println();
   }
   
   /**
   * A method to retive if the bike is electric
   * @return Is the bike electric
   */
   public boolean isElectric() {
      return electric;
   }
   
   /**
   * A method to conver the wheel diameter from
   * mm to inches
   * @return Wheel diameter in inches
   */
   public double getImperial() {
      return wheelDia / 25.4;
   }
   
   /**
   * A method to get the wheel diameter in mm
   * @return Wheel diameter in mm
   */
   public int getMetric() {
      return wheelDia;
   }
   
   /**
   * A method to get information of the bike
   * as a string
   * @return The bike info as a string
   */
   public String toString() {
      if (electric) {
         return String.format("Bicycle is %s. Wheel size is %s inches. Electric", colour, getImperial());
      } else {
         return String.format("Bicycle is %s. Wheel size is %s mm. Push-bike", colour, wheelDia);
      }
   }
}