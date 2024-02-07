package DS.linerDS.Stack.LinkedListBasedStack;

import DS.linerDS.Stack.StackTemplate;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackTemplate<T> {

    private Node<T> top;
    private int size;


    public void push(T element) { // Time complexity: O(1)
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {  // Time complexity: O(1)
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() { // Time complexity: O(1)
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() { // Time complexity: O(1)
        return top == null;
    }

    public int size() { // Time complexity: O(1)
        return size;
    }

    public void clear() { // Time complexity: O(1)
        top = null;
        size = 0;
    }
}

