/*
Finish the Car and Boat constructors so that all data fields are correctly filled.

(b) A car’s fuel consumption is calculated by mutiplying litres per kilometre by trip length, and a
boat’s fuel consumption is calculated by mutiplying litres per hour by trip length - write the
missing (required) methods.
*/

public abstract class Vehicle {
    protected String name;
    protected String ctryOfOrigin;
    
    public abstract int fuelConsumption(int tripLength);
    
    public Vehicle(String name, String ctryOfOrigin) {
        this.ctryOfOrigin = ctryOfOrigin;
        this.name = name;
    }
}

public class Car extends Vehicle {
    private int numAirBags;
    private int litresPerKm;
    
    public Car(String name, String ctryOfOrigin, int lpK, int airBags) {
        Super(name, ctryOfOrigin);
        this.numAirBags = airBags;
        this.litresPerKm = lpK;
        
  
    }
    
    public int fuelConsumption(int tripLength) {
        return tripLength * litresPerKm;
    }
    
    public String toString() {
        return "Car with " + numAirBags + " air bags made in " + ctryOfOrigin;
    }
}

public class Boat extends Vehicle {
    private int litresPerHr;
    private int numBerths;
    
    public Boat(String name, String ctryOfOrigin, int lpH, int brths) {
        this.litresPerHr = lpH;
        this.numBerths = brths;
        
        Super(name, ctryOfOrigin);
    }
    
    public int fuelConsumption(int triplength) {
        return triplength * litresPerHr;
    }
    
    public String toString() {
        return "Boat with " + numBerths + " berths made in " + ctryOfOrigin;
    }
}

/*
(c) In the main method of the application class (below), write a for-each loop which prints out what
is returned by the toString method of every element in the vehicles array.
*/

public class VehicleApp {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Toyota Starlet", "Japan", 25, 0),
            new Car("Volvo XC40", "Sweden", 20, 2),
            new Boat("Markline 700 Sport", "New Zealand", 40, 2)
        };
        
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}

/*
2. These questions refer to the image on the following page.
    (a) Which two of the classes in figure 7.1 could legally call a method named test even if you re-
    moved the method definition from that class?
    
    Class C and Class D

    (b) Which one of the classes in figure 7.1 can not be instantiated?
    
    Class B

    (c) Which two classes’ test method could legally contain the statement super.test() ?
    
    Class C and Class D

    Figure 7.1: A class hierarchy with an abstract class
    (d) Which two classes must each legally contain a method called test?
    
    Class E and Class F

*/