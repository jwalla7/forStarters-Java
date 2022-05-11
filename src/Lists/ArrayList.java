package Lists;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class ArrayList <T> {

//    Class Variables
    public static final int INITIAL_CAPACITY = 9;
    private T[] backingArray;
    private int size;

//    Constructor
    public ArrayList () {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

//    Getters
    public T[] getBackingArray () {
        return backingArray;
    }

    public T getValueByIndex (int index) {
        for (int i = 0; i <backingArray.length; i++) {
            if (backingArray[i] == backingArray[index]) {
                return backingArray[i];
            }
        }
        return null;
    }

    public int getSize () {
        return size;
    }

//    METHODS (INSERTION)
//      Insert Target At Front
    public void addToFront (T data) {
//        Basic Edge Case: If passed data is null
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        System.out.println("backingArray.length: " + backingArray.length);
        System.out.println("size: " + size);
//       If array is full to capacity
        if (size == backingArray.length) {
//            Create new array twice the capacity of original array
            T[] newArr = (T[]) new Object[2 * backingArray.length];
            newArr[0] = (T) data;
            System.out.println("New backingArray.length: " + newArr.length);
            System.out.println(Arrays.toString(newArr));
//            Copies old array to newArr after newArr[0] index
            for (int i = 0; i < size; i++) {
                newArr[i + 1] = backingArray[i];
            }
//            Assign newArr values to backingArray
            backingArray = newArr;
        } else {
//           [i] index is size + 1
            for (int i = size; i > 0; i--) {
                backingArray[i] = backingArray[i - 1];
            }
//            Add data to first index
            backingArray[0] = data;
        }
//        Increase size to reflect newly added data
        size++;
        System.out.println("added to front " + backingArray[0] + " <- ");
        System.out.println("new size: " + size);
    }
//            Insert Target At Index
    public void addAtIndex (int index, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        System.out.println("backingArray.length: " + backingArray.length);
        System.out.println("size: " + size);

        if (size == backingArray.length) {
            T[] newBackingArray = (T[]) new Object[backingArray.length * 2];
            System.out.println("newBackingArray capacity: " + newBackingArray.length);
            System.out.println(Arrays.toString(newBackingArray));

            for (int i = 0; i < size; i++) {
                newBackingArray[i] = backingArray[i];
            }
            backingArray = newBackingArray;
        } else if (index < size) {
            for (int i = size; i > index; i--) {
                backingArray[i] = backingArray[i - 1];
            }
            backingArray[index] = (T) data;
        } else {
            backingArray[index] = (T) data;
        }
        size++;
        System.out.println("added at index " +  index + " the value " + (backingArray[index])  + " -> ");
        System.out.println("new size: " + size);
        System.out.println(Arrays.toString(backingArray));
    }
//        Insert Target At Back
    public void addToBack (T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size == backingArray.length) {
            T[] newBackingArray = (T[]) new Object[2 * backingArray.length];

            for (int i = 0; i < size; i++) {
                newBackingArray[i] = backingArray[i];
            }
            newBackingArray[size] = (T) data;
            backingArray = newBackingArray;
        } else {
            backingArray[size] = (T) data;
        }
        size++;
        System.out.println("added to back " + (backingArray[size - 1])  + " -> ");
        System.out.println("new size: " + size);
    }
//    METHODS (DELETION)
//        Delete Target From Front
    public T removeFromFront () {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T removedElement = backingArray[0];
        for (int i = 0; i < size - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray[size - 1] = null;
        size--;

        return removedElement;
    }
//        Delete Target From Back
    public T removeFromBack () {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T removedElement = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;

        return removedElement;
    }

//       Main Method
    public static void main(String[] args) {
//        Create New List with Type -> String
        ArrayList stringList = new ArrayList<String>();
//        Add String to Front
        System.out.println("===============  String ArrayList  ===============");
        System.out.println("Array List Capacity = 9 -> Initial Values = Null");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();

        stringList.addToFront("C");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();
        stringList.addToFront("B");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();
        stringList.addToFront("A");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();
//        Add String At Index
        stringList.addAtIndex(2, "CC");
        System.out.println();
        stringList.addAtIndex(4, "CC");
        System.out.println();
//        Add String to Back
        stringList.addToBack("D");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();
        stringList.addToBack("E");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();
        stringList.addToBack("F");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();
        stringList.addToBack("G");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        System.out.println();

//        Create New List with Type -> int
        ArrayList intList = new ArrayList<Integer>();
//        Add Integer to Front
        System.out.println("===============  Integer ArrayList  ===============");
        System.out.println("Array List Capacity = 9 -> Initial Values = Null");
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();

        intList.addToFront(10);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(9);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(8);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(7);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(6);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(5);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(4);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(3);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(2);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToFront(1);
        System.out.println("Assign old array to New backingArray " + Arrays.toString(new int[]{intList.getBackingArray().length}));
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();

//        Add At Index
        intList.addAtIndex(8, 88);
        System.out.println();
        intList.addAtIndex(7, 88);
        System.out.println();
        intList.addAtIndex(0, 0);
        System.out.println();

//        Add Integer to Back
        intList.addToBack(11);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToBack(12);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToBack(13);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToBack(14);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        System.out.println();
        intList.addToBack(15);
        System.out.println(Arrays.toString(intList.getBackingArray()));

    }
}
