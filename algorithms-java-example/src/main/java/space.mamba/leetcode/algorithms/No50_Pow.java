package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/4
 * <pre>
 *      50. Pow(x, n)
 *
 *      时间复杂度为 O(n)，加上题目的限制会超时
 *
 *
 *      本题的难点主要是在边界条件：如果 n < 0，是不是 n = -n， x = 1 / x ，再进行递归就能解决了呢？
 *      如果 n = Intege.MIN_VALUE，n = -n 会出现溢出，怎么办呢？我们可以先将 n / 2 赋值给 t，
 *      再将 t = -n，就不会出现溢出问题。
 * </pre>
 */
public class No50_Pow {

    public static void main(String[] args) {
        No50_Pow obj = new No50_Pow();
        double result = obj.myPow(2,4);
        System.out.println(result);

        result = obj.myPow(2,-2);
        System.out.println(result);
    }

    /** 时间复杂度为 O(n)，加上题目的限制会超时
        所以这个方法超时,OJ 因超时无法通过
     */
    public double myPow2(double x, int n) {

        if (n == 0) {
            return 1;
        }

        int mark = n;
        if (n < 0) {
            n = -n;
        }

        double temp = 1;
        double result = x;
        for (int i = 0; i < n; i++) {
            result = result * temp;
            temp = x;
        }
        return mark < 0 ? 1 / result : result;
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double v = power(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
}
