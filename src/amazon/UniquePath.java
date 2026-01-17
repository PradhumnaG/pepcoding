package amazon;

public class UniquePath {


    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solver = new Solution();

        // Test Case 1: Standard example (3x7 grid)
        int m1 = 3;
        int n1 = 7;
        int result1 = solver.uniquePaths(m1, n1);
        System.out.println("Grid (" + m1 + "x" + n1 + ") - Unique Paths: " + result1);
        // Expected Output: 28

        // Test Case 2: Small grid (3x2 grid)
        int m2 = 3;
        int n2 = 2;
        int result2 = solver.uniquePaths(m2, n2);
        System.out.println("Grid (" + m2 + "x" + n2 + ") - Unique Paths: " + result2);
        // Expected Output: 3

        // Test Case 3: Single cell (1x1 grid)
        int m3 = 1;
        int n3 = 1;
        int result3 = solver.uniquePaths(m3, n3);
        System.out.println("Grid (" + m3 + "x" + n3 + ") - Unique Paths: " + result3);
        // Expected Output: 1
    }

    // Your provided Solution class
    static class Solution {
        public int uniquePaths(int m, int n) {
            // Create a 2D array to store the number of paths to each cell
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // Base Case: The first row (i==0) and first column (j==0)
                    // can only be reached in 1 way (straight line).
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Recursive Step: The paths to reach the current cell is
                        // the sum of paths from the cell above (i-1) and the cell to the left (j-1).
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            // Return the value in the bottom-right corner
            return dp[m - 1][n - 1];
        }
    }
}
