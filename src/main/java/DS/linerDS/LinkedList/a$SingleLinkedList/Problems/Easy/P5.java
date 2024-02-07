package DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Easy;

import DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Node;

//Problem #5: Insert to be sorted
//        ● Implement: void insert_sorted(int value)
//        ● It will always insert the value in position so that list is sorted
//        ● Let’s insert values: 10 2 30 4 1
//        ● insert(10) ⇒ {10}
//        ● insert(2) ⇒ {2, 10}
//        ● insert(30) ⇒ {2, 10, 30}
//        ● insert(4) ⇒ {2, 4, 10, 30}
//        ● insert(1) ⇒ {1, 2, 4, 10, 30}
public class P5 {
    Node head;

    public P5(){

    }

    public P5(Node node){
        this.head=node;
    }
}
