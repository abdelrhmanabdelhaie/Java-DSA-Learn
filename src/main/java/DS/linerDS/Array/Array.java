package DS.linerDS.Array;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Array {
    public static void main(String[] args) {
        int [] arr =new int[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;

        //print array
        for (int x:arr) {
            System.out.println(x);
        }


        //arr[3]=4;  ->>>> Index 3 out of bounds for length 3
        //So we need Dynamic array to add and delete from the array without consideration of size
        //Well learn about arrayList in next


ArrayList ass=new ArrayList();
        ass.add(1,2);

        List x=new Vector();


    }
}
