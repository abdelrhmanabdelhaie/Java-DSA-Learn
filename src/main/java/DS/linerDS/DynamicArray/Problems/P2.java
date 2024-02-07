package DS.linerDS.DynamicArray.Problems;
//Problem #2: Left rotation
//        ● Consider our Vector class. Add the member function: void left_rotate()
//        ● The function rotates the whole array 1 step to the left
//        ○ However, in this case, the leftmost element will be 'rotated' around to the back of the array!
//        ● Example
//        ● Assume the array content is: 0 1 2 3 4
//        ● After a left rotation, it will be: 1 2 3 4 0
//        ○ Notice how the 0 has 'rotated' to the tail of the array after applying left_rotate()
//        ● Ensure you avoid expanding the array's capacity
public class P2 {
    public static void main(String[] args) {
        int arr[]={0, 1, 2, 3, 4};

        print(leftRotation(arr));

    }
    private static int[] leftRotation(int arr[]){
        int size= arr.length;
        if (size == 0){
            return arr;
        }
        int temp= arr[0];
        for(int i=1;i<size;i++){
            arr[i-1]=arr[i];
        }
        arr[size-1]=temp;
        return arr;
    }

    private static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
