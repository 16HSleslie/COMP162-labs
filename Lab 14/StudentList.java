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
            first.prev = temp;
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
        temp.prev = last;
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
        StringBuilder sb = new StringBuilder();
        SLLNode curr = first;
        
        sb.append("[");
        while( curr.next != null) {
            sb.append(String.format("\"%s\", ", curr.value));
            curr = curr.next;
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    public class SLLNode {
        private Student value;
        private SLLNode next;
        private SLLNode prev;
        
        public SLLNode(Student value, SLLNode next, SLLNode next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

