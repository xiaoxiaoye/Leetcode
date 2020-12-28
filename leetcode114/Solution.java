package leetcode.leetcode114;

import java.util.LinkedList;
import java.util.List;
import leetcode.common.*;
/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (66.39%)
 * Likes:    237
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 34.4K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * 例如，给定二叉树
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 将其展开为：
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
    // 利用递归
    public void flatten_recusive(TreeNode root) {
        if (root == null) return;
        List<TreeNode> orderList = new LinkedList<>();
        preTravelsal(root, orderList);

        for (int i = 1; i < orderList.size(); i++) {
            TreeNode prev = orderList.get(i-1);
            prev.left = null;
            prev.right = orderList.get(i);
        }
    }

    private void preTravelsal(TreeNode node, List<TreeNode> orderList){
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || node != null){
            while(node != null){
                orderList.add(node);
                stack.addFirst(node);
                node = node.left;
            }
            node = stack.removeFirst();
            node = node.right;
        }
    }

    // 利用stack模拟递归
    public void flatten_stack(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.removeFirst();
            if(prev != null){
                prev.left = null;
                prev.right = cur;
            }

            if(cur.right != null){
                stack.addFirst(cur.right);
            }

            if(cur.left != null){
                stack.addFirst(cur.left);
            }

            prev = cur;
        }
    }

    public void flatten(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode next = cur.left;
                TreeNode predecessor = next;
                while(predecessor.right != null){
                    predecessor = predecessor.right;
                }

                predecessor.right = cur.right;
                cur.left = null;
                cur.right = next;
            }

            cur = cur.right;
        }
    }
}
// @lc code=end

