package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-08-21
 * <pre>
 *
 *  https://www.cnblogs.com/springfor/p/3877058.html
 *
 *  试想一下，如果我们从头遍历这个数组。对于数组中的其中一个元素，它只有两个选择：
 *
 *  1. 要么加入之前的数组加和之中（跟别人一组）
 *
 *  2. 要么自己单立一个数组（自己单开一组）
 *
 *  所以对于这个元素应该如何选择，就看他能对哪个组的贡献大。如果跟别人一组，能让总加和变大，还是跟别人一组好了；如果自己起个头一组，自己的值比之前加和的值还要大，那么还是自己单开一组好了。
 *
 * 所以利用一个sum数组，记录每一轮sum的最大值，sum[i]表示当前这个元素是跟之前数组加和一组还是自己单立一组好，然后维护一个全局最大值即位答案。
 * </pre>
 */
public class No53_maxSubArray {

    public static void main(String[] args) {
        int[] num = {-2, -1, -3, -4};
        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

       // int max = new No53_maxSubArray().maxSubArray(num);
       // System.out.println(max);

        int max2 = new No53_maxSubArray().maxSubArray2(num);
        System.out.println(max2);
    }

    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int max = nums[0];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(sum[i], max);
        }
        System.out.println("sum=" + sum[nums.length - 1]);
        return max;
    }

    /**
     * 由动态规划（中的 Kadane 算法)
     * <p>
     * Kadane算法，算法复杂度O(n)
     *
     * int[] num = {-2, -1, -3, -4};
     */
    public int maxSubArray2(int[] nums) {
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            max_ending_here += nums[i];
            max_so_far = Math.max(max_so_far, max_ending_here);
            System.out.println("##");
        }
        return max_so_far;
    }
}
