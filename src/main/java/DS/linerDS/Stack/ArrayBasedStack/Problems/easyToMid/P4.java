package DS.linerDS.Stack.ArrayBasedStack.Problems.easyToMid;

//Problem #4:Valid Parentheses
//        ● Develop:bool isValid(string str)
//        ● Valid:(),()(),(()()),{}{},(((()))),([]),()[]{},{[]}
//        ● Invalid:(],()),(][),(],([)]

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Scanner;

public class P4 {
    static final int DEFAULT_CAPACITY = 10;
    char arr[];
    int top;

    Map<Character, Character> map;

    public P4() {
        this(DEFAULT_CAPACITY);
    }

    private P4(int capacity) {
        arr = new char[capacity];
        top = -1;
        map = Map.of(')', '(', '}', '{', ']', '[');
    }

    public void push(char ch){ //O(1)
        if(top == arr.length-1){
            //expand
            char newArray[]=new char[arr.length*2];
            for (int i = 0; i < arr.length; i++) {
                newArray[i]=arr[i];
            }
            arr=newArray;
        }
        arr[++top]=ch;
    }

    public char pop() { //O(1)
        if (top == -1) {
            throw new EmptyStackException();
        }
        char ch = arr[top];
        arr[top] = ' ';
        top--;
        return ch;
    }
    public boolean isValid(String str){
        char[] chArr=str.toCharArray();
        for (char chr:chArr) {
            if(map.containsKey(chr)){
                char openFromMap=map.get(chr);
                char open=pop();
                if(openFromMap != open){
                    return false;
                }
            }else{
                push(chr);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str= sc.next();
        P4 p4=new P4();
        System.out.println(p4.isValid(str));

    }

}
