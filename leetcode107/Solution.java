package leetcode.leetcode107;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (63.30%)
 * Likes:    172
 * Dislikes: 0
 * Total Accepted:    37.1K
 * Total Submissions: 58.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return Collections.emptyList();
        LinkedList<List<Integer>> results=new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();

            List<Integer> items = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeLast();
                items.add(node.val);

                if(node.left!=null){
                    deque.addFirst(node.left);
                }

                if(node.right!=null){
                    deque.addFirst(node.right);
                }
            }
            results.addFirst(items);
        }
        return results;
    }
}
// @lc code=end

