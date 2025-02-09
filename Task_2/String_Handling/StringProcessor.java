package task_2;

public class StringProcessor {

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static String splitAndCapitalize(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String text = "hello everyone hello";
        String sub = "hello";
        String sentence = "learning fullstack is interesting";

        System.out.println("Reversed: " + reverseString("madam"));

        System.out.println("Occurrences of '" + sub + "': " + countOccurrences(text, sub));

        System.out.println("Capitalized: " + splitAndCapitalize(sentence));
    }
}
