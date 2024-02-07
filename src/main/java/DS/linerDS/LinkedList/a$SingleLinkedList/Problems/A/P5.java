package DS.linerDS.LinkedList.a$SingleLinkedList.Problems.A;

import DS.linerDS.LinkedList.a$SingleLinkedList.Problems.Node;

//Problem #5: Is Same list’s data?
//        ● Develop function to check if lists are data-equal:
//          ○ Same length - each node and its corresponding one has same value
//          ○ bool is_same(const LinkedList &other)
//        ● Provide 2 codes
//          ○ One code assumes a variable length is maintained That tells us how many nodes so far
//        ■ E.g. in each insert, length is increased
//          ○ Another that doesn’t use it and don’t compute length
public class P5 {

    Node head;
    int size;

    public P5(){}
    public P5(Node node){
        head=node;
    }

    private boolean isEmpty(){
        return head==null;
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
        size++;
    }

    private boolean isSameSize(P5 secondList){
        return size==secondList.size;
    }

    public boolean isSame(P5 secondList){
        if(!isSameSize(secondList)){
            return false;
        }else{
            Node firstCurrent=head;
            Node secondCurrent=secondList.head;
            int count=1;
            while(count<=size){
                if(firstCurrent.data !=  secondCurrent.data){
                    return false;
                }
                firstCurrent=firstCurrent.next;
                secondCurrent=secondCurrent.next;
                count++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        P5 p1=new P5();
        P5 p2=new P5();
        p1.addLast(1);
        p1.addLast(2);
        p1.addLast(3);
        p2.addLast(1);
        p2.addLast(2);
        p2.addLast(3);

        System.out.println(p1.isSame(p2));


    }

}
