package DS.linerDS.LinkedList.b$DoubleLinkedList.Problems.mediumToHard.mediumToHard;

import DS.linerDS.LinkedList.b$DoubleLinkedList.DLLNode;

//Problem #1: Find the middle
//        ● Given a linked list, we would like to find its middle value
//          ○ In odd length list, e.g. {1, 2, 3, 4, 5}, the middle value is 3
//          ○ In even length list, e.g. {1, 2, 3, 4, 5, 6}, the middle values are {3, 4}. We need 2nd one {4}
//        ● Provide 2 implementations, but consider:
//          ○ You can’t iterate on the list more than once!
//          ○ Don’t use the length variable!
//        ● First: Use your doubly linked list
//        ● Second: Solve it only with the next pointer. Don’t use the previous
//          ○ ~5 lines of code.
public class P1 {

   static ArrayList al =new ArrayList();
    static DoublyLinkedList dll =new DoublyLinkedList();

    static class ArrayList{
        int arr[];
        int size;
        int capacity;
        public ArrayList(){
            arr=new int[10];
            capacity=10;
            size=0;
        }
        public void add(int data) {
            if(size == capacity){
                //expand & move
                int newArray[]=new int[capacity*2];
                for(int i=0;i<size;i++){
                    newArray[i]=arr[i];
                }
                arr=newArray;
            }
            arr[size]=data;
            size++;
        }

        public int getMeddle(){
            return arr[size/2];
        }
    }

  static  class DoublyLinkedList {
        DLLNode<Integer> head;
        DLLNode<Integer> tail;
        public void append(int data) {
            DLLNode newNode = new DLLNode(data);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }
            tail = newNode;
            al.add(data);
        }

        public Integer getTheMiddle(){
            DLLNode<Integer> currentHead =head;
            DLLNode<Integer> currentTail=tail;

            while(!currentHead.equals(currentTail) && !currentHead.next.equals(currentTail)){
                currentHead = currentHead.next;
                currentTail = currentTail.prev;
            }
            return currentHead.data;
        }


    }

    public static void main(String[] args) {

        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(6);

        //S1= Copy data into array list and use size/2 to get the middle by O(1)
        System.out.println(al.getMeddle());

        //S2= Move head and tail foreword and backward to meet and return the middle
        System.out.println(dll.getTheMiddle());

        //S3= Use two pointer from the head one fast and second slow
        //the first one move every one step
        //The second one move every two steps
        //When the first reach 10 the second stand on 5


    }
}
