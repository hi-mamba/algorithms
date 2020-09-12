package space.mamba.coding.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pankui
 * @date 2019-04-03
 * <pre>
 *      题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * </pre>
 */
public class No14_GetLeastNumbersSolutionExample02_quickSort {


    public static void main(String[] args) {
        No14_GetLeastNumbersSolutionExample02_quickSort obj = new No14_GetLeastNumbersSolutionExample02_quickSort();

        int[] arr = {5, 6, 4, 8, 6, 1, 9};
        List<Integer> list = obj.getLeastNumbers_Solution(arr, 4);
        System.out.println(list);

        System.out.println("####  ");
    }

    /**
     * 方法一：基于快排的思想
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k < 0) {
            return result;
        }

        int high = input.length - 1;
        int low = 0;
        int privoIndex = partition(input, low, high);
        while (privoIndex != k - 1) {
            if (privoIndex > k - 1) {
                privoIndex = partition(input, low, privoIndex - 1);
            } else {
                privoIndex = partition(input, privoIndex + 1, high);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public int partition(int[] a, int low, int high) {
        // privokey标兵
        int privokey = a[low];
        while (low < high) {
            while (low < high && a[high] >= privokey) {
                --high;
            }
            swap(a, low, high);
            while (low < high && a[low] <= privokey) {
                ++low;
            }
            swap(a, low, high);
        }
        return low;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
