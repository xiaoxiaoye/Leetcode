package leetcode.leetcode28;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        char[] a = haystack.toCharArray();
        int n = haystack.length();
        char[] b = needle.toCharArray();
        int m = needle.length();

        return bm(a, n, b, m);
    }

    // BM算法
    private int bm(char[] a, int n, char[] b, int m){
        int[] bc = new int[256];
        generateBC(b, m, bc);

        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, prefix, suffix);
        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            while (j >= 0 && a[i + j] == b[j])
                j--;
            if (j == -1)
                return i;

            int x = j - bc[(int) a[i + j]];
            int y = 0;
            if(j < m -1){
                y = moveGS(m, j, suffix, prefix);
            }

            i = i + Math.max(x, y);
        }

        return -1;
    }

    // 坏字符规则
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < bc.length; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            bc[(int)b[i]] = i;
        }
    }

    private int moveGS(int m, int j, int[] suffix, boolean[] prefix){
        int k = m -1 - j;
        if(suffix[k] != -1) return j - suffix[k] + 1;
        for(int i = j+2; i < m; i++){
            if(prefix[m - i]) return i;
        }
        return m;
    }

    // 好后缀规则
    private void generateGS(char[] b, int m, boolean[] prefix, int[] suffix) {
        for(int i = 0; i < m; i++){
            prefix[i] = false;
            suffix[i] = -1;
        }

        for(int i = 0; i < m-1; i++){
            int j = i;
            int k = 0;
            while(j >= 0 && b[m-1-k] == b[j]){
                j--;
                k++;
                suffix[k] = j+1;
            }
            if(j == -1){
                prefix[k] = true;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int r1 = s.strStr("hello", "ll");
        System.out.println(r1);

        int r2 = s.strStr("aaaaa", "baa");
        System.out.println(r2);

        int r3 = s.strStr("mississippi", "pi");
        System.out.println(r3);
    }
}