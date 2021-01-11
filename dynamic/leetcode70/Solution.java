package leetcode.dynamic.leetcode70;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> sMap = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int c1;
        if(sMap.containsKey(n-1)){
            c1 = sMap.get(n-1);
        }else{
            c1 = climbStairs(n-1);
            sMap.put(n-1, c1);
        }

        int c2;
        if(sMap.containsKey(n-2)){
            c2 = sMap.get(n-2);
        }else{
            c2 = climbStairs(n-2);
            sMap.put(n-2, c2);
        }
        return c1+c2;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        int param1 = s.climbStairs(2);
        System.out.println(param1);

        long begin = System.currentTimeMillis();
        int param2 = s.climbStairs(50);
        long end = System.currentTimeMillis();
        System.out.println("total:" + param2 + " cost: " + (end-begin) + "ms");
    }
}