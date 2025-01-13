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

public class LowestCommonAncestor {
    static TreeNode LCA;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return LCA;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean nodeIsPOrQ = (node == p || node == q);

        boolean leftContainsPOrQ = dfs(node.left, p, q);
        boolean rightContainsPOrQ = dfs(node.right, p, q);

        if ((nodeIsPOrQ ? 1 : 0) + (leftContainsPOrQ ? 1 : 0) + (rightContainsPOrQ ? 1 : 0) == 2) {
            LCA = node;
        }
        return nodeIsPOrQ || leftContainsPOrQ || rightContainsPOrQ;
    }
}
