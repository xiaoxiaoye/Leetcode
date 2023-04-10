package leetcode.offer40;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length <= k){
            return arr;
        }
        for (int i = arr.length / 2; i >= 0; i--) {
            shiftDown(arr, i, arr.length - 1);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            swap(arr, 0, arr.length - 1 - i);
            shiftDown(arr, 0, arr.length - 2 - i);
        }
        return result;
    }

    private void shiftDown(int[] arr, int pos, int end) {
        while (pos <= end) {
            int parent = pos;
            if (parent * 2 + 1 <= end && arr[parent * 2 + 1] < arr[pos]) {
                pos = parent * 2 + 1;
            }
            if (parent * 2 + 2 <= end && arr[parent * 2 + 2] < arr[pos]) {
                pos = parent * 2 + 2;
            }
            if (pos == parent) {
                break;
            }
            swap(arr, parent, pos);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.getLeastNumbers(new int[]{3,2,1}, 2);
        System.out.println(Arrays.toString(r));
    }

}