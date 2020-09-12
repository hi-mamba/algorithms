package space.mamba.leetcode.algorithms;

import java.util.HashSet;

/**
 * @author pankui
 * @date 2019-03-29
 * <pre>
 *
 * </pre>
 */
public class No202_Happy_Number {

    public static void main(String[] args) {
        int n = 132;

        System.out.println(n % 10);

        int temp;
        int newN = 0;
        while (n > 0) {
            temp = n % 10;
            n = n / 10;
            newN = newN + temp * temp;
        }


        SolutionIsHappy solution = new SolutionIsHappy();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(193));
        System.out.println(solution.isHappy(103));


        SolutionIsHappy2 solution2 = new SolutionIsHappy2();
        System.out.println(solution2.isHappy(103));

    }
}

class SolutionIsHappy {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        // 用于保存中间出现的结果
        HashSet<Integer> hashSet = new HashSet<>();
        int temp;
        int newN;
        // n不为1，并且n的值不能重复出现，否则会死循环
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            newN = 0;
            while (n > 0) {
                temp = n % 10;
                n = n / 10;
                newN = newN + temp * temp;
            }
            n = newN;
        }
        return n == 1;
    }
}

/**
 * 评论区里看到一种解决办法
 * My solution in C( O(1) space and no magic math property involved )
 */

class SolutionIsHappy2 {

    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;
    }
}