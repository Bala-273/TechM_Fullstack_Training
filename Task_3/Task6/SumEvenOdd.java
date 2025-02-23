package Task_6;

import java.util.List;
import java.util.Arrays;

public class SumEvenOdd {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        int evenSum = 0, oddSum = 0;

        for (T num : numbers) {
            int value = num.intValue();
            if (value % 2 == 0) {
                evenSum += value;
            } else {
                oddSum += value;
            }
        }

        System.out.println("Sum of Even Numbers: " + evenSum);
        System.out.println("Sum of Odd Numbers: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Integer List:");
        sumEvenOdd(intList);

    }
}
