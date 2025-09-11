/**
 * A class to represent a single bus stop
 *
 ************************************
 * NOTE: private datafields of an inner class are able 
 * to be accessed directly by the outer class!!
 ************************************
 * @author Nick Meek
 */

public class BusStop {

    /** The id of this BusStop.*/
    private String id;
    /** The number of seconds to travel to the previous stop (ANTICLOCKWISE).*/
    private int secsAnticlockwise;

    /** The number of seconds to travel to the next stop (CLOCKWISE).*/
    private int secsClockwise;

    /**Whether or not this BusStop is currently in service.*/
    private boolean inService;

    /** The number of seconds this stopis from the hub when travelling clockwise*/
    private int secondsFromHub;

    /**
     * Default constructor
     */
    public BusStop() {}

    /**
     * Constructor
     * @param id The unique id of this bus stop
     * @param secsAnticlockwise The number of seconds to the next stop anticlockwise
     * @param secsClockwise The number of seconds to the next stop clockwise
     */
    public BusStop(String id, int secsAnticlockwise, int secsClockwise, int secondsFromHub) {
        this.id = id;
        this.secsAnticlockwise = secsAnticlockwise;
        this.secsClockwise = secsClockwise;
        this.inService = true;
        this.secondsFromHub = secondsFromHub;
    }

    /**
     * Returns the id of this bus stop
     * @return the id of this bus stop
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the inService status of this bus stop
     * @return the inService status of this bus stop
     */
    public boolean getInService() {
        return this.inService;
    }

    /**
     * Sets the service status of this bus stop
     * @param inService the updated service status of this bus stop
     */
    public void setInService(boolean inService) {
        this.inService = inService;
    }


    /**
     * Set the number of seconds to travel from this bus stop to the next stop anticlockwise;
     * @param secsAnticlockwise The number of seconds to the next anti-clockwise stop.
     */
    public void setAnticlockwiseSecs(int secsAnticlockwise) {
        this.secsAnticlockwise = secsAnticlockwise;
    }
    
    public int getSecondsFromHub() {
        return this.secondsFromHub;
    }

    /**
     * Set the number of seconds to travel from this bus stop to the next stop clockwise;
     * @param secsClockwise The number of seconds to the next clockwise stop.
     */
    public void setClockwiseSecs(int secsClockwise) {
        this.secsClockwise = secsClockwise;
    }

    /**
     * Get the number of seconds to travel from this bus stop to the next stop clockwise;
     * @return The number of seconds to travel from this bus stop to the previous stop (anticlockwise).
     */
    public int getAnticlockwiseSecs() {
        return this.secsAnticlockwise;
    }

    /**
     * Get the number of seconds to travel from this bus stop to the next stop clockwise;
     * @return The number of seconds to travel from this bus stop to the next stop (clockwise).
     */
    public int getClockwiseSecs() {
        return this.secsClockwise;
    }

    /**
     * Get a string representation of this bus stop
     * @return The string representation of this bus stop.
     */
    public String toString() {
        return "<--" + this.secsAnticlockwise + "--" + centreAlign(this.id, 20) + "--" + this.secsClockwise + "-> " + (inService ? "/" : "X");
    }

    /** 
    * Aligns a given String centrally within a given number of spaces.
    @param s the String being aligned.
    @param numSpaces the number of total spaces in which the string is being aligned.
    @return the centrally aligned String.
    */
    private String centreAlign(String s, int numSpaces) {
        if (numSpaces <= s.length()) {
            return s;
        }
        int gap1 = (numSpaces - s.length()) / 2;
        return " ".repeat(gap1) + s + " ".repeat(numSpaces - gap1 - s.length());
    }
}