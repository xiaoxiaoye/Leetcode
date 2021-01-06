package leetcode.tree.leetcode94;
import leetcode.common.*;

import java.util.LinkedList;
import java.util.List;
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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        // helper(root, results);
        // traversalByStack(root, results);
        traversalByMirror(root, results);
        return results;
    }

    // 递归遍历二叉树
    private void helper(TreeNode node, List<Integer> results){
        if(node == null) return;
        helper(node.left, results);
        results.add(node.val);
        helper(node.right, results);
    }

    // 利用堆栈迭代遍历二叉树
    private void traversalByStack(TreeNode node, List<Integer> results){
        if(node == null) return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.addFirst(node);
                node = node.left;
            }

            node = stack.pop();
            results.add(node.val);
            node = node.right;
        }
    }

    // mirror遍历，空间复杂度优化到O(1)
    private void traversalByMirror(TreeNode node, List<Integer> results){
        // 当前节点
        TreeNode cur = node;
        // 前驱节点
        TreeNode prev;

        while(cur != null){
            if(cur.left == null){
                results.add(cur.val);
                cur = cur.right;
            } else {
                // 找到前驱节点
                prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                // 将前驱节点的右节点指向当前节点
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                } else { // 到这里意味着prev.right==cur
                    prev.right = null;
                    results.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
}
// @lc code=end