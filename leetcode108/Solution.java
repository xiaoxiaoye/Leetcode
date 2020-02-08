package leetcode.leetcode108;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (67.98%)
 * Likes:    301
 * Dislikes: 0
 * Total Accepted:    43.9K
 * Total Submissions: 64.1K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length);
    }

    private TreeNode buildTree(int begin, int end){
        if(begin >= end) return null;
        int root_index = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[root_index]);
        root.left = buildTree(begin, root_index);
        root.right = buildTree(root_index+1, end);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode n = s.sortedArrayToBST(nums);
        System.out.println(n.val);
    }
}
// @lc code=end

