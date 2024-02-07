package DS.linerDS.Stack.ArrayBasedStack.Problems.easyToMid;

import java.util.Scanner;

//Problem #3: Reverse a number using stack
//        ● Implement a method that takes number >= 0 and reverse its digits using a stack
//        ● int reverse_num(int num)
//        ● E.g. Input: 1234, Output: 4321
//        ● Find a stack-based idea
public class P3 {
    static final int  DEFAULT_CAPACITY = 10;
    int top;
    int []array;

    public P3(){
        this(DEFAULT_CAPACITY);
    }
    private P3(int capacity){
        array =new int[capacity];
        top = -1;
    }
    public void reverse_num(int num){
        //1234 -> 4321
        while(num > 0){
            push(num % 10);
            num /=10;
        }
    }

    public void push(int data){ //O(n)
        if(top == array.length){
            expand();//O(n)
        }
        array[++top]=data;
    }

    private void expand(){
        int newCapacity = array.length * 2;
        int newArray[] =new int[newCapacity];
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
    }

    public void printArray(){
        for(int i =0; i<=top; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num = sc.nextInt();

        P3 p3 =new P3();
        p3.reverse_num(num);

        p3.printArray();
    }

}
