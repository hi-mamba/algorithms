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
public class No14_GetLeastNumbersSolutionExample01 {


    public static void main(String[] args) {

        int[] arr = {5, 6, 4, 8, 6, 1, 9};
        List<Integer> list = GetLeastNumbers_Solution(arr, 3);
        System.out.println(list);

        System.out.println("####  ");
    }

    /**
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return result;
        }
        //做排序
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }


}
