package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-03-27
 * <pre>
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *   Given an array of integers that is already sorted in ascending order,
 *   find two numbers such that they add up to a specific target number.
 *
 *  The function twoSum should return indices of the two numbers such
 *  that they add up to the target, where index1 must be less than index2.
 *
 * </pre>
 */
public class No167_Two_Sum_II_Input_array_is_sorted {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] numbers = {2, 7, 11, 15};
        int target = 22;
        int[] result = solution.twoSum2(numbers, target);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println("#### 分割线");
        int[] result2 = solution.twoSum(numbers, target);

        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }

    }

}


class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            //左边 + 右边与target 比较 如果大于那么就左移或者右移
            if (numbers[start] + numbers[end] == target) {
                break;
            }
            if (numbers[start] + numbers[end] > target){
                end--;
            }else {
                start++;
            }
        }
        return new int[]{start + 1 , end + 1};
    }
    public int[] twoSum2(int[] numbers, int target) {
        int temp = numbers[0];
        int[] array = new int[2];
        int i = 1;
        int k = 1;
        int j = 0;
        while (i < numbers.length) {
            if (temp + numbers[i] == target) {
                array[0] = j + 1;
                array[1] = i + 1;
                return array;
            } else {
                i++;
            }
            if (i == numbers.length) {
                k = k + 1;
                i = k;
                j = j + 1;
                temp = numbers[j];
            }
        }
        return array;
    }
}