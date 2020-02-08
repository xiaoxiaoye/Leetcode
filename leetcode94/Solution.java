package leetcode.leetcode94;

import java.util.*;
/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.18%)
 * Likes:    359
 * Dislikes: 0
 * Total Accepted:    90.4K
 * Total Submissions: 130.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursionTraversal(root, result);
        return result;
    }

    // 递归遍历
    private void recursionTraversal(TreeNode node, List<Integer> result){
        if(node == null) return;
        recursionTraversal(node.left, result);
        result.add(node.val);
        recursionTraversal(node.right, result);
    }

    // 基于迭代的遍历
    private void stackTraversal(TreeNode node, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = node;
        while(curr != null && stack.size() != 0){
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
    }
}
// @lc code=end

