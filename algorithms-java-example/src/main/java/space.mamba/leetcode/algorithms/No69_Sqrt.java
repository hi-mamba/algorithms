package space.mamba.leetcode.algorithms;

import org.junit.jupiter.api.Assertions;

/**
 * @author mamba
 * @date 2020/10/25 22:06
 *
 * https://leetcode.com/problems/sqrtx/submissions/
 */
public class No69_Sqrt {

    public static void main(String[] args) {

        Assertions.assertEquals(mySqrt(4),2);
        Assertions.assertEquals(mySqrt(9),3);
    }

    public static int mySqrt(int x) {

        return (int) Math.sqrt(x);
    }
}
