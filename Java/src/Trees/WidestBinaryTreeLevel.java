package Trees;

import java.util.LinkedList;
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

class TreePair{
    public TreeNode node;
    public int index;
    public TreePair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

public class WidestBinaryTreeLevel {
    public static int widestBinaryTreeLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<TreePair> queue = new LinkedList<>();
        queue.add(new TreePair(root, 1));
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Set the 'leftmost_index' to the index of the first node in
            // this level. Start 'rightmost_index' at the same point as
            // 'leftmost_index' and update it as we traverse the level,
            // eventually positioning it at the last node.
            int leftmostIndex = queue.peek().index;
            int rightmostIndex = leftmostIndex;
            // Process all nodes at the current level.
            for (int n = 0; n < levelSize; n++) {
                TreePair nodeIndex = queue.poll();
                TreeNode node = nodeIndex.node;
                int i = nodeIndex.index;
                if (node.left != null) {
                    queue.add(new TreePair(node.left, 2 * i + 1));
                }
                if (node.right != null) {
                    queue.add(new TreePair(node.right, 2 * i + 2));
                }
                rightmostIndex = i;
            }
            maxWidth = Math.max(maxWidth, rightmostIndex - leftmostIndex + 1);
        }
        return maxWidth;
    }
}
