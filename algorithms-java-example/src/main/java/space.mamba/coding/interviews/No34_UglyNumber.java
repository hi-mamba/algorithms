package space.mamba.coding.interviews;

/**
 * @author mamba
 * @date 2020/6/26 14:01
 * <p>
 * 丑数的定义：
 * <p>
 * 所谓丑数，就是不能被2，3，5以外的其他素数整除的数。1，2，3，4，5，6，8，9，10，12，15是最前面的11个丑数。(1不是素数）
 */
public class No34_UglyNumber {


    public static void main(String[] args) {

        System.out.println(getUglyNumberSolution(1));
        System.out.println(getUglyNumberSolution(5));
        System.out.println(getUglyNumberSolution(7));
        System.out.println(getUglyNumberSolution(11));
        System.out.println("------");
        System.out.println(getUglyNumberSolution2(5));
        System.out.println(getUglyNumberSolution2(7));
        System.out.println(getUglyNumberSolution2(11));
    }

    /**
     * 方法一：
     * <p>
     * 　　如果一个数是丑数，那么这个数，如果能被2整除，就一直除以2，如果能被3整除就一直除以3，如果能被5整除，就一直除以5，
     * 最后的结果一定是1。按照这种思路，从数字1开始判断直到第N个丑数出现即可。
     * <p>
     * 　　这种方法效率并不高，因为对于每一个数字，不管它是不是丑数，都需要计算一遍
     */
    private static int getUglyNumberSolution(int n) {

        if (n <= 0) {
            return 0;
        }

        int index = 0;
        int number = 1;
        while (index < n) {
            if (isUglyNumber(number)) {
                index++;
            }
            number++;
        }
        return number - 1;
    }

    private static boolean isUglyNumber(int number) {
        while (number % 2 == 0) {
            number = number / 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    private static boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }

    /**
     * 方法二
     * 动态规划
     * <p>
     * <p>
     * 假设三个i j k分别为*2 *3 *5的丑数位置。由此我们可以写出 状态转移方程
     * dp[n] = min{dp[i]*2,dp[j]*3,dp[k]*5}
     */
    private static int getUglyNumberSolution2(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;
        dp[0]=1;
        for (int x = 1; x < n; x++) {
            int in = dp[i] * 2;
            int jn = dp[j] * 3;
            int kn = dp[k] * 5;

            int min = Math.min(Math.min(in, jn), kn);     //赋最小值
            dp[x] = min;
            if (in == min) {
                i++;
            }
            if (jn == min) {
                j++;
            }

            if (kn == min) {
                k++;
            }
        }
        return dp[n-1];
    }
}
