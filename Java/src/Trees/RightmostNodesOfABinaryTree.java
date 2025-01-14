package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

public class RightmostNodesOfABinaryTree {
    public List<TreeNode> rightmostNodesOfABinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Add all the non-null child nodes of the current level to the
            // queue.
            for (int i = 0; i < levelSize; i++) {
                TreeNode n = queue.poll();
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
                // Record this level's last node to the result array.
                if (i == levelSize - 1) {
                    res.add(n);
                }
            }
        }
        return res;
    }
}
