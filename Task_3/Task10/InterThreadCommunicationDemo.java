package multithreadingdemo;

class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("Going to withdraw $" + amount);

        while (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.amount -= amount;
        System.out.println("Withdrawal of $" + amount + " completed. Remaining balance: $" + this.amount);
    }

    synchronized void deposit(int amount) {
        System.out.println("Going to deposit $" + amount);
        this.amount += amount;
        System.out.println("Deposit of $" + amount + " completed. New balance: $" + this.amount);
        notify();
    }
}

public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
        Customer c = new Customer();

        // Withdrawal thread
        new Thread(() -> c.withdraw(15000)).start();

        // Delay to simulate real-life deposit timing
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Deposit thread
        new Thread(() -> c.deposit(10000)).start();
    }
}
