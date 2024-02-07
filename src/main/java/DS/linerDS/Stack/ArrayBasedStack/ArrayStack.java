package DS.linerDS.Stack.ArrayBasedStack;

import DS.linerDS.Stack.StackTemplate;

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackTemplate<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stackArray;
    private int top;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        stackArray = (T[]) new Object[capacity];
        top = -1; //Top set to -1 as initially no element on the array
    }

    @Override
    public void push(T element) { //O(1)
        if (top == stackArray.length - 1) {
            expandCapacity();
        }
        top++;
        stackArray[top] = element;
    }

    @Override
    public T pop() { //O(1)
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = stackArray[top];
        stackArray[top] = null;
        top--;
        return element;
    }

    @Override
    public T peek() { //O(1)
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() { //O(1)
        return top == -1;
    }

    @Override
    public int size() {  //O(1)
        return top + 1;
    }

    @Override
    public void clear() { //O(n)
        for (int i = 0; i <= top; i++) {
            stackArray[i] = null;
        }
        top = -1;
    }

    private void expandCapacity() { //O(n)
        int newCapacity = stackArray.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
        stackArray = newArray;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack=new ArrayStack();

        arrayStack.push2(2);
        arrayStack.push2(4);
        arrayStack.push2(6);
        arrayStack.push2(8);
        arrayStack.push2(10);

        System.out.println(arrayStack.pop2());
        System.out.println(arrayStack.pop2());
        System.out.println(arrayStack.pop2());
        System.out.println(arrayStack.pek2());
        System.out.println(arrayStack.pop2());
        System.out.println(arrayStack.pop2());

    }

    public void push2(T data){
        if(top == stackArray.length -1){
            expandCapacity();
        }
        top++;
        stackArray[top]=data;
    }

    public T pop2(){
        if (top == -1){
            throw new EmptyStackException();
        }
        T t = stackArray[top];
        stackArray[top] = null;
        top--;
        return t;
    }

    public T pek2(){
        if (top == -1){
            throw new EmptyStackException();
        }
       return stackArray[top];
    }




}