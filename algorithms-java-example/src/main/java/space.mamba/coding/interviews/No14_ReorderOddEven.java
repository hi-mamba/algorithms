package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *      调整数组顺序使奇数位于偶数前面
 * </pre>
 */
public class No14_ReorderOddEven {

    public static void main(String[] args) {

        // int[] array = {1, 1,2, 3, 4, 5, 6, 7};
        int[] array = {1, 1, 3, 5, 6, 7};
        int[] arr = reorderOdd(array);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] reorderOdd(int[] data) {

        if (data == null || data.length < 2) {
            return data;
        }

        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            //摸2 不等于就自增，否则就交换
            while (left < right && !isEven(data[left])) {
                left++;
            }
            while (left < right && isEven(data[right])) {
                right--;
            }

            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }

        }
        return data;
    }

    /**
     * 偶数返回true
     */
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}

