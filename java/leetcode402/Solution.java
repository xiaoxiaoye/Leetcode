package leetcode.leetcode402;

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String case1 = s.removeKdigits("1432219", 3);
        System.out.println(case1);

        String case2 = s.removeKdigits("10200", 1);
        System.out.println(case2);

        String case3 = s.removeKdigits("10", 2);
        System.out.println(case3);

        String case4 = s.removeKdigits("1234567890", 9);
        System.out.println(case4);
    }
}