package leetcode.leetcode15;

import java.util.*;

public class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<3) return res;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int L = i+1;
            int R = nums.length-1;
            while(L<R){
                int sum = nums[i]+nums[L]+ nums[R];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[L], nums[R]));
                    while(L<R && nums[L]==nums[L+1]) L++; // 去重
                    while(L<R && nums[R]==nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if(sum>0) R--;
                else if(sum<0) L++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{0,0,0};
        // int[] nums = new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        Solution s = new Solution();
        List<List<Integer>> res = s.threeSum(nums);
        for(List<Integer> items : res){
            System.out.printf("[%d,%d,%d],", items.get(0), items.get(1), items.get(2));
        }
        System.out.println();
    }
}