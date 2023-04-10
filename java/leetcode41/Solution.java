package leetcode.leetcode41;


// 参考https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
// 利用桶排序的思想
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {  // 这里不用nums[i] != i+1 是因为当输入为[1,1]时会陷入死循环
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] t = new int[] { 1,1 };
        int r = s.firstMissingPositive(t);
        System.out.println(r);
    }
}