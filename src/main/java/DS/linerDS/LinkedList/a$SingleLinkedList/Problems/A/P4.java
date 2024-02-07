package DS.linerDS.LinkedList.a$SingleLinkedList.Problems.A;

//Problem #4: Get nth from back
//        ● Now implement: Node* get_nth_back(int n)
//        ● Given 1-based position, find it from the back
//        ● E..g. if list is: 1 2 3 4 5 6
//        ● get_nth_back(1) should point to node with value 6

import DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Node;

//To solve this we must have the size of the SingleLinkedList
public class P4 {

    Node head;
    int size;

    public P4(){}
    public P4(Node node){
        head=node;
    }

    private boolean isEmpty(){
        return head==null;
    }
    public void addFirst(int data){
        Node node = new Node(data);
        if(!isEmpty()){
            node.next = head;
        }
        head=node;
        size++;
    }
    public void addIndex(int index,int data){
        if(index < 0){
            return;
        }
        if(index == 0){
            addFirst(data);
        }else{
            Node newNode=new Node(data);
            Node current=head;
            int count=0;

            while(count<index-1){
                if(current == null){
                    return;
                }
                current=current.next;
            }
            newNode.next=current.next;
            current.next=newNode;
        }
        size++;
    }


    public void addLast(int data){
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
        size++;
    }


    //1-Base
    //Formula: (Size - index +1)
    public int getBackByIndex(int index){
        if(index<0 || index>size){
            return -1;
        }
        return getByIndex(size - index +1);
    }

    //1-Base
    public int getByIndex(int index){
        if(index<1 || index>size){
            return -1;
        }
        Node current=head;
        int count=1;
        while(current != null){
            if(count == index){
                return current.data;
            }
            current = current.next;
            count++;
        }
        return -1;
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


    public static void main(String[] args) {
        P4 p=new P4();
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
        p.addLast(4);
        p.addLast(5);
        System.out.println("Size: "+p.size);
        p.display();

        System.out.println(p.getBackByIndex(5));


    }



    }
