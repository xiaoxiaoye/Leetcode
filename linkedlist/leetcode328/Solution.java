package leetcode.linkedlist.leetcode328;
import leetcode.common.ListNode;

/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 *
 * https://leetcode-cn.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (65.52%)
 * Likes:    380
 * Dislikes: 0
 * Total Accepted:    95.4K
 * Total Submissions: 145.3K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2->1->3->5->6->4->7->NULL 
 * 输出: 2->3->6->7->1->5->4->NULL
 * 
 * 说明:
 * 
 * 
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 奇数
        ListNode oddDummy = new ListNode(-1);
        ListNode oddTail = oddDummy;
        // 偶数
        ListNode evenDummy = new ListNode(-1);
        ListNode evenTail = evenDummy;

        ListNode cur = head;
        int index = 1;
        while(cur != null){
            ListNode next = cur.next;
            if((index & 1) == 0){
                cur.next = evenTail.next;
                evenTail.next = cur;
                evenTail = evenTail.next;
            } else {
                cur.next = oddTail.next;
                oddTail.next = cur;
                oddTail = oddTail.next;
            }
            index++;
            cur = next;
        }

        oddTail.next = evenDummy.next;
        return oddDummy.next;
    }
}
// @lc code=end


