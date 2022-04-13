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

//    METHODS
//      Insert Target At Front
    public void addToFront (T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        int capacity = backingArray.length;

        if (size == capacity) {
            T[] newArr = (T[]) new Object[2 * capacity];
            newArr[0] = (T) data;

            for (int i = 0; i < size; i++) {
                newArr[i + 1] = backingArray[i];
            }
            backingArray = newArr;
        } else {
            for (int i = size; i > 0; i--) {
                backingArray[i] = backingArray[i - 1];
            }
            backingArray[0] = (T) data;
        }
        size++;
        System.out.println("added to front " + backingArray[0] + " <- ");
    }
//        Insert Target At Back
    public void addToBack (T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        int capacity = backingArray.length;
        if (size == capacity) {
            T[] newArr = (T[]) new Object[2 * capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = backingArray[i];
            }
            newArr[size] = (T) data;
            backingArray = newArr;
        } else {
            backingArray[size] = (T) data;
        }
        size++;
        System.out.println("added to back " + (backingArray[size - 1])  + " -> ");
    }
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

//     Getters
    public T[] getBackingArray () {
        return backingArray;
    }

    public int size () {
        return size;
    }
//       Main Method
    public static void main(String[] args) {
//        Create New List with Type -> String
        ArrayList stringList = new ArrayList<String>();
//        Add String to Front
        System.out.println("Array List Capacity = 9 -> Initial Values = Null");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToBack("E");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToFront("D");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToFront("C");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToFront("B");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToFront("A");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
//        Add Integer to Back
        stringList.addToBack("F");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToBack("G");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToBack("H");
        System.out.println(Arrays.toString(stringList.getBackingArray()));
        stringList.addToBack("I");
        System.out.println(Arrays.toString(stringList.getBackingArray()));

//        Create New List with Type -> int
        ArrayList intList = new ArrayList<Integer>();
//        Add Integer to Front
        System.out.println("Array List Capacity = 9 -> Initial Values = Null");
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToFront(5);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToFront(4);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToFront(3);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToFront(2);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToFront(1);
        System.out.println(Arrays.toString(intList.getBackingArray()));
//        Add Integer to Back
        intList.addToBack(6);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToBack(7);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToBack(8);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToBack(9);
        System.out.println(Arrays.toString(intList.getBackingArray()));
        intList.addToBack(10);
        System.out.println(Arrays.toString(intList.getBackingArray()));


    }
}
