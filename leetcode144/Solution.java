package leetcode.leetcode144;

import java.util.*;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (62.78%)
 * Likes:    187
 * Dislikes: 0
 * Total Accepted:    59.2K
 * Total Submissions: 93.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursionTraversal(root, result);
        return result;
    }

    // 基于递归遍历
    private void recursionTraversal(TreeNode node, List<Integer> result){
        if(node == null) return;
        result.add(node.val);
        recursionTraversal(node.left, result);
        recursionTraversal(node.right, result);
    }

    // 基于迭代遍历
    private void stackTraversal(TreeNode node, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = node;
        while(curr != null || stack.size() != 0){
            while(curr != null){
                stack.add(curr);
                result.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }
}
// @lc code=end

