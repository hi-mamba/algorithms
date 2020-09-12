package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-02-19
 * <pre>
 *
 * </pre>
 */
public class No35_SearchInsert {

    public static void main(String[] args) {
        No35_SearchInsert obj = new No35_SearchInsert();
        int[] example1 = new int[]{1,3,5,6};
        int target1 = 5;
        System.out.println(obj.searchInsert(example1,target1));

        int[] example2 = new int[]{1,3,5,6};
        int target2 = 2;
        System.out.println(obj.searchInsert(example2,target2));

        int[] example3 = new int[]{1,3,5,6};
        int target3 = 7;
        System.out.println(obj.searchInsert(example3,target3));

        int[] example4 = new int[]{1,3,5,6};
        int target4 = 0;
        System.out.println(obj.searchInsert(example4,target4));

        System.out.println("=====分割线");
        System.out.println(obj.searchInsert2(example1,target1));
        System.out.println(obj.searchInsert2(example2,target2));
        System.out.println(obj.searchInsert2(example3,target3));
        System.out.println(obj.searchInsert2(example4,target4));

    }
    public int searchInsert(int[] nums, int target) {

        if (nums.length < 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        //不相等的情况
       // int[] targetNum = new int[nums.lengthv  + 1];
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                return i;
            }
            if (i==nums.length-1) {
                return nums.length;
            }
        }
        return 0;
    }

    /**
     * 二分 实现
     *
     * 二分搜索法来优化我们的时间复杂度
     *
     * */
    public int searchInsert2(int[] nums, int target) {

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }else {
                right= mid;
            }
        }
        return left;

    }
}
