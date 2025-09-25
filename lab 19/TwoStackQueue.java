import java.util.EmptyStackException;
import java.util.Stack;

public class TwoStackQueue<E> implements Queue<E> {
    private Stack<E> left;
    private Stack<E> right;
    private int size;
    
    public TwoStackQueue() {
        this.left = new Stack<>();
        this.right = new Stack<>();
        this.size = 0;
    }
    
    
    /**
     * Return true if and only if this Queue is empty.
     *
     * @return true if this Queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Return the length of this Queue.
     *
     * @return the number of elements in this Queue.
     */
    public int size() {
        return size;
    }
    
    public void transferStack() {
        if (left.empty() && right.empty()) throw new EmptyQueueException();
        
        while (!left.empty()) {
            right.push(left.pop());
        }
    }
    
    /**
     * Return the element at the front of this Queue.
     *
     * @return the element at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E getFirst() {      
        if (right.empty()) {
            transferStack();
        }
        
        return right.peek();
    }
    
    /**
     * Make this Queue empty.
     */
    public void clear() {
        this.left = new Stack();
        this.right = new Stack();
        this.size = 0;
    }
    
    /**
     * Add an element to the rear of this Queue.
     *
     * @param elem the Object to be added to the rear of the Queue.
     */
    public void addLast(E elem) {
        left.push(elem);
        size++;
    }
    
    /**
     * Remove and return the front element of this Queue.
     *
     * @return the element at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E removeFirst() {     
        if (right.empty()) {
            transferStack();
        }
        
        return right.pop();    
    }
    
    public String debug() {
        return left.toString() + right.toString();
    }
    
    public String toString() {      
        if (size == 0) return "[]";
        if (right.empty()) return left.toString();

        Stack<E> rightCopy = (Stack<E>) right.clone();

        StringBuilder sb = new StringBuilder("[" + rightCopy.pop());

        while (!rightCopy.empty()) {
            sb.append(", ").append(rightCopy.pop());
        }

        sb.append(", ").append(left.toString().substring(1));
        return sb.toString();
    }
}