package amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateInArray {


    public static class FindDuplicatesMain {

        public static void main(String[] args) {
            Solution solver = new Solution();

            // Test Case 1: Standard example
            int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
            System.out.println("Input: " + Arrays.toString(nums1));
            System.out.println("Duplicates: " + solver.findDuplicates(nums1));
            // Expected Output: [2, 3]

            // Test Case 2: Array with single duplicate pair
            int[] nums2 = {1, 1, 2};
            System.out.println("\nInput: " + Arrays.toString(nums2));
            System.out.println("Duplicates: " + solver.findDuplicates(nums2));
            // Expected Output: [1]

            // Test Case 3: Array with no duplicates
            int[] nums3 = {1};
            System.out.println("\nInput: " + Arrays.toString(nums3));
            System.out.println("Duplicates: " + solver.findDuplicates(nums3));
            // Expected Output: []
        }
    }

    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            // Correct 'ArrayList' capitalization
            List<Integer> result = new ArrayList<>();

            // Correct 'nums.length'
            for (int i = 0; i < nums.length; i++) {
                // Get the index that this value maps to.
                // Use Math.abs() because the value might have been negated previously.
                int index = Math.abs(nums[i]) - 1;

                // Check if the number at this mapped index is negative.
                // If it is negative, it means we have seen this index before.
                if (nums[index] < 0) {
                    result.add(index + 1);
                } else {
                    // If it is positive, mark it as visited by negating it.
                    // IMPORTANT: Only negate if it's currently positive.
                    nums[index] = -nums[index];
                }
            }
            return result;
        }

    }
}
