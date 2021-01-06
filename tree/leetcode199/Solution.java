package leetcode.tree.leetcode199;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (62.11%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    15.9K
 * Total Submissions: 25.4K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
 * 
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



// @lc code=start
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> results = new LinkedList<>();    

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if(i == size-1){
                    results.add(node.val);
                }
                if(node.left != null){
                    deque.offer(node.left);
                }

                if(node.right != null){
                    deque.offer(node.right);
                }
            }
        }
        return results;
    }
}
// @lc code=end

