package amazon;


public class ReverseVowelsMain {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        String s1 = "hello";
        System.out.println("Original: " + s1);
        System.out.println("Reversed: " + solver.reverseVowels(s1));
        // Expected: "holle"

        // Test Case 2
        String s2 = "leetcode";
        System.out.println("\nOriginal: " + s2);
        System.out.println("Reversed: " + solver.reverseVowels(s2));
        // Expected: "leotcede"

        // Test Case 3
        String s3 = "IceCreAm";
        System.out.println("\nOriginal: " + s3);
        System.out.println("Reversed: " + solver.reverseVowels(s3));
        // Expected: "AceCreIm"
    }

    static class Solution {
        public String reverseVowels(String s) {
            char[] arr = s.toCharArray();
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                // Check if current characters are vowels
                boolean leftIsVowel = isVowel(arr[left]);
                boolean rightIsVowel = isVowel(arr[right]);

                if (leftIsVowel && rightIsVowel) {
                    // Both are vowels: Swap them and move both pointers inward
                    swap(arr, left, right);
                    left++;
                    right--;
                } else if (!leftIsVowel) {
                    // Left is not a vowel: Move left pointer forward
                    left++;
                } else if (!rightIsVowel) {
                    // Right is not a vowel: Move right pointer backward
                    right--;
                }
            }
            return new String(arr);
        }

        // Helper method to swap characters
        private void swap(char[] arr, int left, int right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        // Helper method to check for vowels (case insensitive)
        private boolean isVowel(char letter) {
            char c = Character.toLowerCase(letter);
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
