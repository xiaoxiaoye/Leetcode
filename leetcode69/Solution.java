package leetcode.leetcode69;

class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        long middle = 0;
        while(low <= high){
            middle = low + ((high-low)>>1);
            long square = middle * middle;
            if(square <= x){
                if(middle == x || (middle+1) * (middle+1) > x){
                    return (int)middle;
                } else {
                    low = middle+1;
                }
            } else {
                high = middle - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.mySqrt(2147395599);
        System.out.println(r1);
    }
}