package leetcode.leetcode99;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.common.TreeNode;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (62.06%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    44.1K
 * Total Submissions: 71K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树上节点的数目在范围 [2, 1000] 内
 * -2^31 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private TreeNode x;
    private TreeNode y;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        // inOrder(root);
        // inOrderByStack(root);
        inOrderByMirror(root);

        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    // 利用函数递归
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                y = root;
                if (x == null) {
                    x = prev;
                }
            }
            prev = root;
        }
        inOrder(root.right);
    }

    // 手动利用堆栈模拟递归
    private void inOrderByStack(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            if(prev != null && prev.val > node.val){
                y = node;
                if(x == null) x=prev;
            }
            prev = node;

            node = node.right;
        }
    }

    public void inOrderByMirror(TreeNode node) {
        TreeNode predecessor;
        while(node != null){
            if(node.left == null){
                if(prev != null && prev.val > node.val){
                    y = node;
                    if(x == null) x=prev;
                }
                prev = node;

                node = node.right;
            } else {
                // 寻找后继节点
                predecessor = node.left;
                while(predecessor.right != null && predecessor.right != node){
                    predecessor = predecessor.right;
                }
    
                if(predecessor.right == null){
                    predecessor.right = node;
                    node = node.left;
                } else {
                    if(prev != null && prev.val > node.val){
                        y = node;
                        if(x == null) x=prev;
                    }
                    prev = node;

                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
    }
}
// @lc code=end
