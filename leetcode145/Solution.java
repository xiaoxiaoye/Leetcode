package leetcode.leetcode145;

import java.util.*;
import leetcode.common.*;
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


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return  stackTraversal(root);
    }

    // 基于迭代遍历
    private List<Integer> stackTraversal(TreeNode node){
        if(node == null) return Collections.emptyList();

        List<Integer> results = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            node = stack.removeFirst();

            if(node.right != null && node.right != prev){
                stack.addFirst(node);
                node = node.right;
                continue;
            }
            results.add(node.val);
            prev = node;
            // 右子树已经遍历，不需要再遍历一遍
            node = null;
        }
        return results;
    }
}
// @lc code=end

