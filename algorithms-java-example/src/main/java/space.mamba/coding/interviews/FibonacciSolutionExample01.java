package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-21
 * <pre>
 *
 * </pre>
 */
public class FibonacciSolutionExample01 {

    static long fibonacciSolution1(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return fibonacciSolution1(n - 1) + fibonacciSolution1(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSolution1(0));
        System.out.println(fibonacciSolution1(1));
        System.out.println(fibonacciSolution1(2));
    }
}
