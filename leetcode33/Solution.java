package leetcode.leetcode33;

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (nums[middle] == target) {
                return middle;
            }
            if (nums[low] <= nums[middle]) { // 左边有序
                if (nums[low] <= target && target < nums[middle]) { // 在有序范围内
                    high = middle - 1;
                } else { // 在无序范围内
                    low = middle + 1;
                }
            } else { // 右边有序
                if (nums[middle] < target && target <= nums[high]) { // 在有序范围内
                    low = middle + 1;
                } else { // 在无序范围内
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] c1 = { 4, 5, 6, 7, 0, 1, 2 };
        int r1 = s.search(c1, 0);
        System.out.println(r1);

        int[] c2 = { 4, 5, 6, 7, 0, 1, 2 };
        int r2 = s.search(c2, 3);
        System.out.println(r2);
    }
}