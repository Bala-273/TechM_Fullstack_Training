package multithreadingdemo;

class ThreadOne extends Thread {
    public void run() {
        System.out.println("B_Task1 from ThreadOne");
        System.out.println("B_Task1 from ThreadOne");
        System.out.println("B_Task1 from ThreadOne");
    }
}

class ThreadTwo implements Runnable {
    public void run() {
        try {
            System.out.println("B_Task1 From ThreadTwo");
            System.out.println("B_Task1 From ThreadTwo");
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in ThreadTwo: " + e.getMessage());
        }
    }
}

class ThreadThree extends Thread {
    public void run() {
        System.out.println("From ThreadThree");
        System.out.println("From ThreadThree");
        System.out.println("From ThreadThree");
        System.out.println("From ThreadThree");
        System.out.println("From ThreadThree");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

        ThreadOne t1 = new ThreadOne();
        t1.start();

        Thread thread2 = new Thread(new ThreadTwo());
        Thread thread3 = new Thread(new ThreadTwo());

        thread2.start();
        thread3.start();

        ThreadTwo t2 = new ThreadTwo();
        t2.run(); // This runs in the main thread, NOT a separate thread

        new ThreadThree().start();
        new ThreadThree().start();
        new ThreadThree().start();
    }
}
