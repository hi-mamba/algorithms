package space.mamba.coding.interviews;

import java.util.Arrays;

/**
 * @author mamba
 * @date 2020/7/9 08:02
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。`要求时间复杂度是O(n)，空间复杂度是O(1)`。
 * <p>
 * 说明不能使用额外的空间来存
 */
public class No40_FindNumsAppearOnce {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 4, 3};
        //  findNumsAppearOnce(arr);
        System.out.println(Arrays.asList(findNumsAppearOnce(arr)));
    }

    private static int[] findNumsAppearOnce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int xorNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            xorNumber ^= arr[i];
            System.out.println(xorNumber);
        }
        System.out.println("--" + xorNumber);
        int onePosition = xorNumber & (-xorNumber);
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & onePosition) == onePosition) {
                ans1 ^= arr[i];
            } else {
                ans2 ^= arr[i];
            }
        }

        System.out.println("----");
        System.out.println((ans1 ^ 0) + ", " + (ans2 ^ 0));
        return new int[]{ans1 ^ 0, ans2 ^ 0};

    }

}
