package leetcode.tree.leetcode113;

import java.util.*;
import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (57.86%)
 * Likes:    152
 * Dislikes: 0
 * Total Accepted:    26K
 * Total Submissions: 44.9K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> treeRoute = new LinkedList<>();
        List<List<Integer>> results = new LinkedList<>();
        // helper(root, treeRoute,results, 0, sum);
        helperBFS(root, results, sum);
        return results;
    }

    // 深度优先遍历
    private void helper(TreeNode node, List<Integer> treeRoute, List<List<Integer>> results, int curSum, int sum) {
        if (node == null)
            return;
        
        treeRoute.add(node.val);

        if (node.left == null && node.right == null) {
            if (curSum + node.val == sum) {
                List<Integer> items = new LinkedList<>(treeRoute);
                results.add(items);
            }
        }
        if (node.left != null) {
            helper(node.left, treeRoute, results,curSum + node.val, sum);
        }

        if (node.right != null) {
            helper(node.right, treeRoute, results,curSum + node.val, sum);
        }
        treeRoute.remove(treeRoute.size() - 1);
    }

    // 广度优先遍历
    private void helperBFS(TreeNode node, List<List<Integer>> results, int sum) {
        // 利用map存储遍历轨迹
        HashMap<TreeNode,TreeNode> routeMap = new HashMap<>();

        Deque<TreeNode> nodeDeque = new LinkedList<>();
        Deque<Integer> valueDeque = new LinkedList<>();
        nodeDeque.addFirst(node);
        valueDeque.addFirst(node.val);

        while(!nodeDeque.isEmpty()){
            node = nodeDeque.removeLast();
            int curSum = valueDeque.removeLast();
            if(node.left == null && node.right==null){
                if(curSum == sum){
                    results.add(getPath(routeMap, node));
                }
            }
            if(node.left != null){
                nodeDeque.addFirst(node.left);
                valueDeque.addFirst(curSum+node.left.val);
                routeMap.put(node.left, node);
            }
            if(node.right != null){
                nodeDeque.addFirst(node.right);
                valueDeque.addFirst(curSum+node.right.val);
                routeMap.put(node.right, node);
            }
        }
    }

    private List<Integer> getPath(HashMap<TreeNode,TreeNode> routeMap, TreeNode node){
        LinkedList<Integer> items = new LinkedList<>();
        items.add(node.val);
        while(routeMap.containsKey(node)){
            node = routeMap.get(node);
            items.addFirst(node.val);
        }
        return items;
    }
}
// @lc code=end
