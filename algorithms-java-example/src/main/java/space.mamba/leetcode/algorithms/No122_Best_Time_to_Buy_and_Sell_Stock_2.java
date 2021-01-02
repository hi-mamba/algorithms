package space.mamba.leetcode.algorithms;

import org.junit.jupiter.api.Assertions;

/**
 * @author mamba
 * @date 2021/1/1 18:39
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 典型的贪心算法的思想
 *
 *
 *  这道题由于可以无限次买入和卖出。我们都知道炒股想挣钱当然是低价买入高价抛出，那么这里我们只需要从第二天开始，
 *  如果当前价格比之前价格高，则把差值加入利润中，因为我们可以昨天买入，今日卖出，若明日价更高的话，还可以今日买入，明日再抛出
 * <p>
 * 滑动窗口
 */
public class No122_Best_Time_to_Buy_and_Sell_Stock_2 {

    public static void main(String[] args) {
        No122_Best_Time_to_Buy_and_Sell_Stock_2 obj = new No122_Best_Time_to_Buy_and_Sell_Stock_2();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int value = obj.maxProfit(arr);
        System.out.println(value);
        Assertions.assertEquals(value, 7);

        System.out.println(obj.maxProfit2(arr));

        System.out.println("###");
        int[] arr2 = {1,2,3,4,5};
        int value2 = obj.maxProfit(arr2);
        System.out.println(value2);
        Assertions.assertEquals(value2, 4);

        int[] arr3 = {7,6,4,3,1};
        int value3 = obj.maxProfit(arr3);
        System.out.println(value3);
        Assertions.assertEquals(value3, 0);

    }


    public int maxProfit(int[] prices) {
        //不进行任何交易，即最大利益为0
        int bestTimeSellStock = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 对 j 进行组合（前一个 小于后一个组合，然后循环当前j 进行组合）
                //买比卖大
                if (prices[j] - prices[i] > 0) {
                    int k = j;
                    res = prices[j] - prices[i];
                    while (k < prices.length -2) {
                        if (prices[k+2] - prices[k+1] >0) {
                            res += prices[k+2] - prices[k+1];
                        }
                        k++;
                    }
                }

                if (res > bestTimeSellStock) {
                    bestTimeSellStock = res;
                }
            }
        }
        return bestTimeSellStock;
    }

    /**
     * 局部最优解
     *
     * 多买就是最大的盈利
     *
     * */
    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
