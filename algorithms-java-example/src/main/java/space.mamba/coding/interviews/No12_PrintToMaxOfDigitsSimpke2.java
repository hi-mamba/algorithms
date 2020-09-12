package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-02
 * <pre>
 *
 * </pre>
 */
public class No12_PrintToMaxOfDigitsSimpke2 {

    public static void main(String[] args) {
        printOneToNthDigits(1);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits(int n) {
        // 输入的数字不能为小于1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // 创建一个数组用于打存放值
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }
    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param n   当前处理的是第个元素，从0开始计数
     * @param arr 存放结果的数组
     */
    public static void printOneToNthDigits(int n, int[] arr) {
        // 说明所有的数据排列选择已经处理完了
        if (n >= arr.length) {
            // 可以输入数组的值
            printArray(arr);
        } else {
            // 对
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }
    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param arr 要输出的数组
     */
    public static void printArray(int[] arr) {
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            System.out.println();
        }
    }
}
