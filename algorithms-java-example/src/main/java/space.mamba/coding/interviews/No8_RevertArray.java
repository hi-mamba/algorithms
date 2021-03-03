package space.mamba.coding.interviews;

/**
 * @author mamba
 * @date 2021/3/3 14:22
 * <p>
 * 求旋转数组的最小数字
 */
public class No8_RevertArray {

    public static void main(String[] args) {
        No8_RevertArray obj = new No8_RevertArray();
        int[] arr = {3, 4, 5, 2, 3};
        int result = obj.minArray(arr);
        System.out.println(result);

    }

    /**
     * 使用二分查找
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}
