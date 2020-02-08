package leetcode.leetcode7;

class Solution {
    public int reverse(int x) {
        long ret = 0;
        while(x != 0){
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;
        return (int)ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.reverse(123);
        System.out.println(r1);

        int r2 = s.reverse(-321);
        System.out.println(r2);

        int r3 = s.reverse(120);
        System.out.println(r3);
    }
}