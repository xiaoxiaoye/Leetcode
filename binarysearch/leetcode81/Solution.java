package leetcode.binarysearch.leetcode81;

class Solution {
    public boolean search(int[] nums, int target) {
        return search_(nums, target) != -1;
    }

    public int search_ (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            // [1,0,1,1,1] 此处无法区分那边有序，需要两端同时收缩
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            } else if(nums[left] < nums[mid]){ // 左侧有序
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if(nums[mid]< target && target<= nums[right]){ // 右侧有序
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r = s.search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 13);
        System.out.println(r);
    }
}
