package leetcode.leetcode111;

import java.util.*;

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        // return depthDFS(root);
        return depthBFS(root);
    }

    private int depthDFS(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int minDepth = Integer.MAX_VALUE;
        if(node.left != null){
            minDepth = Math.min(depthDFS(node.left), minDepth);
        }
        if(node.right != null){
            minDepth = Math.min(depthDFS(node.right), minDepth);
        }
        return minDepth + 1;
    }

    private int depthBFS(TreeNode node){
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int depth = 1;
        while(!queue.isEmpty()){
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode n = queue.remove();
                if(n.left == null && n.right == null){
                    return depth;
                }
                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null){
                    queue.add(n.right);
                }
            }
            depth++;
        }
        return -1;
    }
}
// @lc code=end