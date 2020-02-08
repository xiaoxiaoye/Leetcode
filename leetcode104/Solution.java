package leetcode.leetcode104;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// DFS利用深度优先搜索
class Solution {
    public int maxDepth(TreeNode root) {
        return recurTreeDepth(root, 0);
    }
    private int recurTreeDepth(TreeNode node, int depth){
        if(node == null) return depth;
        depth++;
        int left = recurTreeDepth(node.left, depth);
        int right = recurTreeDepth(node.right, depth);
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right = node7;
        node7.left = node6;
        node7.right = node9;

        Solution s = new Solution();
        int depth = s.maxDepth(root);
        System.out.println(depth);
    }
}