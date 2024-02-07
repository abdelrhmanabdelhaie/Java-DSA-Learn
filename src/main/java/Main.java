import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int NumberOfSwaps(int N, int A[]) {

        //this is default OUTPUT. You can change it.
        int result=0;

        for(int i=0;i<N-1;i++) {
            if(A[i]>A[i+1]){
                int temp = A[i];
                A[i]=A[i+1];
                A[i] = temp;

                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // INPUT [uncomment & modify if required]
        int N=sc.nextInt();
        int A[]=new int[N];
        for(int i=0;i<N;i++) {
            A[i]=sc.nextInt();
        }

        // OUTPUT [uncomment & modify if required]
        System.out.print(NumberOfSwaps(N, A));
        sc.close();
    }
}
