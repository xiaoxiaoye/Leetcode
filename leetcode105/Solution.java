package leetcode.leetcode105;

import java.util.*;

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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        buildTreeRecursion(preorder, inorder, root);
        return root;
    }

    private void buildTreeRecursion(int[] preorder, int[] inorder, TreeNode root){
        if(preorder.length <= 1) return;
        int pivot = findNode(root.val, inorder);

        if(pivot != 0){
            TreeNode left = new TreeNode(preorder[1]);
            root.left = left;
            buildTreeRecursion(Arrays.copyOfRange(preorder, 1, pivot+1), Arrays.copyOfRange(inorder, 0, pivot), left);
        }
        if(pivot != inorder.length-1){
            TreeNode right = new TreeNode(preorder[pivot+1]);
            root.right = right;
            buildTreeRecursion(Arrays.copyOfRange(preorder, pivot+1, preorder.length), Arrays.copyOfRange(inorder, pivot+1, inorder.length), right);
        }
    }

    private int findNode(int val, int[] nodes){
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == val){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = {1,2};
        int[] inorder = {1,2};

        TreeNode tree = s.buildTree(preorder, inorder);

        System.out.println(""+tree.val);
    }
}
// @lc code=end