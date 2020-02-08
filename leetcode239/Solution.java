package leetcode.leetcode239;


// 练习双端队列的循环队列实现，链表实现也可以参考leetcode641
// 也可以使用库Deque
class DoubleDeque {
    // 用数组存储双端队列的数据
    int[] nums;
    // 队列长度
    int n;
    // 头部指针，指向对手元素
    int head;
    // 尾部指针，指向队尾的下一个元素
    int tail;

    DoubleDeque(int k){
        nums = new int[k+1];
        n = k+1;
        head = 0;
        tail = 0;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public boolean isFull(){
        return (tail+1)%n == head;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        // 这样可以减少判断head为负数的判断逻辑
        head = (head-1+n)%n;
        nums[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        nums[tail] = value;
        tail = (tail+1)%n;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = (head+1)%n;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail = (tail-1+n)%n;
        return true;
    }

    public int getFront(){
        return nums[head];
    }

    public int getRear(){
        int t = tail-1;
        if(t<0) t = n-1;
        return nums[t];
    }

    public static void main(String[] args) {
        DoubleDeque obj = new DoubleDeque(3);
        boolean param_1 = obj.insertLast(1);
        System.out.println(param_1);
        boolean param_2 = obj.insertLast(2);
        System.out.println(param_2);
        boolean param_3 = obj.insertFront(3);
        System.out.println(param_3);
        boolean param_4 = obj.insertLast(4);
        System.out.println(param_4);

        int param_5 = obj.getRear();
        System.out.println(param_5);
        boolean param_6 = obj.isFull();
        System.out.println(param_6);
        boolean param_7 = obj.deleteLast();
        System.out.println(param_7);
        boolean param_8 = obj.insertFront(4);
        System.out.println(param_8);
        int param_9 = obj.getFront();
        System.out.println(param_9);
    }
}

// 利用单调队列来实现复杂度为O(N)
// 实现参考：https://leetcode-cn.com/problems/sliding-window-maximum/solution/dan-diao-dui-lie-by-labuladong/
public class Solution {
    private DoubleDeque deque;
    private int[] nums;

    private void clear_deque(int i, int k){
        if(!deque.isEmpty() && i-k>=0 && deque.getFront() == nums[i-k]){
            deque.deleteFront();
        }
        while(!deque.isEmpty() && deque.getRear() < nums[i]){
            deque.deleteLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length * k == 0) return new int[0];
        if(k == 1) return nums;
        this.deque = new DoubleDeque(k);
        this.nums = nums;
        for(int i = 0; i < k; i++){
            clear_deque(i, k);
            deque.insertLast(this.nums[i]);
        }

        int[] res = new int[nums.length-k+1];
        res[0] = this.deque.getFront();

        for(int i = k; i < this.nums.length; i++){
            clear_deque(i, k);
            deque.insertLast(this.nums[i]);
            res[i-k+1] = deque.getFront();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = s.maxSlidingWindow(nums, 3);
        
        String out = "[";
        for(int num : res){
            out += num;
            out += ",";
        }
        out += "]";
        System.out.println(out);
    }
}