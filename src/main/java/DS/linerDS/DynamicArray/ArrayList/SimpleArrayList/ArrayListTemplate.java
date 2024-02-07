package DS.linerDS.DynamicArray.ArrayList.SimpleArrayList;

import java.util.Collection;

public interface ArrayListTemplate {
    //Add
    void add(int data);
    void add(int data, int index);
    void addAll(Collection c);
    void addAll(int index, Collection c);
    //Get
    int get(int index);
    //Remove
    void remove();
    void remove(int index);
    //Size
    int size();
    int getCapacity();
    //Print
    void print();

}
