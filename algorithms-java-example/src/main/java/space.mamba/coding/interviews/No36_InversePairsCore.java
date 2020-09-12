package space.mamba.coding.interviews;

/**
 * @author mamba
 * @date 2020/6/27 10:19
 * <p>
 * 数组中逆序对的个数
 * <p>
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class No36_InversePairsCore {

    public static void main(String[] args) {

        int[] arr = {4, 3, 1, 2, 0};
        System.out.println(inversePairsCore(arr));
        int[] arr2 = {7, 5, 6, 4};
        System.out.println(inversePairsCore(arr2));
        System.out.println("-----");
        System.out.println(inversePairs(arr));
        System.out.println(inversePairs(arr2));
    }

    /**
     * 直接求解
     */
    private static int inversePairsCore(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int inversePairs(int[] data) {
        if (data == null || data.length < 2) {
            return 0;
        }
        return mergeSortCore(data, 0, data.length - 1);
    }

    public static int mergeSortCore(int[] data, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = mergeSortCore(data, start, mid);
        int right = mergeSortCore(data, mid + 1, end);
        int count = mergerSortMerge(data, start, mid, end);
        return left + right + count;
    }

    //start~mid, mid+1~end
    public static int mergerSortMerge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        for (int i = 0; i <= end - start; i++)
            temp[i] = data[i + start];
        int left = 0, right = mid + 1 - start, index = start, count = 0;
        while (left <= mid - start && right <= end - start) {
            if (temp[left] <= temp[right]) {
                data[index++] = temp[left++];
            } else {
                // 右边大于左边，自增
                data[index++] = temp[right++];
                count += (mid - start) - left + 1;
            }
        }
        while (left <= mid - start) {
            data[index++] = temp[left++];
        }
        while (right <= end - start) {
            data[index++] = temp[right++];
        }
        return count;
    }
}
