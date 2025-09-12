public class StudentList {
    private SLLNode first;
    private SLLNode last;
    private int size;
    
    /*
    * Method to add a student to the head of the linked list
    * @param st Student object
    */
    public void addStudentToHead(Student st) {
        if (first == null) {
            first = new SLLNode(st, null);
            last = first;
            size++;
        } else {
            SLLNode temp = new SLLNode(st, first);
            first = temp;
            size++;
        }
    }
    
    /*public void addStudentToTail(Student st) {
        SLLNode curr = first;
        while( curr.next != null ) {
            curr = curr.next;
        }
        
        curr.next = new SLLNode(st, null);
    }*/
    
    /*
    * Method to add a student to the tail of the linked list
    * @param st Student object
    */
    public void addStudentToTail(Student st) {    
        SLLNode temp = new SLLNode(st, null);
        last.next = temp;
        last = temp;
        size++;
    }
    
    /*
    * Method to remove a student object from the linked list by index
    * @param removeMe Int of index num
    */
    public void removeItem(int removeMe) {
        if(size == 0 || removeMe < 0 || removeMe >= size) {
            return;
        }
        
        if (removeMe == 0) {
            first = first.next;
            
            return;
        }
        
        SLLNode curr = first;
        
        for (int i = 0; curr.next != null && i + 1 < removeMe; i++) {
            curr = curr.next;
        }
        
        if (curr.next == last) {
            curr.next = null;
            last = curr;
            
            return;
        }
        
        curr.next = curr.next.next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    /*
    * Method to display the Linked List by printing to console
    */
    public void displayStudent() {
        SLLNode curr = first;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
    
    /*
    * Method to convert Linked List to a String
    * @return Linked List as a String
    */
    public String toString() {
        if (first == null) return "[]";
        
        SLLNode curr = first;
        StringBuilder sb = new StringBuilder("[" + curr.value);
        
        while( curr.next != null) {
            curr = curr.next;
            sb.append(", " + curr.value);
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    /*
    * Class to represent a node in the Linked List
    */

    public class SLLNode {
        private Student value;
        private SLLNode next;
        
        public SLLNode(Student value, SLLNode next) {
            this.value = value;
            this.next = next;
        }
    }
}

