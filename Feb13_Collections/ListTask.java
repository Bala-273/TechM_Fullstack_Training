package Feb13_Collections;
import java.util.*;

public class ListTask {
    public static void main(String[] args) {
        System.out.println("example of different list:");
        ArrayListExample arraylist=new ArrayListExample();
        LinkedListExample linkedlist=new LinkedListExample();
        VectorExample vector=new VectorExample();
        StackExample stack=new StackExample();
        arraylist.start();
        linkedlist.start();
        vector.start();
        stack.start();
    }
}

class ArrayListExample extends Thread {
    public void run() {

        List<String> arraylist1 = new ArrayList<>(Arrays.asList("Hello", "World", "Java"));

        System.out.println("Is Arraylist1 empty? " + arraylist1.isEmpty());
        System.out.println("ArrayList1: " + arraylist1);
        System.out.println("Number of elements in the list: " + arraylist1.size());
        arraylist1.add("Hola");
        System.out.println("After adding one element:");
        System.out.println("ArrayList1: " + arraylist1);
        System.out.println("Number of elements in the list: " + arraylist1.size());
        System.out.println("Is 79 available in the list:" + arraylist1.contains(49));
    }
}
class LinkedListExample extends Thread {
    public void run() {

        List<Integer> linkedlist1 = new LinkedList<>();
        linkedlist1.add(70);
        linkedlist1.add(90);
        linkedlist1.add(88);
        linkedlist1.add(87);
        linkedlist1.add(107);

        System.out.println("Is Linkedlist1 empty? " + linkedlist1.isEmpty());
        System.out.println("LinkedList1: " + linkedlist1);
        System.out.println("Number of elements in the list: " + linkedlist1.size());
        linkedlist1.add(12);
        System.out.println("After adding one element:");
        System.out.println("LinkedList1: " + linkedlist1);
        System.out.println("Number of elements in the list: " + linkedlist1.size());
        System.out.println("Is 107 available in the list:" + linkedlist1.contains(107));
    }
}
class VectorExample extends Thread {
    public void run() {

        List<Integer> vectorlist1 = new Vector<>(Arrays.asList(5,9,67,89,69,9));

        System.out.println("Is Vectorlist1 empty? " + vectorlist1.isEmpty());
        System.out.println("VectorList1: " + vectorlist1);
        System.out.println("Number of elements in the list: " + vectorlist1.size());
        vectorlist1.add(12);
        System.out.println("After adding one element:");
        System.out.println("VectorList1: " + vectorlist1);
        System.out.println("Number of elements in the list: " + vectorlist1.size());
        System.out.println("Is 56 available in the list:" + vectorlist1.contains(56));
    }
}
class StackExample extends Thread {
    public void run() {

        List<Integer> stack1 = new Stack<>();
        stack1.add(1);
        stack1.add(8);
        stack1.add(90);
        stack1.add(99);

        System.out.println("Is Stack1 empty? " + stack1.isEmpty());
        System.out.println("Stack1: " + stack1);
        System.out.println("Number of elements in the list: " + stack1.size());
        stack1.add(12);
        System.out.println("After adding one element:");
        System.out.println("Stack1: " + stack1);
        System.out.println("The number of elements in the list: " + stack1.size());
        System.out.println("Is 66 available in the list:" + stack1.contains(66));

    }
}