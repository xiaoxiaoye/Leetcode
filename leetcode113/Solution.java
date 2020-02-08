package leetcode.leetcode113;

import java.util.*;

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


class Solution {
    Map<TreeNode, TreeNode> route = new LinkedHashMap<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new LinkedList<>();
        if(root != null){
            helper(root, sum, 0, results);
        }
        return results;
    }

    private void helper(TreeNode node, int sum, int current, List<List<Integer>> results){
        current += node.val;

        // if(current > sum) return;

        if(node.left == null && node.right == null){
            if(sum == current){
                LinkedList<Integer> list = new LinkedList<>();
                while(node != null){
                    list.addFirst(node.val);
                    node = route.get(node);
                }
                results.add(list);
            }
            return;
        }

        if(node.left != null){
            route.put(node.left, node);
            helper(node.left, sum, current, results);
        }

        if(node.right != null){
            route.put(node.right, node);
            helper(node.right, sum, current, results);
        }
    }
}

// 参考方法： https://leetcode-cn.com/problems/path-sum-ii/solution/zai-suo-you-java-ti-jiao-zhong-ji-bai-liao-10000-2/
class Solution_ {
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> inner = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return list;
        sum -= root.val;
        inner.add(root.val);  // 入列表
        if (root.left == null && root.right == null){
            if (sum == 0){
                list.add(new ArrayList<>(inner));  // 记得拷贝一份
            }

        }
        if (root.left != null)  pathSum(root.left, sum);
        if (root.right != null)  pathSum(root.right, sum);
        inner.remove(inner.size()-1);  //从列表中删除
        return list;
    }
}

// @lc code=end

