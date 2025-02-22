package Task_1;
import java.util.Scanner;

class AlternativeElements {
    public static int[] copyAlternativeElements(int[] arr) {
        int n = (arr.length + 1)/2;
        int[] result = new int[n];
        for (int i = 0, j = 0; i < arr.length; i += 2, j++) {
            result[j] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = copyAlternativeElements(arr);

        System.out.print("Alternative elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
