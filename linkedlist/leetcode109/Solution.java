package leetcode.leetcode109;


/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (69.42%)
 * Likes:    131
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 23.4K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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

// 提交到leetcode需要把ListNode和TreeNode注释掉
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTreeNode(head, null);
    }

    private TreeNode buildTreeNode(ListNode begin, ListNode end){
        if(begin == end) return null;

        ListNode slow = begin;
        ListNode fast = begin;

        // while(fast.next != end && fast.next.next != end){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        while(fast != end && fast.next != end && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = buildTreeNode(begin, slow);
        root.right = buildTreeNode(slow.next, end);

        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(-10);
        ListNode n1 = new ListNode(-3);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(9);

        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Solution s = new Solution();

        TreeNode r = s.sortedListToBST(root);
        System.out.println(r.val);
    }
}
// @lc code=end