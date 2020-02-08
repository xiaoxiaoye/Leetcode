package leetcode.leetcode222;


/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (63.62%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    12.8K
 * Total Submissions: 19.5K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 * 
 * 说明：
 * 
 * 
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第
 * h 层，则该层包含 1~ 2^h 个节点。
 * 
 * 示例:
 * 
 * 输入: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * 输出: 6
 * 
 */

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

// @lc code=start
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int depth = depthTree(root);
        if(depth == 0) return 1;
        int lastDepthMaxLen = (int)Math.pow(2, depth);
        int low = 0;
        int high = lastDepthMaxLen - 1;
        while(low <= high){
            int middle = low + (high - low) / 2;
            if(findInDepth(root, depth, middle)){
                // 此处需要考虑完全二叉树的情况，此时findInDepth会一直返回true
                // if(!findInDepth(root, depth, middle+1)){
                //     lastDepthLen = middle + 1;
                //     break;
                // } else {
                //     low = middle + 1;
                // }
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return (int)Math.pow(2, depth) -1  + low;
    }

    private boolean findInDepth(TreeNode node, int depth, int index){
        int low = 0;
        int high = (int)Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int middle = low + (high - low)/2;
            if(index <= middle){
                node = node.left;
                high = middle - 1;
            } else {
                node = node.right;
                low = middle + 1;
            }
        }
        return node != null;
    }

    private int depthTree(TreeNode node) {
        int depth = -1;
        while(node != null){
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        
        int c1 = s.countNodes(root);
        System.out.println(c1);
    }
}
// @lc code=end

