package DS.linerDS.Queue.c$PriorityQueue.linkedPriorityQueue;

import DS.linerDS.Queue.QueueTemplate;

import java.util.NoSuchElementException;

public class LinkedPriorityQueue<T extends Comparable<T>> implements QueueTemplate<T> {
    private Node<T> front;
    private int size;

    public LinkedPriorityQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty() || element.compareTo(front.data) < 0) {
            newNode.next = front;
            front = newNode;
        } else {
            Node<T> current = front;
            while (current.next != null && element.compareTo(current.next.data) >= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    // Time Complexity: O(n)
    // Enqueuing an element involves finding the correct position to insert the element in the linked list. In the worst case, when the element needs to be inserted at the end of the list, the time complexity is O(n), where n is the current number of elements in the queue.

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = front.data;
        front = front.next;
        size--;
        return element;
    }
    // Time Complexity: O(1)
    // Dequeuing an element involves removing the front element from the linked list, which can be done in constant time.

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
        size = 0;
    }
    // Time Complexity: O(1)
    // Clearing the queue involves setting the front node to null and resetting the size to 0, which can be done in constant time.

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}