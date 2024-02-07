package DS.linerDS.LinkedList.b$DoubleLinkedList;

public class DoublyLinkedList<T extends Comparable<T>> {

    DLLNode<T> head;
    DLLNode<T> tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Insertion at the beginning (prepend)
    // Complexity: O(1)
    public void prepend(T data) {
        DLLNode<T> newDLLNode = new DLLNode<>(data);
        if (head == null) {
            head = newDLLNode;
            tail = newDLLNode;
        } else {
            newDLLNode.next = head;
            head.prev = newDLLNode;
            head = newDLLNode;
        }
        size++;
    }

    // Insertion at the end (append)
    // Complexity: O(1)
    public void append(T data) {
        DLLNode<T> newDLLNode = new DLLNode<>(data);
        if (head == null) {
            head = newDLLNode;
            tail = newDLLNode;
        } else {
            newDLLNode.prev = tail;
            tail.next = newDLLNode;
            tail = newDLLNode;
        }
        size++;
    }

    // Insertion at a specific position
    // Complexity: O(n)
    public void insertAtPosition(T data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            prepend(data);
        } else if (position == size) {
            append(data);
        } else {
            DLLNode<T> newDLLNode = new DLLNode<>(data);
            DLLNode<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newDLLNode.prev = current;
            newDLLNode.next = current.next;
            current.next.prev = newDLLNode;
            current.next = newDLLNode;
            size++;
        }
    }

    //Insert into sorted list
    //so must insert on the sorted position
//    To insert an element in a sorted doubly linked list, you can follow these steps:
//    1.Create a new DLLNode with the given data.
//    2.Check if the list is empty. If it is, set the new node as both the head and tail of the list.
//    3.If the data is less than the data in the head node, insert the new node at the beginning of the list using the prepend method.
//    4.If the data is greater than or equal to the data in the tail node, insert the new node at the end of the list using the append method.
//    5.Otherwise, iterate through the list starting from the head node.
//      Compare the data of each node with the given data.
//      If the data of the current node is greater than the given data, insert the new node before the current node.
//          Set the next pointer of the new node to the current node.
//          Set the prev pointer of the new node to the prev pointer of the current node.
//          Set the next pointer of the prev node to the new node.
//          Set the prev pointer of the current node to the new node.
//          Increment the size of the list.
//          Return from the method.
//      If the data of the current node is not greater than the given data, move to the next node.
//    6.If the loop completes without finding a suitable position to insert the new node, it means the new node should be inserted at the end of the list. Use the append method to insert the new node at the end.
//    7.Update the size of the list accordingly.
    public void insertSorted(T data) {
        DLLNode<T> newNode = new DLLNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (data.compareTo(head.data) < 0) {
            prepend(data);
        } else if (data.compareTo(tail.data) >= 0) {
            append(data);
        } else {
            DLLNode<T> current = head;
            while (current != null) {
                if (data.compareTo(current.data) < 0) {
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;
                    size++;
                    return;
                }
                current = current.next;
            }
            append(data);
        }
    }

    // Deletion from the beginning
    // Complexity: O(1)
    public void deleteFromBeginning() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Deletion from the end
    // Complexity: O(1)
    public void deleteFromEnd() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Deletion of a specific DLLNode by value
    // Complexity: O(n)
    public void deleteByValue(T data) {
        DLLNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                break;
            }
            current = current.next;
        }
    }

    // Searching for a specific value
    // Complexity: O(n)
    public boolean contains(T data) {
        DLLNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Traversing the list
    // Complexity: O(n)
    public void printList() {
        DLLNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    // Traversing the list
    // Complexity: O(n)
    public void printReverse() {
        DLLNode current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }


    // Reversing the list
    // Complexity: O(n)
    public void reverse() {
        DLLNode<T> current = head;
        DLLNode<T> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Get the size of the list
    // Complexity: O(1)
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.prepend(1);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.insertSorted(2);
        linkedList.printList();
        linkedList.deleteByValue(10);
        linkedList.printList();


//        linkedList.reverse();
//        linkedList.printReverse();
    }


}