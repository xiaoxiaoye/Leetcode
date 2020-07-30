package leetcode.leetcode49;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (59.48%)
 * Likes:    388
 * Dislikes: 0
 * Total Accepted:    86.7K
 * Total Submissions: 138.8K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return Collections.emptyList();
        }
        
        Map<String, List<String>> result = new HashMap<>();

        for (String string : strs) {
            char[] s = string.toCharArray();
            Arrays.sort(s);
            String sortedStr = String.valueOf(s);

            if (result.containsKey(sortedStr)) {
                result.get(sortedStr).add(string);
            } else {
                result.put(sortedStr, new LinkedList<>(Arrays.asList(string)));
            }
        }
        return new LinkedList<>(result.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> r1 = s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(r1);
    }
}

// @lc code=end
