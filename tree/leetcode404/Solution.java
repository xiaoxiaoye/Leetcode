package leetcode.tree.leetcode404;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (56.35%)
 * Likes:    272
 * Dislikes: 0
 * Total Accepted:    66.6K
 * Total Submissions: 118K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // return bfs(root);
        return dfs(root);
    }
    public int bfs(TreeNode root) {
        if(root==null) return 0;

        int sum = 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        while(!deque.isEmpty()){
            TreeNode node = deque.removeLast();

            if(node.left != null){
                if(isLeaf(node.left)){
                    sum += node.left.val;
                } else {
                    deque.addFirst(node.left);
                }
            }

            if(node.right != null && !isLeaf(node.right)){
                deque.addFirst(node.right);
            }
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }


    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int sum = 0;
        if(root.left != null && isLeaf(root.left)) {
            sum += root.left.val + dfs(root.right);
        } else {
            sum += dfs(root.left) + dfs(root.right);
        }

        return sum;
    }
}
// @lc code=end


