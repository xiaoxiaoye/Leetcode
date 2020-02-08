package leetcode.leetcode150;

import java.util.HashSet;

// 栈实现
class StackC{
    private int[] data;
    private int n;
    private int count;

    public StackC(int n){
        this.n = n;
        this.data = new int[n];
        this.count = 0;
    }

    public boolean add(int item){
        if(count==n) return false;
        data[count] = item;
        count++;
        return true;
    }

    public int pop(){
        int res = -1;
        if(count <= 0) return res;
        res = data[count-1];
        count--;
        return res;
    }
}

public class Solution{
    public int evalRPN(String[] tokens) {
        HashSet<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        StackC stack = new StackC(tokens.length);
        for(String token : tokens){
            if(operators.contains(token)){
                int res = 0;
                int right = stack.pop();
                int left = stack.pop();
                switch (token) {
                    case "+":
                        res += left+right;
                        break;
                    case "-":
                        res += left-right;
                        break;
                    case "*":
                        res += left*right;
                        break;
                    case "/":
                        res += left/right;
                        break;
                    default:
                        break;
                }
                stack.add(res);
            }else {
                int t = Integer.parseInt(token);
                stack.add(t);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] case1 = new String[]{"4", "13", "5", "/", "+"};
        int r1 = s.evalRPN(case1);
        System.out.println(r1);

        String[] case2 = new String[]{"2", "1", "+", "3", "*"};
        int r2 = s.evalRPN(case2);
        System.out.println(r2);

        String[] case3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int r3 = s.evalRPN(case3);
        System.out.println(r3);
    }
}