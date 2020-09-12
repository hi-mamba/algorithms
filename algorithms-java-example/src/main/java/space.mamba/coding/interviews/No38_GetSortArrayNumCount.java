package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mamba
 * @date 2020/7/6 07:56
 *
 * https://www.cnblogs.com/edisonchou/p/4822740.html
 *
 * https://www.cnblogs.com/wupeixuan/p/8679174.html
 *
 */
public class No38_GetSortArrayNumCount {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 5, 6, 7, 7, 8, 9};

        System.out.println(getNumCount(arr, 7));
        System.out.println(getNumCount(arr, 2));
        System.out.println("#####-----");
        System.out.println(getNumberOfNum(arr, 7));
        System.out.println(getNumberOfNum(arr, 2));
        System.out.println("----------");
        System.out.println(getNumberOfK_3(arr, 7));
        System.out.println(getNumberOfK_3(arr, 2));
    }


    // 数组中只有一个数字，不是查找的数字
    @Test
    public void GetNumberTest10() {
        int[] data = {3};
        int actual = getNumberOfK_3(data, 2);
        Assertions.assertEquals(actual, 0);
    }

    private static int getNumCount(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int count = 0;
        for (int i : arr) {
            if (i == num) {
                count++;
            }
            if (i > num) {
                // 由于已经排序好，大于 num 的就直接 break
                break;
            }
        }
        return count;
    }

    private static int getNumberOfNum(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int count = 0;

        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == num) {
                break;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //找到等于k的值的位置
        if (left <= right) {
            //从这个位置向后找
            for (int i = mid; i > 0; i--) {
                if (arr[i] == num) {
                    count++;
                } else {
                    break;
                }
            }
            //从这个位置想右找
            for (int i = mid + 1; i < arr.length; i++) {
                if (arr[i] == num) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 二分查找 找到第一个k和最后一个k二者位置相减
     *
     * @param array
     * @param k
     * @return
     */
    public static int getNumberOfK_3(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int number = 0;
        int first = getFirstIndex(array, k, 0, array.length - 1);
        int last = getLastIndex(array, k, 0, array.length - 1);
        if (first > -1 && last > -1)
            number = last - first + 1;
        return number;
    }

    /**
     * 找到最后一个k的位置
     *
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    private static int getLastIndex(int[] array, int k, int left, int right) {
        if (left > right)
            return -1;
        int mid = left + ((right - left) >> 1);
        if (array[mid] == k) {
            if (mid == right || (array[mid + 1] != k)) {
                return mid;
            } else {
                left = mid + 1;
            }
        } else if (array[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return getLastIndex(array, k, left, right);
    }

    /**
     * 找到第一个k的位置
     *
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    private static int getFirstIndex(int[] array, int k, int left, int right) {
        if (left > right)
            return -1;
        int mid = left + ((right - left) >> 1);
        if (array[mid] == k) {
            if (mid == left || (array[mid - 1] != k)) {
                return mid;
            } else {
                right = mid - 1;
            }
        } else if (array[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return getFirstIndex(array, k, left, right);
    }
}
