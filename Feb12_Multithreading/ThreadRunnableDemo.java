package Threadrunnable;

class ThreadRunnableOne implements Runnable{
    public void run(){
        System.out.println("From ThreadRunnableOne");
        System.out.println("From ThreadRunnableOne");
    }
}

class ThreadRunnableTwo implements Runnable{
    public void run(){
        System.out.println("From ThreadRunnableTwo");
        System.out.println("From ThreadRunnableTwo");
        System.out.println("From ThreadRunnableTwo");
    }
}

public class ThreadRunnableDemo {
    public static void main(String[] args){
        Thread t1 = new Thread(new ThreadRunnableOne());
        Thread t2 = new Thread(new ThreadRunnableTwo());
        Thread t3 = new Thread(new ThreadRunnableTwo());

        t1.start();
        t2.start();
        t3.run();
    }
}
