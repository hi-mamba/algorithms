package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * @author mamba
 * @ 2020/7/28
 */
public class No52_Multiply {

    public static void main(String[] args) {
        int[]arr1 = {1,2,3};
        int[]arr2 = {1,2,3};
        int[]arr = multiply(arr1,arr2);
        Assertions.assertEquals(arr[0],6);
        Assertions.assertEquals(arr[1],3);
    }

    private static int[] multiply(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        if (len1 == len2 && len2 > 1) {
            array2[0] = 1;
            for (int i = 1; i < len1; i++) {
                array2[i] = array2[i - 1] * array1[i - 1];
            }

            double tmp = 1;
            for (int i = len1 - 2; i >= 0; i--) {
                tmp *= array1[i + 1];
                array2[i] *= tmp;
            }
        }

        System.out.println(Arrays.toString(array2));
        return array2;
    }
}
