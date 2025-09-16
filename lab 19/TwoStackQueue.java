import java.util.EmptyStackException;
import java.util.Stack;

public class TwoStackQueue<E> implements Queue<E> {
    private MyStack<E> left;
    private MyStack<E> right;
    private int size;

    public TwoStackQueue() {
        this.left = new MyStack<>();
        this.right = new MyStack<>();
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

    /**
     * Return the element at the front of this Queue.
     *
     * @return the element at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E getFirst() {
        if (right.empty() && left.empty())
            throw new EmptyStackException();

        if (right.empty()) {
            while(!left.empty()) {
                right.push(left.pop());
            }
        }

        return right.peek();
    }

    /**
     * Make this Queue empty.
     */
    public void clear() {

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
        if (right.empty() && left.empty())
            throw new EmptyStackException();

        if (right.empty()) {
            while(!left.empty()) {
                right.push(left.pop());
            }
        }

        size--;
        return right.pop();
    }

    public MyStack<E> copyQueue() {
        getFirst();
        return right;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<Queue>:");

        MyStack<E> stack = copyQueue();

        while (!stack.empty()) {
            sb.append(stack.pop());
            if (!stack.empty()) {
                sb.append(" --> ");
            }
        }

        return sb.toString();
    }

}
