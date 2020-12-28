package leetcode.leetcode104;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (75.39%)
 * Likes:    761
 * Dislikes: 0
 * Total Accepted:    320.7K
 * Total Submissions: 425.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    private int maxDepth = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, 0);
        return maxDepth;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            if (depth > maxDepth)
                maxDepth = depth;
            return;
        }
        depth++;
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
// @lc code=end