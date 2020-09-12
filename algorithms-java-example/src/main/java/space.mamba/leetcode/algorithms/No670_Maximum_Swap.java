package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/16
 * <pre>
 * Example 1:
 * Input: 2736
 * Output: 7236
 *
 * Example 2:
 * Input: 9973
 * Output: 9973
 *
 * https://blog.csdn.net/qq_26410101/article/details/86485441
 *
 * </pre>
 */
public class No670_Maximum_Swap {

    public static void main(String[] args) {
        No670_Maximum_Swap obj = new No670_Maximum_Swap();
        System.out.println(obj.maximumSwap(2736));

        System.out.println(obj.maximumSwap(9973));

        // 98863
        System.out.println(obj.maximumSwap(98368));
    }


    public int maximumSwap(int num) {
        int maxValue = -1, maxIndex = -1;
        int leftIndex = -1, rightIndex = -1;
        char[] digits = Integer.toString(num).toCharArray();


        for (int i = digits.length - 1; i >= 0; i--) {

            int value = Integer.parseInt(String.valueOf(digits[i]));
            if (value > maxValue) {
                maxIndex = i;
                maxValue = value;
                continue;
            }

            if (value < maxValue) {
                leftIndex = i;
                rightIndex = maxIndex;
            }
        }

        if (leftIndex == -1) {
            return num;
        }

        char temp = digits[rightIndex];
        digits[rightIndex] = digits[leftIndex];
        digits[leftIndex] = temp;

        return Integer.parseInt(new String(digits));
    }

}
