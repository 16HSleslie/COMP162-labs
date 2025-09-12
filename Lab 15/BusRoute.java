/**
 * A class to represent and manage a busRoute which is comprised of a number of BusStops
 * and provide information about the time between any pair of BusStops
 * @author Nick Meek and Karen Gray
 */
public class BusRoute {

    /**The id of this route.*/
    private String routeId;
    /**The size of this route.*/
    private int size;
    /**The first or "hub" of this route.*/
    private DLLNode hubNode;

    /**The number of seconds this route takes to travel in its entirety.*/
    private int routeTime;

    /**
     * Constructor
     * @param routeId The unique identifier for this bus route.
     * @param routeTime The total travel time for this bus route.
     * @param firstBusStopId The id of the hubNode stop on this route.
     */
    public BusRoute(String routeId, int routeTime, String firstBusStopId) {
        this.routeId = routeId;
        this.routeTime = routeTime;
        
        BusStop hubStop = new BusStop(firstBusStopId, 0, 0, 0);
        this.hubNode = new DLLNode(hubStop, null, null);
        
        this.hubNode.next = this.hubNode;
        this.hubNode.prev = this.hubNode;
        //The hubNode BusStop on the route points to itself and has zero travel times.

    }

    /**
     * A method to set (or change) the route id
     * @param routeId The unique identifier for this bus route
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }


    /**
     * A method to set (or change) the route id
     * @return routeId The unique identifier for this bus route
     */
    public String getRouteId() {
        return routeId;
    }

    /** 
     * Returns the size of this route.
     * @return the size of this bus route.
     */
    public int getSize() {
        return size;
    }

    /**
     * Return a pointer to the BusStop with the given id - or null if not found.
     * @param busStopId The id of the BusStop to locate
     * @return a reference to the specified BusStop or null if not found
     */
    private DLLNode findNode(String busStopId) {
        DLLNode curr = hubNode.next;
        while (curr.value.getId() != busStopId) {
            curr = curr.next;
            if (curr == hubNode) {
                return null;
            }
        }
        return curr;
    }

    /**
     * Return a pointer to the BusStop with the given id - or null if not found.
     * @param busStopId The id of the BusStop to locate
     * @return a reference to the specified BusStop or null if not found
     */
    public BusStop findStop(String busStopId) {
        DLLNode node = findNode(busStopId);
        if(node == null){
            return null;
        }
        return node.value;
    }

    /**
    * A method to add (insert) a new BusStop to this route, based on its number of 
    * seconds from the hub (clockwise).
    * @param stopId The unique identifies for this bus Stop
    * @param secsFromHub The number of seconds from the hub to get to the 
             stop being added, travelling clockwise.
    */
    public void addStop(String stopId, int secsFromHub) {
        DLLNode prev = hubNode;
        
        while (prev.next != hubNode && prev.next.value.getSecondsFromHub() < secsFromHub) {
            prev = prev.next;
        }

        DLLNode next = prev.next;

        int timeToPrevStop = secsFromHub - prev.value.getSecondsFromHub();
        int timeToNextStop = (next == hubNode ? routeTime : next.value.getSecondsFromHub()) - secsFromHub;

        BusStop newStop = new BusStop(stopId,  timeToPrevStop, timeToNextStop, secsFromHub);
        DLLNode newNode = new DLLNode(newStop, next, prev);

        prev.value.setClockwiseSecs(timeToPrevStop);
        next.value.setAnticlockwiseSecs(timeToNextStop);

        next.prev = newNode;
        prev.next = newNode;

        size++;
    }

    /** A method to remove the BusStop with the specified id.
     * @param busStopId the id of the BusStop to remove
     */
    public void removeStop(String busStopId) {
        if ((hubNode.value).getId().equals(busStopId)) {
            System.out.println("You cannot remove the hub!");
        } else {
            DLLNode curr = findNode(busStopId);

            if (curr == null) {
                System.out.printf("Bus stop %s does not exist and cannot be removed\n!", busStopId);
                return;
            }

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr = curr.prev;

            int timeToStop = (curr.next == hubNode ? routeTime : curr.next.value.getSecondsFromHub()) - curr.value.getSecondsFromHub();

            curr.value.setClockwiseSecs(timeToStop);
            curr.next.value.setAnticlockwiseSecs(timeToStop);

            size--;
        }
    }

    /** A method to suspend the BusStop with the specified id.
     * NOTE: This does NOT affect the travel times to adjacent stops.
     * @param busStopId the id of the BusStop to suspend
     */
    public void suspendStop(String busStopId) {
        if((hubNode.value).getId().equals(busStopId)){
            System.out.println("You cannot suspend the hub!");
        } else{
            BusStop stop = findStop(busStopId);
            if(stop != null){
                stop.setInService(false);
            }
        }
    }

    /** A method to activate the BusStop with the specified id.
     * NOTE: This does NOT affect the travel times to adjacent stops.
     * @param busStopId the id of the BusStop to activate
     */
    public void activateStop(String busStopId) {
        BusStop stop = findStop(busStopId);
        if(stop != null){
            stop.setInService(true);
        }
    }

    /** A method to calculate the time to travel between two BusStops (clockwise)
     * The distance is strictly from busStop1 to busStop2 even if that means
     * going via the Bus Hub.
     * @param busStop1Id the id of the hubNode BusStop
     * @param busStop2Id the id of the second BusStop
     * @return int The number of seconds between two BusStops, or -1 if either of the stops does not exist.
     */
    public int secondsBetween2Stops(String busStop1Id, String busStop2Id) {
        DLLNode startNode = findNode(busStop1Id);
        DLLNode endNode = findNode(busStop2Id);

        if (startNode == null || endNode == null) return -1;

        int startTime = startNode.value.getSecondsFromHub();
        int endTime = endNode.value.getSecondsFromHub();

        if (endTime >= startTime) {
            return endTime - startTime;
        } else {
            return routeTime - startTime + endTime;
        }
    }

    /** Iterates through the list of DLLNode objects, CLOCKWISE,  appending the value of 
     * each one to a StringBuilder instance.
     @return a String representation of this BusRoute object
    */
    public String toString() {
        if (size == 0) return hubNode.value.toString();
        
        DLLNode curr = hubNode;
        StringBuilder sb = new StringBuilder();
        
        while (curr.next != hubNode) {
            sb.append(curr.value + "\n");
            curr = curr.next;
        }
        
        
        return sb.toString();
    }

    /** A doubly linked node with references to its two adjacent nodes and to its value*/
    private class DLLNode {
        private BusStop value;
        private DLLNode next, prev;

        /** Constructs a doubly linked node containing references to its two adjacent nodes and to its value
        @param value the value wrapped/stored in this node.
        @param next the node adjacent to this node CLOCKWISE
        @param prev the node adjacent to this node ANTICLOCKWISE
        */
        private DLLNode(BusStop value, DLLNode next, DLLNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}