public class StudentList {
    private SLLNode first;
    
    public void addStudentToHead(Student st) {
        if (first == null) {
            first = new SLLNode(st, null);
        } else {
            SLLNode temp = new SLLNode(st, first);
            first = temp;
        }
    }
    
    public void addStudentToTail(Student st) {
        SLLNode curr = first;
        while( curr.next() != null ) {
            curr = curr.next();
        }
        
        first = new SLLNode(st, curr);
    }
    
    public void displayStudent() {
        SLLNode curr = first;
        while( curr != null) {
            System.out.println(curr.value());
            curr = curr.next();
        }
    }
}