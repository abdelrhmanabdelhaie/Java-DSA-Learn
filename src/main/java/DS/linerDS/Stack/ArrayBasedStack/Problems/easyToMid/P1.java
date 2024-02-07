package DS.linerDS.Stack.ArrayBasedStack.Problems.easyToMid;

import java.util.EmptyStackException;

//Problem #1: Another Stack array design
//        ● One of the students implement his stack with the following design choices
//          ○ Instead of top, used int added_elements to represent number of added elements so far
//          ○ Instead of assert, push, pop, peek ⇒ returns bool to indicate success / failure
//          ○ If we push 10, 20, 30 in stack, the array content is: {30, 20, 10}
//        ■ That is, array[0] represents the top
//        ● Change the lecture stack code to reflect these changes
//        ● Discuss the time complexity of the methods
//          ○ Discuss how even minor design choices affect our data structure!
//        ● Change the main() function to reuse the new interface of the code
public class P1 {
    static final int  DEFAULT_CAPACITY = 10;
    int added_elements;
    int []array;

    public P1(){
        this(DEFAULT_CAPACITY);
    }
    private P1(int capacity){
        array =new int[capacity];
        added_elements = 0;
    }

    public void push(int data){ //O(n)
        if(added_elements == array.length){
            expand();//O(n)
        }
        if(added_elements > 0) {//O(n)
            for (int i = added_elements - 1; i >= 0; i--) {
                array[i + 1] = array[i];
            }
        }
        array[0]=data;
        added_elements++;
    }

    public int pop(){ //O(n)
        if(added_elements == 0){
            throw  new EmptyStackException();
        }
        int data = array[0];
        for(int i=1;i<added_elements;i++){ //O(n)
            array[i-1]=array[i];
        }
        added_elements--;
        array[added_elements]=0;
        return data;
    }

    private void expand(){
        int newCapacity = array.length * 2;
        int newArray[] =new int[newCapacity];
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
    }

    public void printArray(){
        for(int i =0; i<added_elements; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        P1 p1 =new P1();
        p1.push(10);
        p1.push(20);
        p1.push(30);
        p1.pop();
        p1.printArray();
    }

}
