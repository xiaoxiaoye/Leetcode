package leetcode.extension;

/**
 * 淘宝的“双十一”购物节有各种促销活动，比如“满 100 元减 20 元”。
 * 假设你女朋友的购物车中有 n 个（n>100）想买的商品，她希望从里面选几个，
 * 在凑够满减条件的前提下，让选出来的商品价格总和最大程度地接近满减条件（200 元），
 * 这样就可以极大限度地“薅羊毛”。
 */
public class BestDiscount {
    public void solution(int[] items, int threshold) {
        int limit = threshold * 3;
        boolean[][] states = new boolean[items.length][limit + 1];
        states[0][0] = true;
        if (items[0] <= limit) {
            states[0][items[0]] = true;
        }

        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j <= limit; j++) {
                if (states[i - 1][j])
                    states[i][j] = true;
            }

            for (int j = 0; j <= limit - items[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + items[i]] = true;
                }
            }
        }

        // 寻找最小的可行解
        int j = threshold;
        for (; j < limit + 1; j++) {
            if (states[items.length - 1][j])
                break;
        }

        // 没有可行解
        if (j == limit + 1)
            return;

        for (int i = items.length - 1; i >= 1; i--) {
            // states[i][j] 只能从states[i-1][j]和states[i-1][j-items[i]]
            // states[i-1][j]代表第i个物品没有选到
            // states[i-1][j-items[i]]代表第i个物品选到
            if(j-items[i]>=0 && states[i-1][j-items[i]]){
                System.out.println(i + ":" + items[i] + ",");
                j = j-items[i];
            }
        }

        // 第一个物品没有前置推导
        if(j != 0) System.out.println(0 + ":" + items[0]);
    }

    public static void main(String[] args) {
        BestDiscount discount = new BestDiscount();
        discount.solution(new int[]{20,40,21,50,90,22}, 100);
    }
}
