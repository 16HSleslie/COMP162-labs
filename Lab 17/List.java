public interface List < T > {
    /** Adds element T to head (start) of list. */
    void add(T element);
    /** Adds element T to middle of list. */
    void add(T element, int index);
    /** Adds element T to tail (end) of list. */
    void addLast(T element);
    /** Returns element T at specified index */
    T get(int index);
    /** Returns True if list contains no elements */
    boolean isEmpty();
    /** Returns the number of elements in this list. */
    int size();
    /** Returns pretty string representation of list. */
    String toString();
}