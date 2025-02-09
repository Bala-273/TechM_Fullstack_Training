package task_2;


public class PrimitiveReference {
    static void modifyValues(int num, int[] arr) {
        num = 10;
        arr[0] = 107;
    }

    public static void main(String[] args) {
        int num = 7;
        int[] arr = {1, 2, 3};

        modifyValues(num, arr);

        System.out.println("Integer after method call: " + num);
        System.out.println("Array after method call: " + arr[0]);
    }
}
