package leetcode.leetcode169;

import java.util.HashMap;

public class Solution{
    // 通过散列表统计每个数的出现次数，返回次数最大的那个数
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        int maxNum = 0;
        for(int num : nums){
            int count = counts.getOrDefault(num, 0)+1;
            counts.put(num, count);
            if(maxCount<count){
                maxCount = count;
                maxNum = num;
            }
        }
        return maxNum;
    }

    // 摩尔投票法
    public int majorityElementBM(int[] nums){
        int count = 0;
        Integer candidate = null;
        for(int i: nums){
            if(candidate == null){
                candidate = i;
                count++;
                continue;
            }
            if(candidate == i){
                count++;
            }else {
                if(--count == 0) candidate = null;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] case1 = new int[]{3,3,4};
        int r = s.majorityElementBM(case1);
        System.out.println(r);
    }
}