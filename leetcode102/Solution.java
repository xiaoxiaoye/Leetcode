package leetcode.leetcode102;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.94%)
 * Likes:    349
 * Dislikes: 0
 * Total Accepted:    69.5K
 * Total Submissions: 115.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> results = new LinkedList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> levelResult = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeLast();
                levelResult.add(node.val);
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
            }
            results.add(levelResult);
        }
        return results;
    }
}
// @lc code=end
