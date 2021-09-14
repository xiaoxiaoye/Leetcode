package leetcode.offer14;

class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(Math.max((j * (i - j)) % 1000000007, (j * dp[i - j]) % 1000000007), curMax);
            }
            dp[i] = curMax;
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        int r = s.cuttingRope(2);
//        System.out.println(r);

        int n = (int)Math.pow(10, 19);
        System.out.println(n);
    }
}
