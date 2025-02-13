package Feb13_Collections;

import java.util.Map;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashMapTask {
    public static void main(String[] args) {

        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "one");
        hashtable.put(2, "two");
        hashtable.put(3, "three");
        System.out.println("Initial Hashtable: " + hashtable);
        hashtable.put(2, "For");
        hashtable.remove(1);
        System.out.println("Updated Hashtable: " + hashtable);

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "one");
        linkedHashMap.put(2, "two");
        linkedHashMap.put(3, "three");
        System.out.println("\nInitial LinkedHashMap: " + linkedHashMap);
        linkedHashMap.put(2, "For");
        linkedHashMap.remove(1);
        System.out.println("Updated LinkedHashMap: " + linkedHashMap);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        System.out.println("\nInitial TreeMap: " + treeMap);
        treeMap.put(2, "For");
        treeMap.remove(1);
        System.out.println("Updated TreeMap: " + treeMap);

        // Traversing Each Map
        System.out.println("\nHashtable Traversal:");
        traverseMap(hashtable);

        System.out.println("\nLinkedHashMap Traversal:");
        traverseMap(linkedHashMap);

        System.out.println("\nTreeMap Traversal:");
        traverseMap(treeMap);
    }

    public static <K, V> void traverseMap(Map<K, V> map) {
        for (Map.Entry<K, V> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }
}
