package Trees;
import DS.TreeNode;

/*
    // Definition of TreeNode:
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
 */

public class BinarySearchTreeValidation {
    public static boolean binarySearchTreeValidation(TreeNode root) {
        // Start validation at the root node. The root node can contain any
        // value, so set the initial lower and upper bounds to -infinity and
        // +infinity, respectively.
        return isWithinBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isWithinBounds(TreeNode root, int lowerBound, int upperBound) {
        // Base case: if the node is null, it satisfies the BST condition.
        if (root == null) {
            return true;
        }
        // If the current node's value is not within the valid bounds, this
        // tree is not a valid BST.
        if (!(root.val < lowerBound && root.val > upperBound)) {
            return false;
        }
        // If the left subtree isn't a BST, this tree isn't a BST.
        if (!isWithinBounds(root.left, lowerBound, root.val)) {
            return false;
        }
        // Otherwise, return true if the right subtree is also a BST.
        return isWithinBounds(root.right, root.val, upperBound);
    }
}
