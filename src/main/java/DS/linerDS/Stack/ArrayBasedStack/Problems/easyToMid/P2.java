package DS.linerDS.Stack.ArrayBasedStack.Problems.easyToMid;

//Problem #2: Reverse subwords
//        ● Develop: string reverse_subwords(string line)
//        ● It takes a string of spaces, e.g. "abc d efg xy"
//        ● Then reverse each subword ⇒ “cba d gfe yx“
//        ● Find a stack-based idea
//          abc -> cba
public class P2 {
    static final int  DEFAULT_CAPACITY = 10;
    int top;
    char []array;

    public P2(){
        this(DEFAULT_CAPACITY);
    }
    private P2(int capacity){
        array =new char[capacity];
        top = -1;
    }

    public void push(String ch){ //O(n)
        if(top + ch.length() -1 == array.length){
            expand();//O(n)
        }
        for (int i = ch.length() - 1; i >= 0; i--) {
            array[++top] = ch.toCharArray()[i];
        }
        array[++top] =' ';
    }

//    public char pop(){ //O(n)
//        if(added_elements == 0){
//            throw  new EmptyStackException();
//        }
//        char data = array[0];
//        for(int i=1;i<added_elements;i++){ //O(n)
//            array[i-1]=array[i];
//        }
//        added_elements--;
//        array[added_elements]=0;
//        return data;
//    }

    private void expand(){
        int newCapacity = array.length * 2;
        char newArray[] =new char[newCapacity];
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
    }

    public void printArray(){
        for(int i =0; i<=top; i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String arrStr[]="abc d efg xy".split(" ");
//        "abc d efg xy" -> “cba d gfe yx“
        P2 p2 =new P2();
        for(String str: arrStr){
            System.out.print(str+" ");
            p2.push(str);
        }
        System.out.println();
        p2.printArray();
    }
}
