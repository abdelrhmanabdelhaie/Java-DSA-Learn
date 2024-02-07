package DS.linerDS.LinkedList.b$DoubleLinkedList;

public class DLLNode <T> {
    public T data;
    public DLLNode<T> prev;
    public DLLNode<T> next;

    public DLLNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

