package DS.linerDS.LinkedList.c$CircularLinkedList;


public class CircularLinkedList<T> {
    private Node<T> head;
    private int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public void remove(T element) {
        if (head == null) {
            return;
        }
        if (head.data.equals(element)) {
            if (head.next == head) {
                head = null;
            } else {
                Node<T> current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            size--;
            return;
        }
        Node<T> current = head;
        Node<T> prev = null;
        while (current.next != head) {
            if (current.data.equals(element)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
        if (current.data.equals(element)) {
            prev.next = head;
            size--;
        }
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
