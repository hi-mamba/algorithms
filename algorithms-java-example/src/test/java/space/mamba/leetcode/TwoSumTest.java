package space.mamba.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mamba
 * @date 2020/9/12 09:48
 */
public class TwoSumTest {

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] a = new TwoSum().twoSum(nums, target);
        Assertions.assertArrayEquals(a, new int[]{0, 1});
    }
}
