package Feb13_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTask {
    public static void main(String[] args){
        HashSet<Integer> hashset1 = new HashSet<>();
        hashset1.add(7);hashset1.add(21);hashset1.add(35);hashset1.add(40);
        hashset1.add(50);hashset1.add(60);hashset1.add(70);hashset1.add(80);

        LinkedHashSet<String> linkedset1 = new LinkedHashSet<>();
        linkedset1.add("Oscar Issac");linkedset1.add("Tech_M");linkedset1.add("Breakdown");linkedset1.add("Leo Das");
        linkedset1.add("Car");linkedset1.add("Race");linkedset1.add("Trio");linkedset1.add("Clean");

        TreeSet<Float> treeset1 = new TreeSet<>();
        treeset1.add(10F);treeset1.add(21F);treeset1.add(27F);treeset1.add(77F);
        treeset1.add(107F);treeset1.add(20F);treeset1.add(18.27F);treeset1.add(3F);

        System.out.println("HashSet: "+hashset1);
        System.out.println("LinkedHashSet: "+linkedset1);
        System.out.println("TreeSet: "+treeset1);

        hashset1.remove(80);
        linkedset1.remove("Car");
        treeset1.remove(3F);

        System.out.println("\nHashSet after removing element: "+ hashset1);
        System.out.println("LinkedHashSet after removing element: "+ linkedset1);
        System.out.println("TreeSet after removing element: "+ treeset1);

        System.out.println("\nElements divisible by 7 in HashSet:");
        divisibleby7(hashset1);

        System.out.println("\nElements greater than length 5 in LinkedHashSet:");
        greaterthan5(linkedset1);

        System.out.println("\nElements greater than 20 in TreeSet:");
        greaterthan20(treeset1);
    }

    public static void divisibleby7(HashSet<Integer>hst){
        for(Integer num : hst){
            if(num%7==0){
                System.out.println(num);
            }
        }
    }

    public static void greaterthan5(LinkedHashSet<String>lhs){
        for(String str : lhs){
            if(str.length()>5){
                System.out.println(str);
            }
        }
    }

    public static void greaterthan20(TreeSet<Float>ts){
        for(Float num : ts){
            if(num>20){
                System.out.println(num);
            }
        }
    }
}
