package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-03-09
 * <pre>
 *      https://leetcode.com/problems/single-number/
 *
 *      Given a non-empty array of integers, every element appears twice except for one.
 *      Find that single one.
 *
 * Note:
 *
 *      Your algorithm should have a linear runtime complexity.
 *      Could you implement it without using extra memory?
 *
 *
 *          很好解决，通过异或运算，我们可以把所有出现两次的元素消除 a^a = 0;
 *          最后就只剩下那个出现一次的元素了 0^b = b。
 *
 *          异或运算：如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
 *
 *          result ^= i;
 *           等价下面
 *          result = result ^ i;
 * </pre>
 */
public class No136_SingleNumber {

    public static void main(String[] args) {
        No136_SingleNumber obj = new No136_SingleNumber();

        int[] nums = {2,2,1};

        //int[] nums = {3, 1, 2, 1, 2};

        System.out.println(obj.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {

        int result = 0;
        for(int i : nums) {
            result ^= i;
            System.out.println("result="+result);
        }
        return result;
    }
}
