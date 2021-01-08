package leetcode.tree.leetcode257;

import leetcode.common.*;
import java.util.*;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (66.38%)
 * Likes:    423
 * Dislikes: 0
 * Total Accepted:    90.8K
 * Total Submissions: 136.8K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
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
class Solution {
    private List<String> results = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<TreeNode> route = new LinkedList<>();
        dfs(root, route);
        return results;
    }

    private void dfs(TreeNode node, LinkedList<TreeNode> route){
        if(node == null) {
            return;
        }
        route.addLast(node);
        if(node.left == null && node.right == null) {
            results.add(buildRouteString(route));
            route.removeLast();
            return;
        }
        dfs(node.left, route);
        dfs(node.right, route);
        route.removeLast();
    }

    private String buildRouteString(List<TreeNode> route){
        StringBuilder builder = new StringBuilder();
        builder.append(route.get(0).val);
        for (TreeNode treeNode : route.subList(1, route.size())) {
            builder.append("->");
            builder.append(treeNode.val);
        }
        return builder.toString();
    }
}
// @lc code=end


