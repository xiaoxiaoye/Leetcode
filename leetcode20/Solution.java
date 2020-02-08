package leetcode.leetcode20;

class StackC{
    private char[] data;
    private int n;
    private int count;

    public StackC(int n){
        this.n = n;
        this.data = new char[n];
        this.count = 0;
    }

    public boolean add(char item){
        if(count==n) return false;
        data[count] = item;
        count++;
        return true;
    }

    public char pop(){
        char res = '\0';
        if(count <= 0) return res;
        res = data[count-1];
        count--;
        return res;
    }

    public int length(){
        return count;
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        StackC stack = new StackC(s.length());
        char[] cs = s.toCharArray();
        for(char c : cs){
            if(c == '{' || c == '[' || c == '('){
                stack.add(c);
            } else if(c == '}' || c == ']' || c == ')'){
                char ec = stack.pop();
                if(c == '}' && ec != '{'){
                    return false;
                } else if(c == ']' && ec != '['){
                    return false;
                } else if(c == ')' && ec != '('){
                    return false;
                }
            }
        }
        return stack.length()==0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String case1 = new String("[");
        boolean r = s.isValid(case1);
        System.out.println(r);
    }
}