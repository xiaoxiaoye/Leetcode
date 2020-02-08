package leetcode.leetcode4;

/*
* https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
*
* 1.首先，让我们在任一位置 i 将 A(长度为m) 划分成两个部分：
*            leftA            |                rightA
*   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
*
* 由于A有m个元素，所以有m + 1中划分方式(i = 0 ~ m)
*
* 我们知道len(leftA) = i, len(rightA) = m - i;
* 注意：当i = 0时，leftA是空集，而当i = m时，rightA为空集。
*
* 2.采用同样的方式，将B也划分为两部分：
*            leftB            |                rightB
*   B[0],B[1],...      B[j-1] |   B[j],B[j+1],...B[n - 1]
*  我们知道len(leftA) = j, len(rightA) = n - j;
*
*  将leftA和leftB放入一个集合，将rightA和rightB放入一个集合。再把这两个集合分别命名为leftPart和rightPart。
*
*            leftPart         |                rightPart
*   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
*   B[0],B[1],...      B[j-1] |  B[j],B[j+1],...B[n - 1]
*
*   如果我们可以确认：
*   1.len(leftPart) = len(rightPart); =====> 该条件在m+n为奇数时，该推理不成立
*   2.max(leftPart) <= min(rightPart);
*
*   median = (max(leftPart) + min(rightPart)) / 2;  目标结果
*
*   要确保这两个条件满足：
*   1.i + j = m - i + n - j(或m - i + n - j + 1)  如果n >= m。只需要使i = 0 ~ m，j = (m+n+1)/2-i =====> 该条件在m+n为奇数/偶数时，该推理都成立
*   2.B[j] >= A[i-1] 并且 A[i] >= B[j-1]
*
*   注意:
*   1.临界条件：i=0,j=0,i=m,j=n。需要考虑
*   2.为什么n >= m ? 由于0 <= i <= m且j = (m+n+1)/2-i,必须确保j不能为负数。
*
*   按照以下步骤进行二叉树搜索
*   1.设imin = 0,imax = m，然后开始在[imin,imax]中进行搜索
*   2.令i = (imin+imax) / 2, j = (m+n+1)/2-i
*   3.现在我们有len(leftPart) = len(rightPart)。而我们只会遇到三种情况：
*
*      ①.B[j] >= A[i-1] 并且 A[i] >= B[j-1]  满足条件
*      ②.B[j-1] > A[i]。此时应该把i增大。 即imin = i + 1;
*      ③.A[i-1] > B[j]。此时应该把i减小。 即imax = i - 1;
*
* */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int low = 0, high;
        int[] A, B;

        // 确保A.length <= B.length,这样确保j的值大于0
        if (nums1.length <= nums2.length) {
            high = nums1.length;
            A = nums1;
            B = nums2;
        } else {
            high = nums2.length;
            A = nums2;
            B = nums1;
        }
        int i, j;
        while (low <= high) {
            i = (low + high) / 2;

            // 当总个数为偶数，不影响结果，当为奇数是，len(left_part)多一个，结果取max(left_part)即可
            j = (A.length + B.length + 1) / 2 - i; 
            if(i > low && A[i-1] > B[j]) {
                high = i - 1;
            } else if (i < high && B[j-1] > A[i]){
                low = i + 1;
            } else {
                int maxLeft = 0;
                if(i == 0) { // A[left_part]为空，那么B[left_part]肯定不为空，左边最大值为B[j-1]
                    maxLeft = B[j-1];
                } else if(j == 0){ // B[left_part]为空，那么A[left_part]肯定不为空，左边最大值为A[i-1]
                    maxLeft = A[i - 1];
                } else { // A[left_part]和B[left_part]都不为空， 取A[i-1]和B[j-1]的最大值
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                // 奇数个
                if((A.length + B.length) % 2 == 1){
                    return maxLeft;
                }

                // 偶数个
                int minRight = 0;
                if(i == A.length){ // A[right_part]为空，那么B[right_part]肯定不为空， 右边最小值为B[j]
                    minRight = B[j];
                } else if(j == B.length){ // B[right_part]为空，那么A[right_part]肯定不为空，右边最小值为A[i]
                    minRight = A[i];
                } else{
                    minRight = Math.min(A[i], B[j]);// A[right_part]和B[right_part]都不为空， 取A[i-1]和B[j-1]的最小值
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arg1 = {1,3}, arg2 = {2};
        double r1 = s.findMedianSortedArrays(arg1, arg2);
        System.out.println(r1);

        int[] arg3 = { 1, 2 }, arg4 = { 3, 4 };
        double r2 = s.findMedianSortedArrays(arg3, arg4);
        System.out.println(r2);
    }
}