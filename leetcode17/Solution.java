package leetcode.leetcode17;

import java.util.*;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.63%)
 * Likes:    662
 * Dislikes: 0
 * Total Accepted:    100.3K
 * Total Submissions: 188.6K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */


// @lc code=start
class Solution {
    List<String> list = new LinkedList<>();
    Map<String, String> keyBoard = new HashMap<String, String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");

        }
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();
        helper(digits, "");
        return list;
    }

    private void helper(String digits, String combination){
        if(digits.length() == 0) {
            list.add(combination);
            return;
        };
        String d = digits.substring(0, 1);
        String letters = keyBoard.get(d);

        for (int i = 0; i < letters.length(); i++) {
            helper(digits.substring(1), combination+letters.substring(i, i+1));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> r = s.letterCombinations("23");

        System.out.println(r.toString());
    }
}
// @lc code=end

