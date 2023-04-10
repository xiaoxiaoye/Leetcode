package leetcode.leetcode11;

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while(i < j){
            int h = height[i] > height[j] ? j : i;
            int tmpArea = height[h] * (j - i);
            if(tmpArea > maxArea) maxArea = tmpArea;
            if(h == i){
                while(true){
                    i++;
                    if(i <= j || height[i-1] < height[i]) break;
                }
            } else {
                while(true){
                    j--;
                    if(i <= j || height[j+1] < height[j]) break;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(r1);
    }
}