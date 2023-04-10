package leetcode.leetcode341;

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        while(low < high){
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        char[] param_1 = new char[]{'h','e','l','l','o'};
        s.reverseString(param_1);
        System.out.println(Arrays.toString(param_1));
    }
}