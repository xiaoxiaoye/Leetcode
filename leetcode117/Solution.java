package leetcode.leetcode117;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (42.87%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    12.4K
 * Total Submissions: 28.2K
 * Testcase Example:  '[1,2,3,4,5,null,7]'
 *
 * 给定一个二叉树
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// @lc code=start
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Node level = root;
        Node cur = null;
        while (true) {
            cur = level;
            while (cur != null) {
                // 找到一个当前节点子节点不为空的
                if(cur.left == null && cur.right == null){
                    cur = cur.next;
                    continue;
                }
                // 当前节点的左右节点都不为空
                if(cur.left != null && cur.right != null){
                    cur.left.next = cur.right;
                }

                Node tmpCur = cur.right == null ? cur.left : cur.right;
    
                Node next = cur.next;
                while(next != null && next.left == null && next.right == null){
                    next = next.next;
                }

                if(next != null){
                    Node tmpNext = next.left == null ? next.right : next.left;
                    tmpCur.next = tmpNext;
                }

                cur = cur.next;
            }

            // 判断当前层是否为最后一层
            while(level.left == null && level.right == null){
                level = level.next;
                if(level == null){
                    return root;
                }
            }
            level = level.left == null ? level.right:level.left;
        }
    }
}
// @lc code=end
