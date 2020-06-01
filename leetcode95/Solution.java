package leetcode.leetcode95;

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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// @lc code=start
class Solution {
    private List<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i-1);
            List<TreeNode> rightTrees = helper(i+1, end);

            for (TreeNode rNode : rightTrees) {
                for (TreeNode lNode : leftTrees) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = lNode;
                    currentNode.right = rNode;

                    allTrees.add(currentNode);
                }
            }
        }

        return allTrees;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return Collections.emptyList();
        }
        
        return helper(1, n);
    }
}
// @lc code=end

