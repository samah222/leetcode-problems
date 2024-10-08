import java.util.Map;
import java.util.HashMap;

public class Anagram {

    public static boolean isAnagramUsingMaps(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        // Convert both strings to lower case to handle case insensitivity
        a = a.toLowerCase();
        b = b.toLowerCase();

        // define map to handle the number occuurance count
        Map<Character, Integer> charCount = new HashMap<>();

        // Increment counts for string 'a' and decrement for string 'b'
        for (int i = 0; i < a.length(); i++) {
            charCount.put(a.charAt(i), charCount.getOrDefault(a.charAt(i), 0) + 1);
            charCount.put(b.charAt(i), charCount.getOrDefault(b.charAt(i), 0) - 1);
        }

        // Check if all counts are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    // Check if 2 Strings are anagrams using Arrays
    public static boolean isAnagramUsingArray(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        // Convert both strings to lower case to handle case insensitivity
        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] count = new int[26]; // Array to track character counts for 'a' to 'z'

        // Increment character counts for string 'a'
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
        }

        // Decrement character counts for string 'b'
        for (int i = 0; i < b.length(); i++) {
            count[b.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Using the array-based method
        boolean ret = isAnagramUsingArray("cAt", "tac");
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");

        // Using the optimized map-based method
        boolean retMap = isAnagramUsingMaps("cAt", "tac");
        System.out.println((retMap) ? "Anagrams" : "Not Anagrams");
    }
}