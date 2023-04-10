package leetcode.tree.leetcode437;

import leetcode.common.*;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode-cn.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (56.51%)
 * Likes:    713
 * Dislikes: 0
 * Total Accepted:    62.9K
 * Total Submissions: 111.3K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 * 找出路径和等于给定数值的路径总数。
 * 
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 * 示例：
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * 返回 3。和等于 8 的路径有:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * 
 * 
 */

// @lc code=start
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathCount(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathCount(TreeNode node, int sum) {
        if (node == null)
            return 0;
        sum = sum - node.val;
        int res = sum == 0 ? 1 : 0;
        return res + pathCount(node.left, sum) + pathCount(node.right, sum);
    }
}
// @lc code=end
