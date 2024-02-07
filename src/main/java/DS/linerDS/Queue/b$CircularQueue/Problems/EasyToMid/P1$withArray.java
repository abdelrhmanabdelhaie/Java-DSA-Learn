package DS.linerDS.Queue.b$CircularQueue.Problems.EasyToMid;

//Problem #1: Deque
//        ● Deque is a Double ended queue where you can add/remove from either rear or front. It is not FIFO anymore, but provides great flexibility
//        ● Change the circular queue to include
//        ○ void enqueue_rear(int value) [same old code]
//        ○ void enqueue_front(int value)
//        ○ int dequeue_front() [same old code]
//        ○ int dequeue_rear()
//        ● Front/Rear meanings shouldn’t change.
//        ● O(1) time complexity for all methods
public class P1$withArray {
    Node front;
    Node rear;
    int size;

    public P1$withArray() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue_rear(int value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            front = newNode;
        }else{
            rear.next = newNode;
            newNode.prev = rear;
        }
        rear = newNode;
        size++;
    }


    private boolean isEmpty() {
        return size == 0;
    }


    public static class Node {
        Node next;
        Node prev;
        int data;

        public Node(int data) {
            next = null;
            prev = null;
            this.data = data;
        }
    }

}
