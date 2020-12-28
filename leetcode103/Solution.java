package leetcode.leetcode103;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (52.79%)
 * Likes:    129
 * Dislikes: 0
 * Total Accepted:    27.9K
 * Total Submissions: 52.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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

// 题解类似102题的解法，只需要在奇数层的时候，将结果集逆序插入即可
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int treeLevel = 1;
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> levelItems = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeLast();
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (treeLevel % 2 == 0) {
                    levelItems.addFirst(node.val);
                } else {
                    levelItems.addLast(node.val);
                }
            }
            results.add(levelItems);
            treeLevel++;
        }
        return results;
    }
}
// @lc code=end
