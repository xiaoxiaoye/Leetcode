package leetcode.array.leetcode128;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (52.84%)
 * Likes:    682
 * Dislikes: 0
 * Total Accepted:    98.6K
 * Total Submissions: 186.6K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 
 * 
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^9 
 * 
 * 
 */
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer integer : nums) {
            numsSet.add(integer);
        }

        int maxCount = 0;
        for (int num : numsSet) {
            if(!numsSet.contains(num-1)){
                int curCount = 1;
                while(numsSet.contains(++num)){
                    curCount++;
                }
                if(maxCount<curCount){
                    maxCount = curCount;
                }
            }
        }

        return maxCount;
    }
}
// @lc code=end


