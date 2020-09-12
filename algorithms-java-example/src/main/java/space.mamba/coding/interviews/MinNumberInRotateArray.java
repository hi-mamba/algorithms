package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-03-31
 * <pre>
 *
 * </pre>
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {

    }

    private int minNumberInRotateArrayO_n(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        //排序好了，后面的第一个大于前面的就是最小的，数组排序好了，然后数组旋转小的到后面去了。
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }


    //  //如果arry[mid],arry[start]和arry[end]三个数相等，就只能使用顺序查找
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length < 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[right] < array[left]) {
            //array[right]>array[left],则为有序
            if (right - left == 1) {
                mid = right;//只有两个元素
                break;
            }
            mid = (left + right) / 2;
            if (array[left] == array[right] && array[left] == array[mid]) {
                return MinInOrder(array,left, right);
            }
            if (array[left] <= array[mid]) {
                left = mid;
            }
            else if (array[right] >= array[mid]) {
                right = mid;
            }
        }
        return array[mid];
    }

    int MinInOrder(int[] array, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }
}
