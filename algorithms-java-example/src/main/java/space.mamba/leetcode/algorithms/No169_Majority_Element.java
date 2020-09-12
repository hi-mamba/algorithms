package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/9
 * <pre>
 *
 *
 *
 *  因为一定存在。所以只需要判断出现次数最多的
 *
 * </pre>
 */
public class No169_Majority_Element {

    public int majorityElement(int[] nums) {
        int count = 0;
        int major = nums[0];
        for (int i : nums) {
            if (count == 0) {
                major = i;
                count++;
                //
            } else if (i == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
