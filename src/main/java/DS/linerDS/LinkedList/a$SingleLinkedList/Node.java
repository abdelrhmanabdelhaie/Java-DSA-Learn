package DS.linerDS.LinkedList.a$SingleLinkedList;

import lombok.Data;

@Data
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
