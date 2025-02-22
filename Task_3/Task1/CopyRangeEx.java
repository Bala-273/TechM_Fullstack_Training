package Task_1;

import java.util.Arrays;
import java.util.Scanner;

public class CopyRangeEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end index: ");
        int end = scanner.nextInt();

        if (start < 0 || end > size || start >= end) {
            System.out.println("Invalid range! Start should be >= 0, End should be <= " + size + " and Start < End.");
        } else {
            int[] copiedArr = Arrays.copyOfRange(arr, start, end);
            System.out.println("Copied Array: " + Arrays.toString(copiedArr));
        }

        scanner.close();
    }
}

