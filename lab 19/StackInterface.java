public interface StackInterface<E>{

    /** Adds an element to the top of the stack*/
    public void push(E element);

    /** Removes and returns the top element on the stack*/
    public E pop();

    /** Returns the value of the top element of the stack without removing it*/
    public E peek();

    /** Is this stack empty? */
    public boolean empty();


}