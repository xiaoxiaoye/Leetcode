package leetcode.leetcode151;

import java.util.Stack;

class Solution {
    public String reverseWordsSlow(String s) {
        if(s.length() <= 1) return s;
        s += " ";
        
        Stack<String> stack = new Stack<>();

        int i = 0;
        while(s.charAt(i) == ' ') i++;

        int tmp = i;
        for(; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                stack.push(s.substring(tmp, i));
                while(i < s.length() && s.charAt(i) == ' ') i++;
                tmp = i;
            }
        }

        String res = "";
        while(!stack.isEmpty()){
            res += stack.pop();
            res += " ";
        }
        if(res.length() == 0) return res;
        return res.substring(0, res.length()-1);
    }

    public String reverseWords(String s) {
        String trimStr = s.trim();
        if ("".equals(trimStr)) {
            return "";
        }
        char[] charArray = trimStr.toCharArray();
        StringBuilder sb = new StringBuilder(charArray.length + 1);
        int left = charArray.length;
        int right = charArray.length;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (' ' == charArray[i]) {
                // 出现多个空格，需要挪动left right，且不需要追加字符串
                if (left != right) {
                    sb.append(charArray, left, right - left).append(" ");
                }
                right = i;
                left = i;
                continue;
            }
            left = i;
        }
        if (left != right) {
            sb.append(charArray, left, right - left);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String param_1 = "the sky is blue";
        String r1 = s.reverseWords(param_1);
        System.out.println(r1);


        String param_2 = "  hello world!  ";
        String r2 = s.reverseWords(param_2);
        System.out.println(r2);

        String param_3 = "a good   example";
        String r3 = s.reverseWords(param_3);
        System.out.println(r3);
    }
}