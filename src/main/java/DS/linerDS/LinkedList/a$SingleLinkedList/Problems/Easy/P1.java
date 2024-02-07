package DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Easy;

import DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Node;

//Problem #1: Delete with key
//        ● Given a list, delete the first node with the given key value
//        ● E.g. {1, 2, 3, 4, 2, 6}, key = 2 ⇒ {1, 3, 4, 2, 6}
//        ● void delete_node_with_key(int value)
public class P1 {
    Node head;
    public P1(){}
    public P1(Node node){
        this.head=node;
    }


    public void add(int data){
        addLast(data);
    }
    private void addLast(int data){
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next=node;
        }
    }
    private boolean isEmpty(){
        return head==null;
    }

    public void deleteWithKey(int key){
        if(key < 0){
            return;
        }
        if(key == 1){
            head=head.next;
        }

        Node current=head;
        int count=1;
        while(count <key-1){
            if(current.next == null){
                return;
            }
            current = current.next;
        }
        if(current.next == null|| current.next.next == null){
            return;
        }
        current.next = current.next.next;
    }



    public static void main(String[] args) {
        P1 p1=new P1();
        p1.addLast(1);
        p1.addLast(2);
        p1.addLast(3);
        p1.addLast(4);
        p1.deleteWithKey(2);

        p1.display();


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
