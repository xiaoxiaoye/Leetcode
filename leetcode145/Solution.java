package leetcode.leetcode145;

import java.util.*;
/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (68.98%)
 * Likes:    205
 * Dislikes: 0
 * Total Accepted:    44.2K
 * Total Submissions: 63.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> result = new LinkedList<>();
        // recursionTraversal(root, result);
        // return result;
        return  stackTraversal(root);
    }

    // 基于递归遍历
    private void recursionTraversal(TreeNode node, List<Integer> result){
        if(node == null) return;
        recursionTraversal(node.left, result);
        recursionTraversal(node.right, result);
        result.add(node.val);
    }

    // 基于迭代遍历
    private List<Integer> stackTraversal(TreeNode node){
        LinkedList<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr;
        if(node == null) return ret;
        stack.add(node);
        while(!stack.isEmpty()){
            curr = stack.pop();
            ret.addFirst(curr.val);
            if(curr.left != null){
                stack.add(curr.left);
            }

            if(curr.right != null){
                stack.add(curr.right);
            }
        }
        return ret;
    }
}
// @lc code=end

