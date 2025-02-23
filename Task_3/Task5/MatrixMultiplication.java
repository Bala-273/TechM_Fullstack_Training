package Task_5;

import java.util.Arrays;

public class MatrixMultiplication {
    private static final int ROWS_A = 3;
    private static final int COLS_A = 3;
    private static final int COLS_B = 3;
    
    private static int[][] A = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    private static int[][] B = {
        {9, 4, 3},
        {6, 8, 4},
        {1, 7, 7}
    };

    private static int[][] result = new int[ROWS_A][COLS_B];

    public static void main(String[] args) {
        Thread[] threads = new Thread[ROWS_A];

        for (int i = 0; i < ROWS_A; i++) {
            threads[i] = new Thread(new MultiplyRow(i));
            threads[i].start();
        }

        for (int i = 0; i < ROWS_A; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Result Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class MultiplyRow implements Runnable {
        private int row;

        public MultiplyRow(int row) {
            this.row = row;
        }

        @Override
        public void run() {
            for (int j = 0; j < COLS_B; j++) {
                result[row][j] = 0;
                for (int k = 0; k < COLS_A; k++) {
                    result[row][j] += A[row][k] * B[k][j];
                }
            }
        }
    }
}
