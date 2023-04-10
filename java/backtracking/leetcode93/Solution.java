package leetcode.backtracking.leetcode93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (51.15%)
 * Likes:    506
 * Dislikes: 0
 * Total Accepted:    99.7K
 * Total Submissions: 193K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是
 * "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 
 * 
 * 示例 3：
 * 
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 
 * 
 * 示例 4：
 * 
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 
 * 
 * 示例 5：
 * 
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * 
 * 
 */

// @lc code=start
class Solution {
    private ArrayList<String> results = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        char[] arr = s.toCharArray();
        helper(arr, 0, new LinkedList<>());
        return results;
    }

    private void helper(char[] arr, int pos, LinkedList<Integer> route) {
        if (route.size() == 4) {
            if (pos == arr.length) {
                results.add(buildIpAddress(route));
            }
            return;
        }
        // 剪枝
        if(!route.isEmpty() && (4-route.size())*3 < (arr.length-pos)) return;
        for (int i = 1; i <= 3; i++) {
            int seg = getNext(arr, pos, i);
            /**
             * 过滤如下IP段:
             * 1. 不在0~255范围内
             * 2. 带有前缀0
             */
            if (seg > 255 || seg<0 || (i>1 && arr[pos]=='0')) continue;

            route.addLast(seg);
            helper(arr, pos + i, route);
            route.removeLast();
        }
    }

    private String buildIpAddress(LinkedList<Integer> route) {
        StringBuilder builder = new StringBuilder();
        for (Integer r : route) {
            builder.append(r);
            builder.append('.');
        }
        return builder.substring(0, builder.length() - 1);
    }

    private int getNext(char[] arr, int begin, int count) {
        if(begin+count>arr.length) return -1;
        int val = 0;
        for (int i = 0; i < count; i++) {
            val = val * 10 + (arr[begin + i] - '0');
        }
        return val;
    }
}
// @lc code=end

