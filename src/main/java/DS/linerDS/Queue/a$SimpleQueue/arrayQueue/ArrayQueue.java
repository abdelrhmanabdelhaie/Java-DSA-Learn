package DS.linerDS.Queue.a$SimpleQueue.arrayQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements QueueTemplate<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] queueArray;
    private int front;
    private int rear;
    private int size; // Size of elements on the Array;
    //Capacity = all array size = elements + empty positions = queueArray.length

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);

    }

    public ArrayQueue(int capacity) {
        queueArray = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Time Complexity: O(1) amortized
    // Enqueuing an element involves adding it to the rear of the queue. In the worst case,
    // when the array needs to be resized, the time complexity is O(n), where n is the current capacity of the array.
    // However, on average, the amortized time complexity is O(1) because the resizing operation occurs infrequently.
    @Override
    public void enqueue(T element) {
        if (size == queueArray.length) {
            expandCapacity();
            // Queue is full, perform resizing or handle the overflow
            // Resizing operation may take O(n) time complexity
        }
       queueArray[++rear]=element;
        size++;
    }

    // Time Complexity: O(1)
    // Dequeuing an element involves removing and returning the element at the front of the queue. This operation can be done in constant time.
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
            // Queue is empty, handle the underflow condition
            // Return an appropriate value or throw an exception
        }
        T element = queueArray[front];
        shiftElementsToLeft();
        if(size <= queueArray.length/4){
            //Shrink
            shrinkCapacity();
        }
        return element;
    }

    // Time Complexity: O(1)
    // Peeking at the element at the front of the queue can be done in constant time.
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
            // Queue is empty, handle the empty queue condition
            // Return an appropriate value or throw an exception
        }
        return queueArray[front];
    }


    // Time Complexity: O(1)
    // Checking if the queue is empty can be done in constant time.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // Time Complexity: O(1)
    // Getting the size of the queue can be done in constant time.
    @Override
    public int size() {
        return size;
    }


    // Time Complexity: O(n)
    // Clearing the queue involves setting all elements to null, which requires iterating over the array.
    // The time complexity is O(n), where n is the current capacity of the array.
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
    // Expanding the capacity of the array involves creating a new array with double the capacity and copying the elements from the old array to the new array.
    // The time complexity is O(n), where n is the current capacity of the array.
    private void expandCapacity() {
        int newCapacity = queueArray.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[i];
        }
        queueArray = newArray;
        front = 0;
        rear = size - 1;
    }
    private void shrinkCapacity() {
        int newCapacity = queueArray.length / 2;
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queueArray[i];
        }
        queueArray = newArray;
        front = 0;
        rear = size - 1;
    }

    private void shiftElementsToLeft() {
        for (int i = 0; i < rear; i++) {
            queueArray[i] = queueArray[i+1];
        }
        queueArray[rear]=null;
        rear--;
        size--;
    }

    private void shiftElementsToRight() {
        for (int i = rear; i >= front; i--) {
            queueArray[i + 1] = queueArray[i];
        }
    }

    public void printArray(){
        System.out.println("front: "+front);
        System.out.println("rear: "+rear);
        System.out.println("size: "+size);
        System.out.println("Capacity: "+queueArray.length);
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        aq.enqueue(4);
        aq.enqueue(5);
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        aq.enqueue(4);
        aq.enqueue(5);
        aq.enqueue(1);


        aq.printArray();
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        aq.printArray();
    }
}