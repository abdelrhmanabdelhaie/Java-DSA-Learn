package DS.linerDS.DynamicArray.Problems;
//Problem #1: Right rotation
//        ● Consider our Vector class. Add the member function: void right_rotate()
//        ● The function shifts every element 1 step towards the right.
//        ○ What about the rightmost element? It goes to the first idx
//        ● Example
//        ● Assume the array content is: 0 1 2 3 4
//        ● After a right rotation it will be: 4 0 1 2 3
//        ○ Notice how, in this case, the '4' has been rotated to the head of the array!
//        ● Ensure you avoid expanding the array's capacity
public class P1 {

    public static void main(String[] args) {
        int arr[]={0, 1, 2, 3, 4};

        print(rightRotation(arr));

    }
    private static int[] rightRotation(int arr[]){
        int size= arr.length;
        if (size == 0){
            return arr;
        }
        int temp= arr[size-1];
        for(int i=size-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=temp;
        return arr;
    }

    private static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
