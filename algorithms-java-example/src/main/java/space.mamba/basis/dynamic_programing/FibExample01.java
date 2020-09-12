package space.mamba.basis.dynamic_programing;

/**
 * @author mamba
 * 动态规划解决 FIB
 * <p>
 * Program for Fibonacci numbers
 * <p>
 * <p>
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * <p>
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
 * <p>
 * Fn = Fn-1 + Fn-2
 * <p>
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class FibExample01 {

    public static void main(String[] args) {

        System.out.println(fib(0));
        System.out.println(fib(2));
        System.out.println(fib(4));
        System.out.println(fib(6));
        System.out.println("======");
        System.out.println(fib1(3));
        System.out.println(fib1(4));
        System.out.println(fib1(6));
        System.out.println("======");
        System.out.println(fibDp3(3));
        System.out.println(fibDp3(4));
        System.out.println(fibDp3(6));
        System.out.println("======");
        System.out.println(fibDpSpaceOptimizedMethod(3));
        System.out.println(fibDpSpaceOptimizedMethod(4));
        System.out.println(fibDpSpaceOptimizedMethod(6));
        System.out.println("======");
        System.out.println(fibMath(3));
        System.out.println(fibMath(4));
        System.out.println(fibMath(6));
    }

    private static int fib(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 多位运算符
     */
    private static int fib1(int n) {
        return n <= 0 ? 0 : n == 1 ? 1 : fib1(n - 1) + fib1(n - 2);
    }

    /**
     * dp 解决
     */
    private static int fibDp3(int n) {

        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * 优化空间
     */
    private static int fibDpSpaceOptimizedMethod(int n) {

        int a = 0, b = 1, c;
        if (n == 0) {
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     *In this method we directly implement the formula for nth term in the fibonacci series.
     * Fn = {[(√5 + 1)/2] ^ n} / √5
     * Reference: http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     **/
    private static int fibMath(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n)
                / Math.sqrt(5));
    }

}
