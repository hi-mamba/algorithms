package space.mamba.interview;

/**
 * @author pankui
 * @date 2018-12-23
 * <pre>
 *
 *      给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数
 *
 *      给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 * </pre>
 */
public class ArrayFindSum {

    public static void main(String[] args) {


        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        findSum(num, sum);
    }

    public static void findSum(int[] num, int sum) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < num.length; i++) {
            int curSum = 0;
            left = i;
            right = i;
            while (curSum < sum) {
                curSum += num[right++];
            }
            if (curSum == sum) {
                for (int j = left; j < right; j++) {
                    System.out.print(num[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
