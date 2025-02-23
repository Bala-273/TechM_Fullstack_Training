package Task_5;

public class BasicThread extends Thread {
    public void run() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        BasicThread thread = new BasicThread();
        thread.start();
    }
}
