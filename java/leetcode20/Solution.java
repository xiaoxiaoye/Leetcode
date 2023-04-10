package leetcode.leetcode20;

import java.util.*;

class Solution {
    private final static Map<Character, Character> cacheMap = new HashMap<>();
    static {
        cacheMap.put('{', '}');
        cacheMap.put('[', ']');
        cacheMap.put('(', ')');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (cacheMap.containsKey(c)) {
                stack.push(c);
            } else {
                // 这里需要判断栈是否已经为空， 为空，然后下个字符是右括号，说明括号不匹配
                if (stack.isEmpty()) {
                    return false;
                }
                Character l = stack.pop();
                if (!cacheMap.get(l).equals(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String case1 = new String("[");
        boolean r = s.isValid(case1);
        System.out.println(r);
    }
}