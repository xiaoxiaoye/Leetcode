package leetcode.tree.leetcode95;

import leetcode.common.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (60.39%)
 * Likes:    277
 * Dislikes: 0
 * Total Accepted:    18.9K
 * Total Submissions: 30.8K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return Collections.emptyList();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end){
        List<TreeNode> results = new LinkedList<>();
        if(start>end) {
            // 为下方遍历正常运行，需要放入null
            results.add(null);
            return results;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = helper(start, i-1);
            List<TreeNode> rights = helper(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    results.add(node);
                }
            }
        }
        return results;
    }
}
// @lc code=end

