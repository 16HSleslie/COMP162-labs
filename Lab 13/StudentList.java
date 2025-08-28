public class StudentList {
    private SLLNode first;
    private SLLNode last;
    private int size;
    
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
    
    public void addStudentToTail(Student st) {    
        SLLNode temp = new SLLNode(st, null);
        last.next = temp;
        last = temp;
        size++;
    }
    
    public void removeItem(int removeMe) {
        if(size == 0 || removeMe < 0 || removeMe >= size) {
            return;
        } else {
            SLLNode curr = first;
            int count = 0;
            
            while(curr.next != null &&  count + 1 < removeMe) {
                curr = curr.next;
                count++;
            }
            
            SLLNode temp = curr.next;
            curr.next = temp.next;
        }
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void displayStudent() {
        SLLNode curr = first;
        while( curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
    
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
    
    public class SLLNode {
        private Student value;
        private SLLNode next;
        
        public SLLNode(Student value, SLLNode next) {
            this.value = value;
            this.next = next;
        }
    }
}

