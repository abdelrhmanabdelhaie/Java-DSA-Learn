package DS.linerDS.LinkedList.a$SingleLinkedList.Problems.A;

import DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Node;

//Problem #1: Destructor
//        Our code used to create dynamic data, but never released
//        ● This creates a memory leak
//        ● Implement destructor: ~LinkedList()
//        ● It should free all the created nodes
public class P1 {
    Node head;

    public P1(){

    }

    public P1(Node node){
        this.head=node;
    }

    public void destroy(){ //O(1)
        // Set the head to null to release the reference
        head=null;
    }

    public static void main(String[] args) {
        P1 linkedList = new P1(new Node(10));
        linkedList.display(); // 10

        linkedList.destroy(); // Destroy
        linkedList.display(); // .....

    }






    public void display() { //O(n)
        if(head == null){
            System.out.println("LinkedList is empty...");
        }
       Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
