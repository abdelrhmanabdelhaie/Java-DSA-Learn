package DS.linerDS.LinkedList.a$SingleLinkedList;

public class SingleLinkedList {

        //The First
        private Node head;

        // Init the LinkedList with null
        public SingleLinkedList() {}

        // Init the LinkedList with Head
        public SingleLinkedList(Node head) {
            this.head=head;
        }

        public void insertAtBeginning(int data) { //O(1)
            Node newNode = new Node(data);
            if (head != null) {
                newNode.next = head;
            }
            head=newNode;
        }

        public void insertAtEnd(int data) { //O(n)
            Node newNode = new Node(data);

            if (isEmpty()) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void insertAtIndex(int index, int data) { //O(n)
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index " + index + " is negative");
            }

            if (index == 0) {
                insertAtBeginning(data);
            } else {
                Node newNode = new Node(data);
                Node current = head;

                for (int i = 0; i < index - 1; i++) {
                    if (current == null) {
                        throw new IndexOutOfBoundsException("Index " + index + " is greater than the size of the list");
                    }
                    current = current.next;
                }

                newNode.next = current.next;
                current.next = newNode;
            }
        }

        public void deleteAtBeginning() { //O(1)
            if (head == null) {
                throw new RuntimeException("List is empty");
            }
            head = head.next;
        }

        public void deleteAtEnd() { //O(n)
            if (head == null) {
                throw new RuntimeException("List is empty");
            }

            if (head.next == null) {
                head = null;
                return;
            }

            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }

        public void deleteAtIndex(int index) { //O(n)
            if (index < 0 || head == null) {
                throw new IndexOutOfBoundsException("Index " + index + " is invalid");
            }

            if (index == 0) {
                deleteAtBeginning();
            } else {
                Node current = head;

                for (int i = 0; i < index - 1; i++) {
                    if (current == null) {
                        throw new IndexOutOfBoundsException("Index " + index + " is greater than the size of the list");
                    }
                    current = current.next;
                }

                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException("Index " + index + " is greater than the size of the list");
                }

                current.next = current.next.next;
            }
        }

        public boolean search(int data) { //O(n)
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        //To improve the search we can do:
        //1- swap the value with the previews and more and more to be closer to the head.
        //2- swap the value with the head
        public boolean searchElement(int element) {
            if (head == null) {
                return false;
            }
            if (head.data == element) {
                // If the element is found at the head, return true
                return true;
            }
            Node prev = null;
            Node current = head;
            // Traverse the list until the desired element or the end is reached
            while (current != null && current.data != element) {
                prev = current;
                current = current.next;
            }
            if (current == null) {
                return false; // Element not found
            }
            // Swap the found element with its previous node to move it closer to the head
            prev.next = current.next;
            current.next = head;
            head = current;
            return true;
        }

        public int accessPosition(int n) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == n) {
                    return current.data;
                }
                count++;
                current = current.next;
            }
            throw new IndexOutOfBoundsException("Index out of range");
        }


        public int size() { //O(n)
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
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

        public boolean isEmpty(){
            return head == null;
        }

        public static void main(String[] args) {
            SingleLinkedList linkedList = new SingleLinkedList();
            linkedList.insertAtBeginning(5);
            linkedList.insertAtEnd(10);
            linkedList.insertAtEnd(20);
            linkedList.display();


//
//            linkedList.insertAtEnd(10);
//            linkedList.insertAtEnd(20);
//            linkedList.insertAtEnd(30);
//            linkedList.insertAtEnd(40);
//
//            linkedList.display(); // Output: 10 20 30 40
//
//            linkedList.insertAtBeginning(5);
//            linkedList.display(); // Output: 5 10 20 30 40
//
//            linkedList.insertAtIndex(2, 15);
//            linkedList.display(); // Output: 5 10 15 20 30 40
//
//            linkedList.deleteAtEnd();
//            linkedList.display(); // Output: 5 10 15 20 30
//
//            linkedList.deleteAtIndex(2);
//            linkedList.display(); // Output: 5 10 20 30
//
//            System.out.println("Size of the list: " + linkedList.size()); // Output: 4
//
//            System.out.println("Is 10 present in the list? " + linkedList.search(10)); // Output: true
//            System.out.println("Is 25 present in the list? " + linkedList.search(25)); // Output: false
        }

        public void deleteFirst(){
            if (head == null) {
                throw new RuntimeException("List is empty");
            }
            head = head.next;
        }


        public void deleteIndex(int index){
            if(index < 0){
                return; //error
            }
            Node current=head;
            int count=1;
            while(count <index){
                if(current == null){
                    return; // error
                }
                current=current.next;
            }
            current.next=current.next.next;
        }

        public void deleteLast(){
            if (head == null){
                return;
            }else if(head.next == null){
                head =null;
            }else{
                Node current = head;
                if(current.next.next != null){
                    current = current.next;
                }
                current.next = null;
            }


        }
    }

