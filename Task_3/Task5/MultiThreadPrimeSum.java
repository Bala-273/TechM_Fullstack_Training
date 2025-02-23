package Task_5;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadPrimeSum {
    private static final int LIMIT = 100;
    private static final int NUM_THREADS = 4;
    private static int totalSum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        int rangeSize = LIMIT / NUM_THREADS;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * rangeSize + 1;
            int end = (i == NUM_THREADS - 1) ? LIMIT : (start + rangeSize - 1);
            Thread thread = new Thread(new PrimeSumTask(start, end));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of prime numbers up to " + LIMIT + " is: " + totalSum);
    }

    static class PrimeSumTask implements Runnable {
        private int start, end;

        public PrimeSumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    sum += i;
                }
            }

            synchronized (lock) {
                totalSum += sum;
            }
        }

        private boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
