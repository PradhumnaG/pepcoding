package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargerIsland {

    // Solution class to encapsulate the logic
    static class Solution {
        int[] parent;
        int[] size;
        int rows, cols;

        public int largestIsland(int[][] grid) {
            rows = grid.length;
            cols = grid.length;
            parent = new int[rows * cols];
            size = new int[rows * cols];

            // Initialize DSU for each cell
            for (int i = 0; i < rows * cols; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            // Build initial islands and their sizes using DSU
            int maxIslandSize = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1) {
                        int currentCellIdx = r * cols + c;
                        // Check neighbors (right and down only to avoid double counting)
                        // Right neighbor
                        if (c + 1 < cols && grid[r][c + 1] == 1) {
                            union(currentCellIdx, r * cols + (c + 1));
                        }
                        // Down neighbor
                        if (r + 1 < rows && grid[r + 1][c] == 1) {
                            union(currentCellIdx, (r + 1) * cols + c);
                        }
                    }
                }
            }

            // After initial unions, update maxIslandSize with existing islands
            for (int i = 0; i < rows * cols; i++) {
                if (grid[i / cols][i % cols] == 1) { // Only consider '1' cells for initial island sizes
                    maxIslandSize = Math.max(maxIslandSize, size[find(i)]);
                }
            }

            // If there are no '0's, or all cells are '1's, maxIslandSize is already correct
            // If maxIslandSize is 0, it means the grid was all '0's, so flipping one '0' to '1' makes an island of size 1.
            if (maxIslandSize == 0 && rows * cols > 0) {
                return 1; // Grid is all zeros, flipping one makes an island of size 1
            }


            // Iterate through '0' cells and try flipping them to '1'
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 0) {
                        int currentPotentialIslandSize = 1; // The flipped '0' itself
                        Set<Integer> connectedComponents = new HashSet<>(); // To avoid double counting island sizes

                        // Check all 4 neighbors
                        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                        for (int[] dir : directions) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                                int neighborIdx = nr * cols + nc;
                                int rootOfNeighbor = find(neighborIdx);
                                if (!connectedComponents.contains(rootOfNeighbor)) {
                                    currentPotentialIslandSize += size[rootOfNeighbor];
                                    connectedComponents.add(rootOfNeighbor);
                                }
                            }
                        }
                        maxIslandSize = Math.max(maxIslandSize, currentPotentialIslandSize);
                    }
                }
            }
            return maxIslandSize;
        }

        // Find operation with path compression
        private int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        // Union operation by size
        private void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                if (size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                } else {
                    parent[rootJ] = rootI;
                    size[rootI] += size[rootJ];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1:
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println("Largest island in grid1: " + solver.largestIsland(grid1)); // Expected: 3 (flip (0,1) or (1,0))

        // Example 2:
        int[][] grid2 = {{1, 1}, {1, 0}};
        System.out.println("Largest island in grid2: " + solver.largestIsland(grid2)); // Expected: 4 (flip (1,1))

        // Example 3:
        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println("Largest island in grid3: " + solver.largestIsland(grid3)); // Expected: 4 (no '0' to flip, already max)

        // Example 4:
        int[][] grid4 = {{0, 0}, {0, 0}};
        System.out.println("Largest island in grid4: " + solver.largestIsland(grid4)); // Expected: 1 (flip any '0')

        // Example 5:
        int[][] grid5 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println("Largest island in grid5: " + solver.largestIsland(grid5)); // Expected: 3 (flip (0,1) or (1,0) or (1,2) or (2,1))

        // Example 6:
        int[][] grid6 = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println("Largest island in grid6: " + solver.largestIsland(grid6)); // Expected: 5 (flip (0,0) or (0,2) or (2,0) or (2,2))
    }
}
