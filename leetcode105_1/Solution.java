package leetcode.leetcode105_1;

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
    private int pre_index = 0;
    private int[] preorder;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        this.preorder = preorder;
        this.inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return helper(0, preorder.length);
    }

    private TreeNode helper(int left, int right){
        if(left == right) return null;

        int root_val = preorder[pre_index++];
        int root_index = inorderIndexMap.get(root_val);
        TreeNode root = new TreeNode(root_val);

        root.left = helper(left, root_index);
        root.right = helper(root_index+1, right);

        return root;
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