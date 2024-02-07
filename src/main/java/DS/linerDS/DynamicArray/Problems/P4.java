package DS.linerDS.DynamicArray.Problems;

import java.util.Collection;

//Problem #4: Deleting a position
//        ● Implement method int pop(int idx) in the vector class
//● It returns the deleted value
//        ● Remove this element from the array
//        ● Assume array is: 4 0 1 2 3
//        ● pop(2)
//        ○ Return value 1
//        ○ New array: 4 0 2 3
public class P4 {
    int []arr;
    int capacity;
    int size;

    public P4(int size){
        arr=new int[size*2];
        capacity = size*2;
        this.size = 0;
    }
    public void add(int data){
        if(size == capacity){
            expand();
        }
        arr[size]=data;
        size++;
    }
    public void add(int data[]) {
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    private void expand(){
        int temp[]=new int[capacity * 2];
        for (int i = 0; i < size; i++) {
            temp[i]=arr[i];
        }
        arr=temp;
        capacity *=2;
    }
    public  int pop(int index){
        if(index < 0 || index > size){
            return -1;
        }
        for(int i=index; i<size-1; i++){
            arr[i]=arr[i+1];
        }
        size--;
        return 1;
    }

    public void print(){
        for (int i = 0; i <size; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
