public class DoublyLinkedList<T> implements List<T> {
    private DLLNode<T> first;
    private DLLNode<T> last;
    private int size;
    
    /*
    * Method to add a student to the head of the linked list
    * @param st Student object
    */
    public void add(T element) {
        if (first == null) {
            first = new DLLNode(element, null, null);
            last = first;
            size++;
        } else {
            DLLNode<T> newNode = new DLLNode(element, first, null);
            first.prev = newNode;
            first = newNode;
            size++;
        }
    }
    
    public void add(T element, int index) {
        if (first == null) {
            first = new DLLNode(element, null, null);
            last = first;
            size++;
        } else {
            
            if (index == 0) {
                add(element);
                
                return;
            }
            if (index == size - 1) {
                addLast(element);
                
                return;
            }
            
            DLLNode<T> curr = first;
            
            int count = 0;
            
            while (curr.next != null && count != index) {
                curr = curr.next;
                count++;
            }
            
            DLLNode<T> newNode = new DLLNode(element, curr.next, curr.prev);
            
            curr.prev.next = newNode;
            curr.prev = newNode;
            
            size++;
        }
    }
    
    /*
    * Method to add a student to the tail of the linked list
    * @param st Student object
    */
    public void addLast(T element) {    
        if (first == null) {
            first = new DLLNode(element, null, null);
            last = first;
            size++;
        } else {
            DLLNode<T> temp = new DLLNode(element, null, last);
            last.next = temp;
            last = temp;
            size++;
        }
    }
    
    public T get(int index) {
        if (size == 0) return null;
        
        DLLNode<T> curr = first;
            
        int count = 0;
            
        while (curr.next != null && count != index) {
            curr = curr.next;
            count++;
        }
        
        return curr.value;
    }
    
    public void removeNode(int removeMe) {
        if (size == 0 || removeMe < 0 || removeMe >= size) return;
        
        if (removeMe == 0) {
            first = first.next;
            first.prev = null;
            size--;
            
            return;
        } else if (removeMe == size - 1) {
            last = last.prev;
            last.next = null;
            size--;
            
            return;
        }
        
        DLLNode<T> curr = first;
        
        for (int i = 0; i < removeMe; i++) {
            curr = curr.next;
        }
        
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        
        size--;
        
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    /*
    * Method to display the Linked List by printing to console
    */
    public void displayList() {
        DLLNode<T> curr = first;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
    
    /*
    * Method to display the Linked List in reverse by printing to console
    */
    public void displayListReverse() {
        DLLNode<T> curr = last;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.prev;
        }
    }
    
    public int size() {
        return size;
    }
    
    /*
    * Method to convert Linked List to a String
    * @return Linked List as a String
    */
    public String toString() {
        if (first == null) return "[]";
        
        DLLNode<T> curr = first;
        StringBuilder sb = new StringBuilder("[" + curr.value);
        
        while( curr.next != null) {
            curr = curr.next;
            sb.append(", " + curr.value);
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    /*
    * Method to get a student object from the linked list by id
    * @param id String of student id
    * @retrun Student object
    */
    /*public T getStudentById(String id) {
        if (this.first == null) return null;
        
        DLLNode<T> curr = first;
        
        while (curr != null) {
            if (curr.value.getId().equals(id)) {
                return curr.value;
            }
            
            curr = curr.next;
        }
        
        return null;
    }*/
    
    /*
    * Method to remove a student object from the linked list by id
    * @param id String of student id
    */
    /*public void removeStudentById(String id) {
        if (this.first == null) return;
        
        DLLNode<T> curr = first;
        
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
    }*/
    
    /*
    * Method to remove a student object from the linked list by index
    * @param removeMe Int of index num
    */
    
    /*
    * Class to represent a node in the Linked List
    */
    public class DLLNode<T> {
        private T value;
        private DLLNode<T> next;
        private DLLNode<T> prev;
        
        /*
        * Constructor to init an object of SLLNode
        */
        public DLLNode(T value, DLLNode<T> next, DLLNode<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

