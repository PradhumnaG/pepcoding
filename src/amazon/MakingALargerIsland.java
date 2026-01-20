package amazon;
import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MakingALargerIsland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input dimensions
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];

        // 2. Input grid data
        System.out.println("Enter the grid values (0 or 1) row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 3. Run the solution
        Solution solution = new Solution();
        int result = solution.largestIsland(grid);

        // 4. Output the result
        System.out.println("The size of the largest island is: " + result);

        scanner.close();
    }

    // The Solution class extracted from your image
    static class Solution {

        private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int largestIsland(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int max = 0, islandId = 2, m = grid.length, n = grid[0].length;
            Map<Integer, Integer> map = new HashMap<>();

            // Step 1: Compute areas for existing islands
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int size = getIslandSize(grid, i, j, islandId);
                        max = Math.max(max, size);
                        map.put(islandId++, size);
                    }
                }
            }

            // Step 2: Try changing every 0 to 1
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> set = new HashSet<>();
                        for (int[] direction : directions) {
                            int x = direction[0] + i, y = direction[1] + j;
                            // Check neighbors
                            if (x > -1 && y > -1 && x < m && y < n && grid[x][y] != 0) {
                                set.add(grid[x][y]);
                            }
                        }

                        int sum = 1; // Start with 1 (the flipped zero)
                        for (int num : set) {
                            int value = map.get(num);
                            sum += value;
                        }

                        max = Math.max(max, sum);
                    }
                }
            }

            return max;
        }

        private int getIslandSize(int[][] grid, int i, int j, int islandId) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;

            grid[i][j] = islandId; // Mark with ID

            int left = getIslandSize(grid, i, j - 1, islandId);
            int right = getIslandSize(grid, i, j + 1, islandId);
            int up = getIslandSize(grid, i - 1, j, islandId);
            int down = getIslandSize(grid, i + 1, j, islandId);

            return left + right + up + down + 1;
        }
    }
}