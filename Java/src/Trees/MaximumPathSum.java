package Trees;

import DS.TreeNode;

/*
    // Definition of TreeNode:
    public class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
 */

public class MaximumPathSum {
    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    public static int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sumLeft = Math.max(maxPathSumHelper(root.left), 0);
        int sumRight = Math.max(maxPathSumHelper(root.right), 0);

        maxSum = Math.max(maxSum, sumLeft + sumRight + root.val);

        return root.val + Math.max(sumLeft, sumRight);
    }
}
