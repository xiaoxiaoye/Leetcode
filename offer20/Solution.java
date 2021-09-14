package leetcode.offer20;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map[] stateMap = {
            new HashMap<Character, Integer>(){{put(' ', 0); put('s', 1); put('d', 2); put('.', 4);}},
            new HashMap<Character, Integer>(){{put('d', 2); put('.', 4);}},
            new HashMap<Character, Integer>(){{put('d', 2); put('.', 3); put('e', 5); put(' ', 8);}},
            new HashMap<Character, Integer>(){{put('d', 3); put('e', 5); put(' ', 8);}},
            new HashMap<Character, Integer>(){{put('d', 3);}},
            new HashMap<Character, Integer>(){{put('s', 6); put('d',7);}},
            new HashMap<Character, Integer>(){{put('d', 7);}},
            new HashMap<Character, Integer>(){{put('d', 7); put(' ', 8);}},
            new HashMap<Character, Integer>(){{put(' ', 8);}},
    };

    public boolean isNumber(String s) {
        int state = 0;
        char action;
        for (char c : s.toCharArray()) {
            if (c=='-' || c=='+'){
                action = 's';
            } else if(c>='0' && c<='9') {
                action = 'd';
            } else if(c=='e' || c=='E'){
                action = 'e';
            } else if(c == '.' || c == ' '){
                action = c;
            }else {
                action = '?';
            }
            if (!stateMap[state].containsKey(action)){
                return false;
            } else {
                state = (int)stateMap[state].get(action);
            }
        }
        return state == 2 || state == 3 || state == 7 || state == 8;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] cases = new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123"};
        for (String c: cases){
            System.out.println("[" + c + "]" + "is number: " + s.isNumber(c));
        }

        String[] cases2 = new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4", "12e+5"};
        for (String c: cases2){
            System.out.println("[" + c + "]" + "is number: " + s.isNumber(c));
        }
    }
}