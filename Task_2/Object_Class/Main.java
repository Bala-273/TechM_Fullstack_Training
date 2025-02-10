package task_2;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Amal Davis", 20);
        User user2 = new User("Amal Davis", 20);
        SecondUser secondUser1 = new SecondUser("Stark", 17);
        SecondUser secondUser2 = new SecondUser("Stark", 17);

        System.out.println("User 1: " + user1);
        System.out.println("User 2: " + user2);
        System.out.println("SecondUser 1: " + secondUser1);
        System.out.println("SecondUser 2: " + secondUser2);

        System.out.println("\nComparing user1 and user2 using equals(): " + user1.equals(user2));
        System.out.println("Comparing secondUser1 and secondUser2 using equals(): " + secondUser1.equals(secondUser2));

        System.out.println("\nComparing hashcodes of user1 and user2: " + (user1.hashCode() == user2.hashCode()));
        System.out.println("Comparing hashcodes of secondUser1 and secondUser2: " + (secondUser1.hashCode() == secondUser2.hashCode()));
    }
}