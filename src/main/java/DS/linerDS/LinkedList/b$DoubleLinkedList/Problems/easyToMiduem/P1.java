package DS.linerDS.LinkedList.b$DoubleLinkedList.Problems.easyToMiduem;

import DS.linerDS.LinkedList.b$DoubleLinkedList.DLLNode;

//Problem #1: Delete all nodes with key
//        ● Implement: void delete_all_nodes_with_key(int value)
//        ● It will delete all nodes of the given key
//        ● 1, 2, 5, 4, 5, 4, 4 - key (5) ⇒ 1 2 4 4 4
public class P1 <T extends Comparable<T>>{

    DLLNode<T> head;
    DLLNode<T> tail;
    int size;

    public P1(){
        head = null;
        tail = null;
        size = 0;
    }

    public void append(int data){
        DLLNode newNode = new DLLNode(data);
        if(head == null){
            head=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
        }
        tail=newNode;
        size++;
    }
    public void delete_all_nodes_with_key(Integer value){
        DLLNode current=head;
        while(current != null){
            if(value.equals(current.data)){
                if(current.prev != null){
                    current.prev.next=current.next;
                }else{
                    head=current.next;
                }
                if(current.next != null){
                    current.next.prev = current.prev;
                }else{
                    tail=current.prev;
                }
                size--;
            }
            current=current.next;
        }
    }

    public void printList() {
        DLLNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        P1 p=new P1();
        p.append(1);
        p.append(2);
        p.append(5);
        p.append(4);
        p.append(5);
        p.append(4);
        p.append(4);
        p.printList();

        p.delete_all_nodes_with_key(5);
        p.printList();
    }
}
