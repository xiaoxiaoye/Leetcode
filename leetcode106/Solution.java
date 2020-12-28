package leetcode.leetcode106;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (65.53%)
 * Likes:    139
 * Dislikes: 0
 * Total Accepted:    21.1K
 * Total Submissions: 31.9K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Solution {
    HashMap<Integer, Integer> pivotMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            pivotMap.put(inorder[i], i);
        }

        int n = inorder.length;
        return buildTreeHelper(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {
        if (inStart > inEnd)
            return null;
        int pivot = pivotMap.get(postorder[postEnd]);
        // 左子树的长度
        int leftLength = pivot - inStart;
        // 后续遍历的最后一个节点是父节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 递归构建左子树
        root.left = buildTreeHelper(inorder, inStart, pivot - 1, postorder, postStart, postStart + leftLength - 1);
        // 递归构建右子树
        root.right = buildTreeHelper(inorder, pivot + 1, inEnd, postorder, postStart + leftLength, postEnd - 1);
        return root;
    }
}
// @lc code=end