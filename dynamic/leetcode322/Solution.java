package leetcode.dynamic.leetcode322;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (42.21%)
 * Likes:    1006
 * Dislikes: 0
 * Total Accepted:    168.6K
 * Total Submissions: 399.4K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：coins = [1], amount = 2
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] mem;
    public int coinChange_(int[] coins, int amount) {
        mem = new int[amount+1];
        for (int i = 0; i < amount+1; i++) {
            mem[i] = 0;
        }
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount <0)return -1;
        if(mem[amount] != 0)
            return mem[amount];

        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int sub = dp(coins, amount-coins[i]);
            if(sub < 0) continue;
            minCount = Math.min(minCount, sub+1);
        }

        if(minCount == Integer.MAX_VALUE) minCount = -1;
        mem[amount] = minCount;
        return minCount;
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] < 0) continue;

                dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        if(dp[amount] == amount+1) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.coinChange(new int[]{1,2,5}, 11);
        System.out.println(res);
    }
}
// @lc code=end

