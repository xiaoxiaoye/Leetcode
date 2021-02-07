package leetcode.extension;

public class Sort {
    // 快排
    public void quickSort(int[] nums){
        quickSortR(nums, 0, nums.length-1);
    }

    private void quickSortR(int[] nums, int p, int r){
        if(p>=r) return;

        int q = partition(nums, p, r);
        quickSortR(nums, p, q-1);
        quickSortR(nums, q+1, r);
    }

    private int partition(int[] nums, int p, int r){
        int pivot = nums[r];
        int i=p;
        for(int j=p; j<r;j++){
            if(nums[j]<=pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int p, int q){
        int tmp=nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    // 寻找数组中第K大的元素
    public int findKth(int[] nums, int K){
        return quickSortK(nums, 0, nums.length-1, K);
    }

    private int quickSortK(int[] nums, int p, int r, int K){
        int q = partition(nums, p, r);
        if(q==nums.length-K) {
            return nums[nums.length - K];
        } else if(q<nums.length-K){
            return quickSortK(nums, q+1, r, K);
        } else {
            return quickSortK(nums, p, q-1, K);
        }
    }

    // 归并排序
    public void mergeSort(int[] nums){

    }

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] nums = new int[]{2,1,4,9,8};
        // s.quickSort(nums);
        // System.out.println(Arrays.toString(nums));

        int kth = s.findKth(nums, 2);
        System.out.println(kth);
    }
}
