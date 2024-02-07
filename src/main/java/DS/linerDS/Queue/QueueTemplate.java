package DS.linerDS.Queue;

import java.util.NoSuchElementException;

/**
 * Interface for a generic queue.
 *
 * @param <T> the type of elements in the queue
 */
public interface QueueTemplate<T> {

    /**
     * Adds an element to the back of the queue.
     *
     * @param element the element to be added
     */
    void enqueue(T element);
    // Time Complexity: O(1)
    // Enqueuing an element involves adding it to the back of the queue, which can be done in constant time.

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T dequeue();
    // Time Complexity: O(1)
    // Dequeuing an element involves removing and returning the element at the front of the queue, which can be done in constant time.

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T peek();
    // Time Complexity: O(1)
    // Peeking at the element at the front of the queue can be done in constant time.

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();
    // Time Complexity: O(1)
    // Checking if the queue is empty can be done in constant time.

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();
    // Time Complexity: O(1)
    // Getting the size of the queue can be done in constant time.

    /**
     * Removes all elements from the queue.
     */
    void clear();
    // Time Complexity: O(1)
    // Clearing the queue involves removing all elements, which can be done in constant time.
}