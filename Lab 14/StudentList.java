public class StudentList {
    private DLLNode first;
    private DLLNode last;
    private int size;
    
    public void addStudentToHead(Student st) {
        DLLNode newNode = new DLLNode(st, first, null);
        
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            first.prev = newNode;
            first = newNode;
        }
        
        size++;
    }
    
    
    public void addStudentToTail(Student st) {    
        DLLNode newNode = new DLLNode(st, null, last);
        
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.prev = newNode;
            last = newNode;
        }
        
        size++;
    }
    
    public void removeItem(int removeMe) {
        if(size == 0 || removeMe < 0 || removeMe >= size) {
            return;
        }
        
        DLLNode nodeToRemove = first;
        
        for (int i = 0; i < removeMe; i++) {
            nodeToRemove = nodeToRemove.next;
        }
        
        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            first = nodeToRemove.next;
        }
        
        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            last = nodeToRemove.prev;
        }
        
        size--;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void displayStudent() {
        DLLNode curr = first;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
    
    public void displayStudentReverse() {
        DLLNode curr = last;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.prev;
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLLNode curr = first;
        
        sb.append("[");
        while ( curr != null) {
            sb.append(String.format("\"%s\"", curr.value));
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    public class DLLNode {
        private Student value;
        private DLLNode next;
        private DLLNode prev;
        
        public DLLNode(Student value, DLLNode next, DLLNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

