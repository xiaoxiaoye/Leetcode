package leetcode.tree.leetcode111;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (40.65%)
 * Likes:    192
 * Dislikes: 0
 * Total Accepted:    45.5K
 * Total Submissions: 111K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *  int val;
 *  TreeNode left;
 *  TreeNode right;
 *  TreeNode(int x) { 
 *      val = x;
 *  } 
 * }
 */

public class Solution {
    public int minDepth(TreeNode root) {
        return depthBFS(root);
        // return depthDFSByRecursion(root);
    }

    // 深度优先遍历
    private int depthDFSByRecursion(TreeNode node) {
        if(node == null) return 0;
        int leftDepth = depthDFSByRecursion(node.left)+1;
        int rightDepth =depthDFSByRecursion(node.right)+1;
        if(node.left != null && node.right != null){
            return Math.min(leftDepth, rightDepth);
        }
        return Math.max(leftDepth, rightDepth);
    }

    // private int depthDFSByStack(TreeNode node) {
    //     if(node == null) return 0;
    //     int depth = 0;
    //     int minDepth = Integer.MIN_VALUE;
    //     LinkedList<TreeNode> stack = new LinkedList<>();
    //     while(node != null || !stack.isEmpty()){
    //         if(node.left != null){
    //             stack.addLast(node.left);
    //             node = node.left;
    //             depth++;
    //         }

    //         node = stack.removeFirst();
    //         depth--;
    //         if(node.right != null){
    //             node = node.right;
    //             depth++;
    //         }
    //     }
    //     return 0;
    // }

    // 广度优先遍历
    private int depthBFS(TreeNode node){
        if(node == null) return 0;

        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(node);
        while(!deque.isEmpty()){
            depth++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.removeLast();
                if(cur.left == null && cur.right==null){
                    return depth;
                }
                if(cur.left != null){
                    deque.addFirst(cur.left);
                }
                if(cur.right != null){
                    deque.addFirst(cur.right);
                }
            }

        }
        return depth;
    }
}
// @lc code=end