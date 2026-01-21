package recurssion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParentheses {

    /**
     * Recursively finds and prints all valid strings by removing the minimum number of parentheses.
     *
     * @param str        The current string in the recursion.
     * @param minRemoval The number of removals still allowed.
     * @param ans        A set to store unique valid answers to avoid duplicates.
     */
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        // Base case: If we have used up our allowed removals.
        if (minRemoval == 0) {
            // Check if the resulting string is valid using our dedicated method.
            if (isValid(str)) {
                // If it's valid and not already printed, print it and add to the set.
                if (ans.add(str)) {
                    System.out.println(str);
                }
            }
            return;
        }

        // Recursive step: Iterate through the string and try removing each character.
        for (int i = 0; i < str.length(); i++) {
            // Skip duplicates to avoid redundant recursive calls.
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }

            // Only consider removing parentheses.
            char ch = str.charAt(i);
            if (ch == '(' || ch == ')') {
                String left = str.substring(0, i);
                String right = str.substring(i + 1);
                // Recurse with the new string and one less removal.
                solution(left + right, minRemoval - 1, ans);
            }
        }
    }

    /**
     * Checks if a string has a valid/balanced set of parentheses.
     *
     * @param str The string to validate.
     * @return true if the string is valid, false otherwise.
     */
    public static boolean isValid(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
            // If count is negative, it means a ')' appeared without a preceding '('.
            if (count < 0) {
                return false;
            }
        }
        // A valid string will have a final count of 0.
        return count == 0;
    }

    /**
     * Calculates the minimum number of parentheses that need to be removed to make the string valid.
     *
     * @param str The input string.
     * @return The number of parentheses to remove.
     */
    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // Found a matching pair.
                } else {
                    st.push(ch); // This ')' is unmatched.
                }
            }
        }
        // The size of the stack at the end is the number of invalid parentheses.
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        // 1. Calculate the minimum number of removals required.
        int mr = getMin(str);

        // 2. Find and print all valid solutions.
        solution(str, mr, new HashSet<>());

        scn.close();
    }
}
