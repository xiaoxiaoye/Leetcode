package leetcode.leetcode105;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (62.94%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    37.4K
 * Total Submissions: 58.9K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Solution {
    private HashMap<Integer, Integer> pivotMap = new HashMap<>();

    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if (preorder.length == 0 || inorder.length == 0)
    //         return null;
    //     // 没有重复的元素，可以利用map快速找到中序遍历的位置，得到左子树和右子树的数目。
    //     for (int i = 0; i < inorder.length; i++) {
    //         pivotMap.put(inorder[i], i);
    //     }
    //     TreeNode root = new TreeNode(preorder[0]);
    //     helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, root);
    //     return root;
    // }

    // private void helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
    //         TreeNode root) {
    //     int pivot = findPivot(root.val);
    //     int leftLength = pivot - inStart;
    //     // 构建左子树
    //     if (pivot > inStart) {
    //         root.left = new TreeNode(preorder[preStart + 1]);
    //         helper(preorder, preStart + 1, preStart + leftLength, inorder, inStart, pivot - 1, root.left);
    //     }

    //     // 构建右子树
    //     if (pivot != inEnd) {
    //         root.right = new TreeNode(preorder[preStart + leftLength + 1]);
    //         helper(preorder, preStart + leftLength + 1, preEnd, inorder, pivot + 1, inEnd, root.right);
    //     }
    // }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        // 没有重复的元素，可以利用map快速找到中序遍历的位置，得到左子树和右子树的数目。
        for (int i = 0; i < inorder.length; i++) {
            pivotMap.put(inorder[i], i);
        }
        int length = preorder.length;
        return buildTreeHelper(preorder, 0, length-1, inorder, 0, length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd) return null;
        int pivot = findPivot(preorder[preStart]);
        int leftLength = pivot - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        if(pivot>inStart){
            root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftLength, inorder, inStart, pivot - 1);
        }

        if(pivot != inEnd){
            root.right = buildTreeHelper(preorder, preStart + leftLength + 1, preEnd, inorder, pivot + 1, inEnd);
        }
        return root;
    }

    private int findPivot(int rootVal) {
        if (pivotMap.containsKey(rootVal)) {
            return pivotMap.get(rootVal);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode result = solution.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
    }
}
// @lc code=end