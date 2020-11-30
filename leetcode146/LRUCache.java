package leetcode.leetcode146;

// /**
//  * @lc app=leetcode.cn id=146 lang=java
//  *
//  * [146] LRU缓存机制
//  *
//  * https://leetcode-cn.com/problems/lru-cache/description/
//  *
//  * algorithms
//  * Medium (44.66%)
//  * Likes:    792
//  * Dislikes: 0
//  * Total Accepted:    86.4K
//  * Total Submissions: 172.3K
//  * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
//   '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
//  *
//  * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//  * 
//  * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
//  * 写入数据 put(key, value) -
//  * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//  * 
//  * 
//  * 
//  * 进阶:
//  * 
//  * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//  * 
//  * 
//  * 
//  * 示例:
//  * 
//  * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//  * 
//  * cache.put(1, 1);
//  * cache.put(2, 2);
//  * cache.get(1);       // 返回  1
//  * cache.put(3, 3);    // 该操作会使得关键字 2 作废
//  * cache.get(2);       // 返回 -1 (未找到)
//  * cache.put(4, 4);    // 该操作会使得关键字 1 作废
//  * cache.get(1);       // 返回 -1 (未找到)
//  * cache.get(3);       // 返回  3
//  * cache.get(4);       // 返回  4
//  * 
//  * 
//  */

// @lc code=start
public class LRUCache {
    class ListNode {
        public int val;
        public int key;
    
        public ListNode next;
    
        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private ListNode dummyFirst;

    private int limitCounts;
    private int counts;

    public LRUCache(int capacity) {
        this.limitCounts = capacity;
        this.dummyFirst = new ListNode(-1, -1);
    }
    
    public int get(int key) {
        ListNode prev = dummyFirst;
        ListNode current = dummyFirst.next;
        while (current != null) {
            if (current.key == key) {
                // 找到节点后，将节点插入头结点之前
                prev.next = current.next;
                current.next = dummyFirst.next;
                dummyFirst.next = current;

                return current.val;
            }
            prev = current;
            current = current.next;
        }
        return -1;
    }

    public void put(int key, int val) {
        // 先看缓存中是否存在该节点， 有的话直接返回，并将该节点移动到头结点
        ListNode prev= null;
        ListNode current = dummyFirst;
        while (true) {
            if (current.key == key) {
                current.val = val;

                prev.next = current.next;
                current.next = dummyFirst.next;
                dummyFirst.next = current;
                return;
            }

            if (current.next == null) break;

            prev = current;
            current = current.next;
        }

        // 缓存满了，删除最后一个节点
        if (counts == limitCounts) {
           prev.next = null;
        }

        // 缓存中不存在，直接将节点添加到首节点
        ListNode node = new ListNode(key, val);
        node.next = dummyFirst.next;
        dummyFirst.next = node;
        if (++counts > limitCounts) {
            counts = limitCounts;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

