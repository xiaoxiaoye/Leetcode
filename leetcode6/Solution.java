package leetcode.leetcode6;

import java.util.ArrayList;;

/**
https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
解释:
L   C   I   R
E T O E S I I G
E   D   H   N

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G
*/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        ArrayList<Character> cs[] = new ArrayList[numRows];
        for(int i = 0; i < numRows; i++){
            cs[i] = new ArrayList<>();
        }

        int index = 0;
        boolean reserve = false;
        for(char c : s.toCharArray()){
            cs[index].add(c);
            if(reserve){
                if(index == 0){
                    reserve = false;
                    index++;
                    continue;
                }
                index--;
            } else {
                if(index == numRows-1){
                    reserve = true;
                    index--;
                    continue;
                }
                index++;
            }
        }

        StringBuilder b = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < cs[i].size(); j++){
                b.append(cs[i].get(j));
            }
        }
        return b.toString();
    }

    // 官方题解更简单的写法
    public String convert_(String s, int numRows) {
        if(numRows == 1) return s;

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }
        boolean goingDown = false;
        int curRow = 0;
        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        String r1 = s.convert_("LEETCODEISHIRING", 3);
        System.out.println(r1 + " " + (r1.equals("LCIRETOESIIGEDHN")));

        String r2 = s.convert_("LEETCODEISHIRING", 4);
        System.out.println(r2 + " " + r2.equals("LDREOEIIECIHNTSG"));
    }
}