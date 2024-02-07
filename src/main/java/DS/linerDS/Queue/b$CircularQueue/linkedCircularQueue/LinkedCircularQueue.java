package DS.linerDS.Queue.b$CircularQueue.linkedCircularQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class LinkedCircularQueue<T> implements QueueTemplate<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedCircularQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        rear.next = front; // Make the queue circular
        size++;
    }
    // Time Complexity: O(1)
    // Enqueuing an element involves adding it to the rear of the queue. This operation can be done in constant time.

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front; // Update the circular link
        }
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
        return front.data;
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
        front = null;
        rear = null;
        size = 0;
    }
    // Time Complexity: O(1)
    // Clearing the queue involves setting both the front and rear nodes to null and resetting the size to 0, which can be done in constant time.

    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedCircularQueue queue = new LinkedCircularQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Queue is full, cannot enqueue

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Queue is empty, cannot dequeue
        queue.dequeue();
    }
}