package space.mamba.coding.interviews;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author mamba
 * @date 2020/6/25 23:19
 * <p>
 * <p>
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * https://www.jianshu.com/p/3cead2821c68
 */
public class No33_ArrayConvertSmallestNumber {

    public static void main(String[] args) {

        int[] arr1 = {3, 1, 9, 0, 2};

        printMinNumber(arr1);
        System.out.println("------");
        printMinNumber2(arr1);

        System.out.println("\n------");

        int[] arr2 = {3, 32, 321};
        printMinNumber(arr2);
        System.out.println("------");
        printMinNumber2(arr2);
    }


    private static void printMinNumber2(int[] data) {

        if (data == null || data.length == 0) {
            return;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int number : data) {
            list.add(String.valueOf(number));
        }

        Collections.sort(list, (a, b) -> {
            String temp1 = a + "" + b;
            String temp2 = b + "" + a;
            return temp1.compareTo(temp2);
        });

       // StringBuilder sb = new StringBuilder();
        for (String str : list) {
            System.out.print(str);
        }

    }

    private static void printMinNumber(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (bigger(data[j], data[j + 1])) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        for (int item : data) {
            System.out.print(item);
            // System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 我们重新定义“大于”，“小于”，“等于”。如果a，b组成的数字ab的值大于ba，则称a"大于"b，小于与等于类似。
     * if a>=b return true
     */
    private static boolean bigger(int a, int b) {

        String temp1 = a + "" + b;
        String temp2 = b + "" + a;
        if (temp1.compareTo(temp2) > 0) {
            return true;
        }
        return false;
    }
}
