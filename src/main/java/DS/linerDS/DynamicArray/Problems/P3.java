package DS.linerDS.DynamicArray.Problems;
//Problem #3: Right rotation with steps
//        ● Implement void right_rotate(int times)
//        ● This one applies the right rotation times time
//        ● Assume array content is: 0 1 2 3 4
//        ● right_rotate(2) ⇒ it will be: 3 4 0 1 2
//        ● The challenge: times can be up to: 2000000000
//        ● Your code should be efficient to some extent
public class P3 {
    public static void main(String[] args) {
        int arr[]={0, 1, 2, 3, 4};

        print(rightRotation(arr,2000000001));

    }
    private static int[] rightRotation(int arr[], int times){
        while(times > 0) {
            int size = arr.length;
            if (size == 0) {
                return arr;
            }
            int temp = arr[size - 1];
            for (int i = size - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
            times--;
        }
        return arr;
    }

    private static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
