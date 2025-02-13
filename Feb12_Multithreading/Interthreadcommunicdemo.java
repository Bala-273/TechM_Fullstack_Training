package multithreadingdemo;

class Customer{
    int amount=10000;

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw..." + amount);

        if(this.amount<amount){
            System.out.println("Less balance; waiting for deposit...");

            try{
                wait();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        this.amount-=amount;
        System.out.println("withdrawal of $" +this.amount+ "completed...");
    }
    synchronized void deposit(int amount){
        System.out.println("going to deposit..." + amount);
        this.amount+=amount;
        System.out.println("deposit of $" +this.amount+ "completed... ");
        notify();
    }
}
class Interthreadcommunicdemo {
    public static void main(String args[]){
        Customer c=new Customer();
        new Thread(){
            public void run(){c.withdraw(15000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();

    }
}

