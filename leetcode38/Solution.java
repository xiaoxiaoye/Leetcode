package leetcode.leetcode38;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (53.56%)
 * Likes:    348
 * Dislikes: 0
 * Total Accepted:    61.8K
 * Total Submissions: 115.4K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String preValue = "1";
        for(int i=0; i < n-1;i++){
            preValue = next(preValue);
        }
        return preValue;
    }

    private String next(String s) {
        StringBuilder builder = new StringBuilder();
        char preValue = s.charAt(0);
        int count=1;
        for(int i=1; i < s.length(); i++){
            if(preValue == s.charAt(i)){
                count++;
            } else {
                builder.append(count);
                builder.append(preValue);
                preValue = s.charAt(i);
                count = 1;
            }
        }
        builder.append(count);
        builder.append(preValue);

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String c2 = s.countAndSay(5);
        System.out.println(c2);
    }
}
// @lc code=end

