public class StudentList {
    private DLLNode first;
    private DLLNode last;
    private int size;
    
    /*
    * Method to add a student to the head of the linked list
    * @param st Student object
    */
    public void addStudentToHead(Student st) {
        if (first == null) {
            first = new DLLNode(st, null, null);
            last = first;
            size++;
        } else {
            DLLNode newNode = new DLLNode(st, first, null);
            first.prev = newNode;
            first = newNode;
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
        DLLNode temp = new DLLNode(st, null, last);
        last.next = temp;
        last = temp;
        size++;
    }
    
    /*
    * Method to get a student object from the linked list by id
    * @param id String of student id
    * @retrun Student object
    */
    public Student getStudentById(String id) {
        if (this.first == null) return null;
        
        DLLNode curr = first;
        
        while (curr != null) {
            if (curr.value.getId().equals(id)) {
                return curr.value;
            }
            
            curr = curr.next;
        }
        
        return null;
    }
    
    /*
    * Method to remove a student object from the linked list by id
    * @param id String of student id
    */
    public void removeStudentById(String id) {
        if (this.first == null) return;
        
        DLLNode curr = first;
        
        while (curr != null) {
            if (curr.value.getId().equals(id)) {
                break;
            }
            
            curr = curr.next;
        }
        
        if (curr == first) {
            first = first.next;
            first.prev = null;
            
            return;
        } else if (curr == last) {
            last = last.prev;
            last.next = null;
            
            return;
        }
        
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
    }
    
    /*
    * Method to remove a student object from the linked list by index
    * @param removeMe Int of index num
    */
    public void removeItem(int removeMe) {
        if (size == 0 || removeMe < 0 || removeMe >= size) return;
        
        if (removeMe == 0) {
            first = first.next;
            first.prev = null;
            
            return;
        } else if (removeMe == size - 1) {
            last = last.prev;
            last.next = null;
            
            return;
        }
        
        DLLNode curr = first;
        
        for (int i = 0; i < removeMe; i++) {
            curr = curr.next;
        }
        
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        
        
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    /*
    * Method to display the Linked List by printing to console
    */
    public void displayStudent() {
        DLLNode curr = first;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
    
    /*
    * Method to display the Linked List in reverse by printing to console
    */
    public void displayStudentReverse() {
        DLLNode curr = last;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.prev;
        }
    }
    
    /*
    * Method to convert Linked List to a String
    * @return Linked List as a String
    */
    public String toString() {
        if (first == null) return "[]";
        
        DLLNode curr = first;
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
    public class DLLNode {
        private Student value;
        private DLLNode next;
        private DLLNode prev;
        
        /*
        * Constructor to init an object of SLLNode
        */
        public DLLNode(Student value, DLLNode next, DLLNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

