package recurssion;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParentheses {

    /**
     * The main recursive function to find all valid strings by removing the minimum number of parentheses.
     * @param str The current string being processed.
     * @param minRemoval The remaining number of parentheses to remove.
     * @param ans A HashMap to store unique valid results to avoid duplicates.
     */
    public static void solution(String str, int minRemoval, HashMap<String, Boolean> ans) {
        // Base Case: If we have performed the minimum required removals.
        if (minRemoval == 0) {
            // Check if the resulting string is now valid.
            if (getMin(str) == 0) {
                // If it's valid and we haven't printed it before, print it and add it to our set of answers.
                if (!ans.containsKey(str)) {
                    System.out.println(str);
                    ans.put(str, true);
                }
            }
            return;
        }

        // Recursive Step: Iterate through the string and try removing each character.
        for (int i = 0; i < str.length(); i++) {
            // Optimization: Only try removing parentheses.
            char ch = str.charAt(i);
            if (ch == '(' || ch == ')') {
                String left = str.substring(0, i);
                String right = str.substring(i + 1);
                String newStr = left + right;
                // Recurse with the new, smaller string and one less removal allowed.
                solution(newStr, minRemoval - 1, ans);
            }
        }
    }

    /**
     * Calculates the minimum number of parentheses to remove to make a string valid.
     * @param str The input string.
     * @return The count of invalid parentheses.
     */
    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '('){
        } else if (ch == ')') {
                if(st.size() == 0){
                    st.push(ch);
                } else if (st.peek() == ')') {
                    st.push(ch);
                } else if (st.peek() == '(') {
                   st.pop(ch);
                }
            }
        }
        // The final size of the stack represents the number of parentheses to be removed.
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        // Calculate the minimum number of removals needed.
        int minRemovals = getMin(str);
        
        // Find and print all valid strings.
        solution(str, minRemovals, new HashMap<>());
        
        scn.close();
    }
}
