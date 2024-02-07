package DS.linerDS.LinkedList.a$SingleLinkedList.Problems.A;

import DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Node;

//Problem #2: Insert front
//        ● We want to be able to insert front as following
public class P2 {

    Node head;

    public P2(){

    }

    public P2(Node node){
        this.head=node;
    }

    public void insertFront(int data){
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head=newNode;
    }
}
