package amazon;

public class SumLeftLeavesMain {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Constructing the Tree:
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);           // Left Leaf
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);    // Left Leaf
        root.right.right = new TreeNode(7);    // Right Leaf (Don't count)

        System.out.println("Sum of Left Leaves: " + solver.sumOfLeftLeaves(root));
        // Expected Output: 9 + 15 = 24
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int sum = 0;

            // 1. Check Left Child
            if (root.left != null) {
                if (isLeaf(root.left)) {
                    // Case A: It's a Left Leaf -> Add its value
                    sum += root.left.val;
                } else {
                    // Case B: It's a Left Child but NOT a leaf -> Dig deeper
                    sum += sumOfLeftLeaves(root.left);
                }
            }

            // 2. Check Right Child (Always necessary to find left leaves hidden on the right side)
            sum += sumOfLeftLeaves(root.right);

            return sum;
        }

        private boolean isLeaf(TreeNode node) {
            return node != null && node.left == null && node.right == null;
        }
    }
}
