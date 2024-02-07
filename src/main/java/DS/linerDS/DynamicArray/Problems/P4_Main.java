package DS.linerDS.DynamicArray.Problems;

public class P4_Main {
    public static void main(String[] args) {
        int array[]={0, 1, 2, 3, 4};
        P4 p4=new P4(array.length);
        p4.add(array);
        p4.pop(2);
        p4.print();
    }

}
