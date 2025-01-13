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

public class BalancedBinaryTreeValidation {
    public static boolean balancedBinaryTreeValidation(TreeNode root) {
        return getHeightImbalance(root) != -1;
    }

    public static int getHeightImbalance(TreeNode root) {
        // Base case: if the node is null, its height is 0.
        if (root == null) {
            return 0;
        }
        // Recursively get the height of the left and right subtrees. If
        // either subtree is imbalanced, propagate -1 up the tree.
        int leftHeight = getHeightImbalance(root.left);
        int rightHeight = getHeightImbalance(root.right);
        // If the current node's subtree is imbalanced
        // (height difference > 1), return -1.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // Return the height of the current subtree.
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
