package DS.linerDS.Queue.d$Deque.linkedDQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class LinkedDQueue<T> implements QueueTemplate<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedDQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }
    // Time Complexity: O(1)
    // Enqueuing an element involves adding it to the rear of the queue. This operation can be done in constant time.

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
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
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}