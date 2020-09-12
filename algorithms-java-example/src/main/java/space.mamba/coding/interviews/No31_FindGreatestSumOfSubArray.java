package space.mamba.coding.interviews;


import java.util.Arrays;

/**
 * @author byte mamba
 * <p>
 * 连续子数组的最大和
 * <p>
 * <p>
 * 例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，
 * 最大的子数组为｛3, 10, -4, 7, 2}。
 * 因此输出为该子数组的和18
 * <p>
 * 参考：
 * https://blog.csdn.net/DERRANTCM/article/details/46736967
 */
public class No31_FindGreatestSumOfSubArray {

    public static void main(String[] args) {

        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(arr));

        int[] arr2 = {-2, -4, -5, -1, -9};
        System.out.println(findGreatestSumOfSubArray(arr2));
        System.out.println("### dp ");
        System.out.println(findGreatestSumOfSubArray2_dp(arr));
        System.out.println(findGreatestSumOfSubArray2_dp(arr2));
    }

    public static int findGreatestSumOfSubArray(int[] arr) {

        // 参数校验
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Array must contain an element");
        }

        int[] maxSubArray = new int[arr.length];
        // 记录最大的子数组和，开始时是最小的整数
        int max = Integer.MIN_VALUE;
        // 当前的和，这里 0 和下面的判断很重要！！！
        int curMax = 0;
        // 数组遍历
        for (int i = 0; i < arr.length; i++) {
            if (curMax <= 0) {
                curMax = arr[i];
                //  maxSubArray = new int[arr.length];
                //  maxSubArray[i] = arr[i];
            } else {
                curMax += arr[i];
                //  maxSubArray[i] = arr[i];
            }

            // 更新记录到的最在的子数组和
            if (max < curMax) {
                max = curMax;
            }
        }

        // System.out.println("sub max len array "+ Arrays.toString(maxSubArray));
        return max;
    }

    /**
     * 动态规划实现
     */
    public static int findGreatestSumOfSubArray2_dp(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        // 新建动态规划数组
        int[] dp = new int[arr.length + 1];
        // 由于下方遍历从1开始，先写入第一个数进dp[0]
        dp[0] = arr[0];
        // 设置最大值：由于最开始的是 arr[0]，后面如果是负数肯定更小，如果是整数肯定变大
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // 状态转移方程
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);

            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }

        return maxSum;
    }


}
