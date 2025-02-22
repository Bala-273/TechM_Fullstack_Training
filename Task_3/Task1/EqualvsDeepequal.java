package Task_1;

import java.util.Arrays;
import java.util.Objects;

public class EqualvsDeepequal {
    public static void main(String[] args) {
        String[] arr1 = {"Java", "Python", "C++"};
        String[] arr2 = {"Java", "Python", "C++"};
        String[] arr3 = arr1;

        System.out.println("arr1: "+Arrays.toString(arr1));
        System.out.println("arr2: "+Arrays.toString(arr2));
        System.out.println("arr3: "+Arrays.toString(arr3));


        System.out.println("Using equals() comparing arr1 & arr2: " + Objects.equals(arr1, arr2));
        System.out.println("Using equlas() comparing arr1 & arr3: " + Objects.equals(arr1,arr3));
        System.out.println("Using deepEquals() comparing arr1 & arr2: " + Arrays.deepEquals(arr1, arr2));
        System.out.println("Using deepEquals() comparing arr1 & arr3: " + Arrays.deepEquals(arr1, arr3));
        }
    }

