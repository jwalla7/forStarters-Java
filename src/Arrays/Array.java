package Arrays;

public class Array {
    public static void main(String[] args) {

        int[] numArray = new int[]{1, 2, 3, 4, 5, 6, 8, 7, 9, 10};

        int sum = 0;
        for (int i : numArray) {
            System.out.print(sum += i);
        }
        System.out.println();
        System.out.println(sum);
        System.out.println();

        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] += numArray[i]);
        }

    }
}
