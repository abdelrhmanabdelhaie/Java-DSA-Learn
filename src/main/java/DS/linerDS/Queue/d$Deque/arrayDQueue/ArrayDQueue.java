package DS.linerDS.Queue.d$Deque.arrayDQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class ArrayDQueue<T> implements QueueTemplate<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] queueArray;
    private int front;
    private int rear;
    private int size;

    public ArrayDQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayDQueue(int capacity) {
        queueArray = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == queueArray.length) {
            expandCapacity();
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = element;
        size++;
    }
    // Time Complexity: O(1) amortized
    // Enqueuing an element involves adding it to the rear of the queue. In the worst case, when the array needs to be resized, the time complexity is O(n), where n is the current capacity of the array. However, on average, the amortized time complexity is O(1) because the resizing operation occurs infrequently.

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        size--;
        return element;
    }
    // Time Complexity: O(1)
    // Dequeuing an element involves removing and returning the element at the front of the queue. This operation can be done in constant time.

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queueArray[front];
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
        for (int i = 0; i < queueArray.length; i++) {
            queueArray[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }
    // Time Complexity: O(n)
    // Clearing the queue involves setting all elements to null, which requires iterating over the array. The time complexity is O(n), where n is the current capacity of the array.

    private void expandCapacity() {
        int newCapacity = queueArray.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[(front + i) % queueArray.length];
        }
        queueArray = newArray;
        front = 0;
        rear = size - 1;
    }
    // Time Complexity: O(n)
    // Expanding the capacity of the array involves creating a new array with double the capacity and copying the elements from the old array to the new array. The time complexity is O(n), where n is the current capacity of the array.
}