public class SLLNode {
    private Student value;
    private SLLNode next;
    
    public SLLNode(Student value, SLLNode next) {
        this.value = value;
        this.next = next;
    }
    
    public Student value() {
        return value;
    }
    
    public SLLNode next() {
        return next;
    }
}