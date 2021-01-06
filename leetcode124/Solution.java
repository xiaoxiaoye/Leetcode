package leetcode.leetcode124;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (38.31%)
 * Likes:    299
 * Dislikes: 0
 * Total Accepted:    23.3K
 * Total Submissions: 59.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-10,9,20,null,null,15,7]
 * 
 *  -10
 *  / \
 * 9  20
 *   /  \
 * 15   7
 * 
 * 输出: 42
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// @lc code=start
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node){
        if(node == null) return 0;

        // 为负数的那一条路径给舍去
        int left = Math.max(maxGain(node.left),0);
        int right = Math.max(maxGain(node.right),0);

        int newPath = node.val + left + right;
        maxSum = Math.max(maxSum, newPath);

        return node.val + Math.max(left, right);
    }
}
// @lc code=end

