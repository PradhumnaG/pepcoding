package dinamicprogramming;


import java.io.*;
        import java.util.*;

public class KnapsapProblemZeroOne  {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        // Input: Number of items
        int n = scn.nextInt();

        // Input: Values of the items
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }

        // Input: Weights of the items
        int[] wts = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }

        // Input: Capacity of the bag
        int cap = scn.nextInt();

        // Create a 2D DP array
        // Rows = items (0 to n), Cols = capacity (0 to cap)
        int[][] dp = new int[n + 1][cap + 1];

        // Iterate through each item (i) and each capacity (j)
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // Get value and weight of the current item (i-1 because input arrays are 0-indexed)
                int val = vals[i - 1];
                int wt = wts[i - 1];

                if (j >= wt) {
                    // If the bag capacity (j) allows the current item:
                    // Option 1: Exclude the item (value comes from previous row, same capacity)
                    // Option 2: Include the item (value of current item + max value of remaining capacity from previous row)
                    int rCap = j - wt; // Remaining capacity

                    if (dp[i - 1][rCap] + val > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rCap] + val; // Include is better
                    } else {
                        dp[i][j] = dp[i - 1][j]; // Exclude is better
                    }
                } else {
                    // If current item weight > capacity j, we must exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The answer is stored in the bottom-right cell
        System.out.println(dp[n][cap]);
    }
}