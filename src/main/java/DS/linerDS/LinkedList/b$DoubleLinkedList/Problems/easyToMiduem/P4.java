package DS.linerDS.LinkedList.b$DoubleLinkedList.Problems.easyToMiduem;

import DS.linerDS.LinkedList.b$DoubleLinkedList.DLLNode;

//Problem #4: Is Palindrome
//        ● A palindrome number is read the same backward as forward (1221, 131, 0)
//        ● Implement: bool is_palindrome()
//        ● It returns true if the current linked list is palindrome
//        ● {1, 2, 2, 1} ⇒ True
public class P4 <T extends Comparable<T>>{

    DLLNode<T> head;
    DLLNode<T> tail;
    int size;

    public P4(){
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
    public void printList() {
        DLLNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public boolean is_palindrome(){
        int times = size/2;
        DLLNode currentHead=head;
        DLLNode currentTail=tail;

        while(times != 0){
           if(!currentHead.data.equals(currentTail.data)){
                return false;
           }
           currentHead=currentHead.next;
           currentTail=currentTail.prev;
            times--;
        }
        return true;
    }

    public static void main(String[] args) {
        P4 p=new P4();
        p.append(1);
        p.append(2);
        p.printList();

        System.out.println(p.is_palindrome());
    }
}
