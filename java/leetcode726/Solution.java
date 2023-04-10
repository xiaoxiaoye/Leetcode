package leetcode.leetcode726;

import java.util.*;

class Solution {
    private int pos = 0;
    private String formula;
    public String countOfAtoms(String formula) {
        this.pos = 0;
        this.formula = formula;

        Map<String, Integer> map = new HashMap<>();
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(map);
        recursiveAtom(stack);
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,Integer> entry: treeMap.entrySet()){
            builder.append(entry.getKey());
            if(entry.getValue()>1){
                builder.append(entry.getValue());
            }
        }
        return builder.toString();
    }

    private void recursiveAtom(Deque<Map<String, Integer>> stack){
        while(pos<formula.length()){
            if(formula.charAt(pos) == '('){
                stack.push(new HashMap<>());
                pos++;
                recursiveAtom(stack);
            } else if(formula.charAt(pos) == ')'){
                pos++;
                int num = parseNum();
                Map<String, Integer> map = stack.pop();
                for(Map.Entry<String, Integer> entry: map.entrySet()){
                    stack.peek().put(entry.getKey(), stack.peek().getOrDefault(entry.getKey(), 0)+entry.getValue()*num);
                }
                return;
            } else {
                String c = parseAtom();
                int num = parseNum();
                stack.peek().put(c, stack.peek().getOrDefault(c, 0)+num);
            }
        }
    }

    private int parseNum(){
        int num = 0;
        while(pos<formula.length() && Character.isDigit(formula.charAt(pos))){
            num = num*10+(formula.charAt(pos++)-'0');
        }
        return num==0 ? 1 : num;
    }

    private String parseAtom(){
        StringBuilder builder = new StringBuilder();
        builder.append(formula.charAt(pos++));
        while(pos<formula.length() && Character.isLowerCase(formula.charAt(pos))){
            builder.append(formula.charAt(pos++));
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String r = s.countOfAtoms("Be32");
        System.out.println(r);
    }
}
