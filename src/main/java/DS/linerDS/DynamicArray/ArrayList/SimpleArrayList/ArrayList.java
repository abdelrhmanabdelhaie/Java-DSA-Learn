package DS.linerDS.DynamicArray.ArrayList.SimpleArrayList;

// Java program to implement
// our own Dynamic Array class

import java.util.*;


public class ArrayList implements ArrayListTemplate{

    // arr is the array which stores
    // our ArrayList elements
    private int arr[];

    // capacity is the total storage
    // capacity of the ArrayList
    private int capacity;

    // current is the number of elements
    // currently present in the ArrayList
    private int size;

    // Default constructor to initialise
    // an initial capacity of 1 element and
    // allocating storage using dynamic allocation
    public ArrayList() {
        arr = new int[1];
        capacity = 1;
        size = 0;
    }

    // Second Constructor to init size
    // Capacity will be double size
    public ArrayList(int size) {
        arr = new int[size * 2];
        capacity = size * 2;
        this.size = 0;
    }


    // Function to add an element at the last
    public void add(int data) { //O(1)

        // if the number of elements
        // is equal to the capacity,
        // that means we don't have space
        // to accommodate more elements.
        // We need to double the capacity
        if (size == capacity) {//O(n)
            expand();
        }

        // Inserting data
        arr[size] = data;
        size++;
    }
    private void expand(){
        int temp[] = new int[2 * capacity];
        // copying old array elements
        // to new array
        for (int i = 0; i < capacity; i++)
            temp[i] = arr[i];

        capacity *= 2;
        arr = temp;
    }

    // function to add element at any index
   public void add(int data, int index) { //O(n)
       if (index > size || index < 0) {
           throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
       }

       //compare the size with the number of elements if not equal grows the array size
       if (size == capacity) {
           expand();
       }

       for (int i = size - 1; i >= index; i--) {
        //shifting all the elements to the left from the specified index
           arr[i + 1] = arr[i];
       }
        //inserts an element at the specified index
       arr[index] = data;
       size++;
   }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public void addAll(Collection c) {
        if (c != null) {
            for (Object element : c) {
                add((int) element);
            }
        }
    }
    public void addAll(int index, Collection c) {
        if (c != null) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }
            for (Object element : c) {
                add((int) element, index);
                index++;
            }
        }
    }

    // Function to extract
    // element at any index
    public int get(int index) { //O(1)

        // if index is within the range
        if (index >0 && index < size)
            return arr[index];

        // if index is outside the range
        return -1;
    }

    // function to delete last element
    public void remove() { //O(1)
        size--;
        if(capacity/2 > size){
            shrinkSize();
        }
    }

    public void remove(int index) { //O(n)
        if (size > 0) {
            for (int i = index; i < size - 1; i++) {
            //shifting all the elements to the left from the specified index
                arr[i] = arr[i + 1];
            }
            arr[size - 1] = 0;
            remove();
        }
    }

    //the method removes the unused space
    public void shrinkSize() {
        //declares a temp[] array
        int temp[] = null;
        if (size > 0) {
            //creates an array of the size equal to the count i.e. number of elements the array have
            temp = new int[size * 2];
            for (int i = 0; i < size; i++) {
                //copies all the elements of the old array
                temp[i] = arr[i];
            }
            capacity = size * 2;
            arr = temp;
        }
    }

    // function to get size
    // of the ArrayList
    public int size() {
        return size;
    }

    // function to get capacity
    // of the ArrayList
    public int getCapacity() {
        return capacity;
    }

    // utility method
    /** Checks whether the given index is in the range [0, n−1]. */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
     if (i < 0 || i >= n)
           throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    // function to print ArrayList elements
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ArrayListTemplate v = new ArrayList();
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);

        System.out.println("ArrayList size: "+ v.size());
        System.out.println( "ArrayList capacity: "+ v.getCapacity());
        System.out.println("ArrayList elements: ");
        v.print();

        v.add(100, 1);

        System.out.println("\nAfter updating 1st index");

        System.out.println("ArrayList elements: ");
        v.print();
        System.out.println("Element at 1st index: "+ v.get(1));

        v.remove();

        System.out.println("\nAfter deleting the"+ " last element");

        System.out.println("ArrayList size: "+ v.size());
        System.out.println("ArrayList capacity: " + v.getCapacity());

        System.out.println("ArrayList elements: ");
        v.print();
    }
}
