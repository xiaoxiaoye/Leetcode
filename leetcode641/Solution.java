package leetcode.leetcode641;

// 利用双向链表实现队头队尾O(1)的插入和删除
class MyCircularDeque {
    private class ListNode{
        private int val;
        ListNode next;
        ListNode prev;
        ListNode(int x){
            val = x;
        }
    }

    ListNode head; // 队头指针
    ListNode tail; // 队尾指针
    int count;
    int n;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.n = k;
        this.count = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.count >= this.n) return false;
        this.count++;
        ListNode node = new ListNode(value);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.count >= this.n) return false;
        this.count++;
        ListNode node = new ListNode(value);
        ListNode prev = tail.prev;
        node.next = prev.next;
        prev.next = node;
        node.next.prev = node;
        node.prev = prev;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        this.count--;
        head.next = head.next.next;
        head.next.prev = head;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        this.count--;
        ListNode prev = tail.prev.prev;
        prev.next = prev.next.next;
        prev.next.prev =prev;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return tail.prev.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.count == this.n;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(2);
        boolean param_1 = obj.insertFront(1);
        System.out.println(param_1);
        boolean param_2 = obj.insertLast(2);
        System.out.println(param_2);
        boolean param_3 = obj.deleteFront();
        System.out.println(param_3);
        boolean param_4 = obj.deleteLast();
        System.out.println(param_4);
        int param_5 = obj.getFront();
        System.out.println(param_5);
        int param_6 = obj.getRear();
        System.out.println(param_6);
        boolean param_7 = obj.isEmpty();
        System.out.println(param_7);
        boolean param_8 = obj.isFull();
        System.out.println(param_8);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */