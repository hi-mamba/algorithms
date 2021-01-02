package space.mamba.leetcode.algorithms;

/**
 * @author mamba
 * @date 2021/1/1 18:39
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 只需要遍历一次数组，用一个变量记录遍历过数中的最小值，然后每次计算当前值和这个最小值之间的差值最为利润，
 * 然后每次选较大的利润来更新。当遍历完成后当前利润即为所求
 *
 * 马后炮
 *
 * <p>
 * 滑动窗口
 */
public class No121_Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        No121_Best_Time_to_Buy_and_Sell_Stock obj = new No121_Best_Time_to_Buy_and_Sell_Stock();
        int[] arr = {7,1,5,3,6,4};
        int value = obj.maxProfit(arr);
        System.out.println(value);
        System.out.println(obj.maxProfit2(arr));

        System.out.println("### ");
        int[] arr2 = {7,6,4,3,1};
        int value2 = obj.maxProfit(arr2);
        System.out.println(value2);
    }


    public int maxProfit(int[] prices) {
        //不进行任何交易，即最大利益为0
        int bestTimeSellStock = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                //下一次开盘价格小于购买的价格
                if (prices[i] > prices[j]) {
                    continue;
                } else {
                    //
                    int temp = prices[j] - prices[i];
                    if (temp > bestTimeSellStock) {
                        bestTimeSellStock = temp;
                    }
                }
            }
        }
        return bestTimeSellStock;
    }

    /**
     * 优化后
     * 时间复杂度 O(n)
     * */
    public int maxProfit2(int[] prices) {
        //不进行任何交易，即最大利益为0
        int bestTimeSellStock = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (min < prices[i] && bestTimeSellStock < prices[i] - min) {
                bestTimeSellStock = prices[i] - min;
            }
        }
        return bestTimeSellStock;
    }

    /**
     * 优化后
     * https://www.cnblogs.com/grandyang/p/4280131.html
     * */
    public int maxProfit3(int[] prices) {
        //不进行任何交易，即最大利益为0
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            //谁小买谁
            buy = Math.min(buy, price);
            //查看价格比较,取最大
            res = Math.max(res,price - buy);
        }
        return res;
    }
}
