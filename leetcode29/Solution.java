package leetcode.leetcode29;

class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int count = 0;
        if(dividend < 0) dividend = -dividend;
        if(divisor < 0 ) divisor = -divisor;
        while(dividend > divisor){
            divisor  = divisor << 1;
            count++;
        }
        long result = 0;
        while(count > 0){
            count--;
            divisor = divisor >> 1;

            if(divisor <= dividend){
                result += 1 << count;
                dividend -= divisor;
            }
        }
        if(sign) result = -result;

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) result = Integer.MAX_VALUE;

        return (int)result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int r1 = s.divide(10, 3);
        // System.out.println(r1);

        int r2 = s.divide(7, -3);
        System.out.println(r2);
    }
}