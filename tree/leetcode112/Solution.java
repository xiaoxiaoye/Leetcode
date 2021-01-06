package leetcode.tree.leetcode112;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.common.*;
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (51.45%)
 * Likes:    486
 * Dislikes: 0
 * Total Accepted:    160.1K
 * Total Submissions: 310.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
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
    private boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        // helper(root, sum, 0);
        // return flag;
        return bfs(root, sum);
    }

    private void helper(TreeNode node,int des, int curSum){
        if(flag) return;
        if(node == null) return;
        curSum += node.val;
        if(node.left == null && node.right==null){
            if(curSum == des){
                flag = true;
            }
        }
        if(node.left != null){
            helper(node.left, des, curSum);
        }
        if(node.right != null){
            helper(node.right, des, curSum);
        }
    }

    private boolean bfs(TreeNode node, int sum){
        Deque<TreeNode> dequeNode = new LinkedList<>();
        Deque<Integer> dequeValue = new LinkedList<>();
        dequeNode.addFirst(node);
        dequeValue.addFirst(node.val);
        while(!dequeNode.isEmpty()){
            TreeNode curNode = dequeNode.removeLast();
            Integer curSum = dequeValue.removeLast();
            if(curNode.left == null && curNode.right==null && curSum == sum){
                return true;
            }

            if(curNode.left != null){
                dequeNode.addFirst(curNode.left);
                dequeValue.addFirst(curSum+curNode.left.val);
            }
            if(curNode.right != null){
                dequeNode.addFirst(curNode.right);
                dequeValue.addFirst(curSum+curNode.right.val);
            }
        }

        return false;
    }
}
// @lc code=end