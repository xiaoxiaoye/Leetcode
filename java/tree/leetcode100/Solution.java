package leetcode.tree.leetcode100;

import java.util.LinkedList;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (60.20%)
 * Likes:    533
 * Dislikes: 0
 * Total Accepted:    162K
 * Total Submissions: 269.2K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // return dfs(p, q);        
        return bfs(p, q);        
    }

    // 深度优先遍历
    private boolean dfs(TreeNode p, TreeNode q){
        LinkedList<TreeNode> stackP = new LinkedList<>();
        LinkedList<TreeNode> stackQ = new LinkedList<>();
        while((p != null || !stackP.isEmpty()) && (q != null || !stackQ.isEmpty())){
            while(p != null && q != null){
                stackP.addFirst(p);
                p=p.left;

                stackQ.addFirst(q);
                q=q.left;
            }

            if(p != null || q != null){
                return false;
            }

            p = stackP.removeFirst();
            q = stackQ.removeFirst();

            if(p.val != q.val) return false;

            p = p.right;
            q = q.right;
        }

        if(!stackP.isEmpty() || !stackQ.isEmpty() || p != null || q != null){
            return false;
        }

        return true;
    }

    // 广度优先遍历
    private boolean bfs(TreeNode p, TreeNode q){
        LinkedList<TreeNode> stackP = new LinkedList<>();
        LinkedList<TreeNode> stackQ = new LinkedList<>();
        if(p != null)
            stackP.addFirst(p);
        if(q != null)
            stackQ.addFirst(q);
        while(!stackP.isEmpty() && !stackQ.isEmpty()){
            TreeNode nodeP = stackP.removeLast();
            TreeNode nodeQ = stackQ.removeLast();

            if(nodeP.val != nodeQ.val){
                return false;
            }

            if(nodeP.left == null ^ nodeQ.left == null){
                return false;
            }

            if(nodeP.right == null ^ nodeQ.right == null){
                return false;
            }

            if(nodeP.left != null){
                stackP.addFirst(nodeP.left);
            }
            if(nodeP.right != null){
                stackP.addFirst(nodeP.right);
            }

            if(nodeQ.left != null){
                stackQ.addFirst(nodeQ.left);
            }
            if(nodeQ.right != null){
                stackQ.addFirst(nodeQ.right);
            }
        }

        return stackP.isEmpty() && stackQ.isEmpty();
    }
}
// @lc code=end


