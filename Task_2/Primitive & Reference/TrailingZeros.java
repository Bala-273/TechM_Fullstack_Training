package task_2;


public class TrailingZeros {
    public static int countTrailingZeros(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 6;
        System.out.println("Trailing zeros in " + number + "! : " + countTrailingZeros(number));
    }
}