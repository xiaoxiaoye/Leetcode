package leetcode.extension;

public class BagSolution {
    private int maxWeight = Integer.MIN_VALUE;
    private int count = 0;

    private boolean[][] mem = new boolean[5][10];

    public int solution(int[] weight, int limit) {
        long t = System.currentTimeMillis();
        // f(0, 0, weight, limit);
        // f1(0, 0, weight, limit);
        // f2(weight, limit);
        f3(weight, limit);
        System.out.println("cost " + (System.currentTimeMillis() - t) + "ms" + ",f_count:" + count);
        return maxWeight;
    }

    // 利用递归
    private void f(int n, int cw, int[] weight, int limit) {
        count++;
        if (n == weight.length || cw == limit) {
            if (cw > maxWeight)
                maxWeight = cw;
            return;
        }

        f(n + 1, cw, weight, limit);
        if (cw + weight[n] <= limit) {
            f(n + 1, cw + weight[n], weight, limit);
        }
    }

    // 递归优化，减少递归次数
    private void f1(int n, int cw, int[] weight, int limit) {
        count++;
        if (n == weight.length || cw == limit) {
            if (cw > maxWeight)
                maxWeight = cw;
            return;
        }

        if (mem[n][cw])
            return;
        mem[n][cw] = true;

        f1(n + 1, cw, weight, limit);
        if (cw + weight[n] <= limit) {
            f1(n + 1, cw + weight[n], weight, limit);
        }
    }

    // 动态规划
    private void f2(int[] weight, int limit) {
        boolean[][] states = new boolean[weight.length][limit + 1];
        states[0][0] = true;
        if (weight[0] <= limit)
            states[0][weight[0]] = true;

        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= limit; j++) {
                if (states[i - 1][j])
                    states[i][j] = true;
            }

            for (int j = 0; j <= limit - weight[i]; j++) {
                if (states[i - 1][j])
                    states[i][j + weight[i]] = true;
            }
        }

        for (int i = limit; i > 0; i--) {
            if (states[weight.length - 1][i]) {
                maxWeight = i;
                break;
            }
        }
    }

    // 动态规划优化，用一维数组保存状态
    private void f3(int[] weight, int limit) {
        boolean[] states = new boolean[limit + 1];
        states[0] = true;
        if (weight[0] <= limit)
            states[weight[0]] = true;

        for (int i = 1; i < weight.length; i++) {
            for (int j = limit - weight[i]; j >= 0; j--) {
                if (states[j])
                    states[j + weight[i]] = true;
            }
        }

        for (int i = limit; i > 0; i--) {
            if (states[i]) {
                maxWeight = i;
                break;
            }
        }
    }

    private int maxValue = Integer.MIN_VALUE;

    // 在重量限制的前提下， 价值最大
    public int solutionValue(int[] weight, int[] value, int limit) {
        // 递归求解
        // vf(0, 0, 0, weight, value, limit);

        // 动态规划
        // vf1(weight, value, limit);

        // 优化动态规划的空间复杂度
        vf2(weight, value, limit);
        return maxValue;
    }

    // 利用递归求解
    private void vf(int n, int cw, int cv, int[] weight, int[] value, int limit) {
        if (n == weight.length || cw == limit) {
            if (cv > maxValue)
                maxValue = cv;
            return;
        }
        vf(n + 1, cw, cv, weight, value, limit);
        if (cw + weight[n] <= limit) {
            vf(n + 1, cw + weight[n], cv + value[n], weight, value, limit);
        }
    }

    // 利用动态规划求解
    private void vf1(int[] weight, int[] value, int limit) {
        int[][] states = new int[weight.length][limit + 1];
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < limit + 1; j++) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        if (weight[0] <= limit) {
            states[0][weight[0]] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < limit + 1; j++) {
                // 不选择第i个物品
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 选择第i个物品
            for (int j = 0; j <= limit - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }

        for (int i = limit; i >= 0; i--) {
            if (states[weight.length - 1][i] > maxValue) {
                maxValue = states[weight.length - 1][i];
            }
        }
    }

    // 优化动态规划空间复杂度
    private void vf2(int[] weight, int[] value, int limit) {
        int[] states = new int[limit + 1];

        states[0] = 0;
        if (weight[0] <= limit) {
            states[weight[0]] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = limit - weight[i]; j >= 0; j--) {
                if(states[j]>=0){
                    int v = states[j]+value[i];
                    if(v>states[j+weight[i]]){
                        states[j+weight[i]] = v;
                    }
                }
            }
        }

        for(int i=0; i<=limit;i++){
            if(states[i] > maxValue){
                maxValue = states[i];
            }
        }
    }

    public static void main(String[] args) {
        BagSolution solution = new BagSolution();
        int v = solution.solution(new int[] { 2, 2, 4, 6, 3 }, 9);
        System.out.println(v);

        System.out.println("==============================");

        int mv = solution.solutionValue(new int[] { 2, 2, 4, 6, 3 }, new int[] { 3, 4, 8, 9, 6 }, 9);
        System.out.println(mv);
    }
}
