package task_2;
import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.println("Enter second string: ");
        String str2 = sc.nextLine();

        if(areAnagrams(str1, str2)){
            System.out.println("The strings are Anagrams");
        }
        else {
            System.out.println("The strings are not Anagrams");
        }
        sc.close();
    }

    public static boolean areAnagrams(String str1, String str2){
        str1.replaceAll("\\s", "").toLowerCase();
        str2.replaceAll("\\s", "").toLowerCase();

        if(str1.length() != str2.length()){
            return  false;
        }

        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();

        Arrays.sort(chArr1);
        Arrays.sort(chArr2);

        return Arrays.equals(chArr1, chArr2);
    }

}