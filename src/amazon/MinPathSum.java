package amazon;

import java.util.Scanner;

public class MinPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input dimensions
        System.out.println("Enter the number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int m = scanner.nextInt();

        int[][] grid = new int[n][m];

        // 2. Input grid data
        System.out.println("Enter the grid values row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 3. Run the solution
        Solution solution = new Solution();
        int result = solution.minPathSum(grid);

        // 4. Output the result
        System.out.println("The minimum path sum is: " + result);

        scanner.close();
    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // Check cell above (Top)
                    int top = (i - 1 < 0) ? Integer.MAX_VALUE : grid[i - 1][j];

                    // Check cell to the left (Renamed from 'buttom' to 'left' for accuracy)
                    int left = (j - 1 < 0) ? Integer.MAX_VALUE : grid[i][j - 1];

                    // If both are boundaries (start cell), min is 0. Otherwise take the smaller one.
                    int min = (top == Integer.MAX_VALUE && left == Integer.MAX_VALUE) ? 0 : Math.min(top, left);

                    grid[i][j] += min;
                }
            }
            return grid[n - 1][m - 1];
        }
    }
}