package DS.linerDS.Queue.b$CircularQueue.arrayCircularQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class ArrayCircularQueue<T> implements QueueTemplate<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private T[] queueArray;
    private int front;
    private int rear;
    private int size;

    public ArrayCircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayCircularQueue(int capacity) {
        queueArray = (T[]) new Object[capacity];
        front = rear = 0;
        size = 0;
    }
//    WHY front & rear init with 0?
//    In a Java implementation of an ArrayCircularQueue, the standard initial values for front and rear are both 0.
//    Here's a breakdown of why this initialization is used:
//    Empty State: When a queue is empty, there are no elements to be dequeued or enqueued. Therefore, both front and rear point to the same empty position, indicating the absence of elements.
//    Efficient Handling: By starting both indices at 0, it becomes easier to manage enqueue and dequeue operations using modulo arithmetic.
//    Full Queue Detection: A queue is considered full when (rear + 1) % array_size == front. Initializing both to 0 ensures that this condition accurately reflects a full queue.

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (isEmpty()) {
            front = 0;
        }
        queueArray[rear] = element;
        rear = (rear + 1) % queueArray.length; // Wrap around with modulo operation
        size++;

        System.out.println("Enqueued element: " + element);
    }
    // Time Complexity: O(1)
    // Enqueuing an element involves adding it to the rear of the queue. This operation can be done in constant time.

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length; // Wrap around with modulo operation
        size--;
        return element;
    }
    // Time Complexity: O(1)
    // Dequeuing an element involves removing and returning the element at the front of the queue. This operation can be done in constant time.

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
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
        queueArray = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }
    // Time Complexity: O(1)
    // Clearing the queue involves creating a new array with the default capacity and resetting the front, rear, and size. This operation can be done in constant time.

    private boolean isFull() {
        return size == queueArray.length;
    }

    public void printArray(){
        System.out.println();
        System.out.println("front: "+front);
        System.out.println("rear: "+rear);
        System.out.println("size: "+size);
        System.out.println("Capacity: "+queueArray.length);

        int i = front;
        if(!isEmpty()) {
            do {
                System.out.print(queueArray[i] + " ");
                i = (i + 1) % queueArray.length;
            }
            while (i != rear);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayCircularQueue<Integer> acq = new ArrayCircularQueue<>();
        acq.printArray();
        acq.enqueue(1);
        acq.enqueue(2);
        acq.enqueue(3);
        acq.enqueue(4);
        acq.enqueue(5);

        acq.printArray();
        System.out.println("Dequeued element: "+ acq.dequeue());
        System.out.println("Dequeued element: "+ acq.dequeue());

        acq.printArray();
        acq.enqueue(1);
        acq.enqueue(2);

        acq.printArray();
    }
}