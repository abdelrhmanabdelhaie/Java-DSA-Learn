package DS.linerDS.Queue.c$PriorityQueue.arrayPriorityQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class ArrayPriorityQueue<T extends Comparable<T>> implements QueueTemplate<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] queueArray;
    private int size;

    public ArrayPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayPriorityQueue(int capacity) {
        queueArray = (T[]) new Comparable[capacity];
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == queueArray.length) {
            expandCapacity();
        }
        int index = size;
        while (index > 0 && element.compareTo(queueArray[index - 1]) < 0) {
            queueArray[index] = queueArray[index - 1];
            index--;
        }
        queueArray[index] = element;
        size++;
    }
    // Time Complexity: O(n)
    // Enqueuing an element involves finding the correct position to insert the element in the sorted array. In the worst case, when the element needs to be inserted at the beginning of the array, the time complexity is O(n), where n is the current number of elements in the queue.

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = queueArray[0];
        for (int i = 1; i < size; i++) {
            queueArray[i - 1] = queueArray[i];
        }
        queueArray[size - 1] = null;
        size--;
        return element;
    }
    // Time Complexity: O(n)
    // Dequeuing an element involves shifting all elements in the array to the left. This operation has a time complexity of O(n), where n is the current number of elements in the queue.

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queueArray[0];
    }
    // Time Complexity: O(1)
    // Peeking at the element at the front of the queue can be done in constant time.

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // Time Complexity: O(1)
    // Checking if the queue is empty can be done in constant time.

    @Override
    public int size() {
        return size;
    }
    // Time Complexity: O(1)
    // Getting the size of the queue can be done in constant time.

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            queueArray[i] = null;
        }
        size = 0;
    }
    // Time Complexity: O(n)
    // Clearing the queue involves setting all elements to null, which requires iterating over the array. The time complexity is O(n), where n is the current number of elements in the queue.

    private void expandCapacity() {
        int newCapacity = queueArray.length * 2;
        T[] newArray = (T[]) new Comparable[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[i];
        }
        queueArray = newArray;
    }
    // Time Complexity: O(n)
    // Expanding the capacity of the array involves creating a new array with double the capacity and copying the elements from the old array to the new array. The time complexity is O(n), where n is the current number of elements in the queue.
}