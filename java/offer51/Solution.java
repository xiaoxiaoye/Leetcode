package leetcode.offer51;

import java.util.Arrays;

class Solution {
//    int[] nums, tmp;
//    public int reversePairs(int[] nums) {
//        this.nums = nums;
//        this.tmp = new int[nums.length];
//        return mergeSort(0, nums.length - 1);
//    }
//
//    int mergeSort(int l, int r) {
//        if (l >= r) {
//            return 0;
//        }
//
//        int mid = (l + r) / 2;
//        int res = mergeSort(l, mid) + mergeSort(mid + 1, r);
//        int i = l;
//        int j = mid + 1;
//        for (int k = l; k <= r; k++) {
//            tmp[k] = nums[k];
//        }
//
//        for (int k = l; k <= r; k++) {
//            if (i == mid + 1) {
//                nums[k] = tmp[j++];
//            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
//                nums[k] = tmp[i++];
//            } else {
//                nums[k] = tmp[j++];
//                res += mid - i + 1;
//            }
//        }
//        return res;
//    }

    int[] tmps;
    int count=0;
    public int reversePairs(int[] nums) {
        tmps = new int[nums.length];
        mergetSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return count;
    }

    private void mergetSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }

        int m = (l+r)/2;
        mergetSort(nums, l, m);
        mergetSort(nums, m+1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r){
        int i=l, j=m+1;
        int pos = l;
        while(i<=m && j<=r){
            if(nums[i]<=nums[j]){
                tmps[pos++] = nums[i++];
            } else {
                tmps[pos++] = nums[j++];
                count += m-i+1;
            }
        }
        if(i<=m){
            for(;i<=m;i++){
                tmps[pos++] = nums[i];
            }
        } else {
            for(;j<=r;j++){
                tmps[pos++] = nums[j];
            }
        }
        for(int k=l; k<=r; k++){
            nums[k] = tmps[k];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(r);
    }
}
