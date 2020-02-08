package leetcode.leetcode101;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (49.19%)
 * Likes:    563
 * Dislikes: 0
 * Total Accepted:    82.7K
 * Total Submissions: 167.3K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 *3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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

import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // return isSymmetricByRecursive(root.left, root.right);
        return isSymmetricByTraversal(root);
    }

    private boolean isSymmetricByRecursive(TreeNode leftNode, TreeNode rightNode){
        if(leftNode != null && rightNode != null && leftNode.val != rightNode.val) {
            return false;
        } else if (leftNode == null && rightNode == null) {
            return true;
        } else if(leftNode == null || rightNode == null) {
            return false;
        }
        if(!isSymmetricByRecursive(leftNode.left, rightNode.right)) return false;
        if(!isSymmetricByRecursive(leftNode.right, rightNode.left)) return false;
        return true;
    }

    private boolean isSymmetricByTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left); 
        }
        return true;
    }
}
// @lc code=end

