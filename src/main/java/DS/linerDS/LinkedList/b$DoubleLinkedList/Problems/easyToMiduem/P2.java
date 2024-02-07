package DS.linerDS.LinkedList.b$DoubleLinkedList.Problems.easyToMiduem;

import DS.linerDS.LinkedList.b$DoubleLinkedList.DLLNode;

//Problem #2: Delete even positions
//        ● Given a list, delete all nodes at even positions (2, 4, 6, etc)
//        ● E.g. {1, 2, 3, 4, 10} ⇒ {1, 3, 10}
//        ● E.g. {1, 2, 3, 4, 5, 6} ⇒ {1, 3, 5}
//        ● Note: positions NOT values
//        ● void delete_even_positions()
public class P2<T extends Comparable<T>>{

    DLLNode<T> head;
    DLLNode<T> tail;
    int size;

    public P2(){
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
    public void delete_even_positions(){
        DLLNode current=head;
        int index=1;
        while(current != null){
            if(index % 2 == 0){
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
            }
            index++;
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
        P2 p=new P2();
        p.append(1);
        p.append(2);
        p.append(3);
        p.append(4);
        p.append(5);
        p.append(6);
        p.append(7);
        p.append(8);
        p.append(9);
        p.append(10);
        p.printList();

        p.delete_even_positions();
        p.printList();
    }
}
