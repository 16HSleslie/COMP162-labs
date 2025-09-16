public class MyStack<E> implements StackInterface<E>{
    private StackNode<E> head;
    private int size;

    public MyStack() {
        head = null;
        size = 0;
    }

    public void push(E element) {
        if (head == null) {
            head = new StackNode<E>(element, null);
            size++;

            return;
        }

        head = new StackNode<E>(element, head);
        size++;
    }

    /** Removes and returns the top element on the stack*/
    public E pop() {
        E element = head.element;
        head = head.next;
        size--;

        return element;
    }

    /** Returns the value of the top element of the stack without removing it
    *   @return Element stored in head node
    */
    public E peek() {
        return head.element;
    }

    /** Returns the size of the stack
    *   @return Size of stack as an Int
    */
    public int size() {
        return size;
    }

    /** Is this stack empty? 
    *   @return Boolean value if stack is empty or not
    */
    public boolean empty() {
        return size == 0;
    }
    
    /*
    * Creates a string of the stack order
    * @return String of stack order
    */
    public String toString() {
        StringBuilder sb = new StringBuilder("<Stack>:");
        StackNode<E> current = head;

        while (current != null) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(" --> ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    private class StackNode<E> {
        private final E element;
        private final StackNode<E> next;

        public StackNode(E element,  StackNode<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}