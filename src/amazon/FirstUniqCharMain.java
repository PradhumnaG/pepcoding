package amazon;


    import java.util.HashMap;
import java.util.Map;

    public class FirstUniqCharMain {
        public static void main(String[] args) {
            Solution solver = new Solution();

            // Test Case 1: Standard example
            String s1 = "leetcode";
            System.out.println("Input: " + s1);
            System.out.println("First Unique Index: " + solver.firstUniqChar(s1));
            // Expected: 0 (letter 'l')

            // Test Case 2: Example with repeats at start
            String s2 = "loveleetcode";
            System.out.println("\nInput: " + s2);
            System.out.println("First Unique Index: " + solver.firstUniqChar(s2));
            // Expected: 2 (letter 'v')

            // Test Case 3: No unique characters
            String s3 = "aabb";
            System.out.println("\nInput: " + s3);
            System.out.println("First Unique Index: " + solver.firstUniqChar(s3));
            // Expected: -1
        }
    }

    class Solution {
        public int firstUniqChar(String s) {
            // Must import HashMap and Map
            Map<Character, Integer> map = new HashMap<>();

            // 1. Count frequency of each character
            for (int i = 0; i < s.length(); i++) {
                char letter = s.charAt(i);
                if (map.containsKey(letter)) {
                    map.put(letter, map.get(letter) + 1);
                } else {
                    map.put(letter, 1);
                }
            }

            // 2. Scan string again to find the first character with count == 1
            for (int i = 0; i < s.length(); i++) {
                char letter = s.charAt(i);
                if (map.get(letter) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }

