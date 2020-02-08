package leetcode.leetcode106;

import java.util.*;

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
    private int post_index;
    private int[] postorder;
    private HashMap<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.post_index = postorder.length-1;
        this.inorderIndexMap = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return helper(0, postorder.length);
    }

    private TreeNode helper(int left, int right){
        if(left==right) return null;

        int root_val = postorder[post_index--];
        int root_index = inorderIndexMap.get(root_val);

        TreeNode root = new TreeNode(root_val);

        root.right = helper(root_index+1, right);
        root.left = helper(left, root_index);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode tree = s.buildTree(inorder, postorder);
        System.out.println(tree.val);
    }
}
// @lc code=end