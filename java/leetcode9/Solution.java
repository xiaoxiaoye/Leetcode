package leetcode.leetcode9;

// https://leetcode-cn.com/problems/palindrome-number/solution/
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int tmp = x;
        long reserve = 0;
        while(tmp != 0){
            reserve = reserve * 10 + tmp % 10;
            tmp /= 10;
        }
        return reserve == x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r1 = s.isPalindrome(121);
        System.out.println(r1);

        boolean r2 = s.isPalindrome(-121);
        System.out.println(r2);
    }
}