package leetcode.offer16;

public class Solution {
    // 通过递归求解
    public double myPow_(double x, int n) {
        if(x==0||x==1){
            return x;
        }
        if(n==0){
            return 1.0;
        }
        long p = (long) n;
        if (p < 0) {
            p = -p;
        }

        double res = pow(x, p);
        return n>0?res:1/res;
    }

    private double pow(double x, long n){
        if(n == 1) {
            return x;
        }
        long mid = n/2;
        double res = pow(x, mid);
        if(n%2==1){
            return res*res*x;
        } else {
            return res*res;
        }
    }

    public double myPow(double x, int n) {
        if(x==0||x==1){
            return x;
        }
        if(n==0){
            return 1.0;
        }
        long p = (long) n;
        if (p < 0) {
            p = -p;
        }

        double res = 1.0;
        while (p>0){
            if((p&1)==1){
                res *= x;
            }
            x *= x;
            p >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        double r = s.myPow(2.0, 10);
        System.out.println(r);
    }

}