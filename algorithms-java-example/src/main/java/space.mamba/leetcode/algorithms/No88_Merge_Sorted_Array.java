package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-03-26
 * <pre>
 *
 *     https://leetcode.com/problems/merge-sorted-array/
 *
 *  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 *      Note:
 *
 *      The number of elements initialized in nums1 and nums2 are m and n respectively.
 *      You may assume that nums1 has enough space (size that is greater or
 *      equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 *
 * 翻译：给定两个排序整数数组nums1和nums2，将nums2按顺序合并到nums1（从小到大）。
 * 提示：假设nums1有足够的空间（大小大于或等于m + n）来保存nums2中的其他元素。
 *
 *
 * 混合插入有序数组，由于两个数组都是有序的，所有只要按顺序比较大小即可。
 * 题目中说了nums1数组有足够大的空间，说明我们不用resize数组，又给了我们m和n，那就知道了混合之后的数组的大小，
 * 这样我们就从nums1和nums2数组的末尾开始一个一个比较，把较大的数，按顺序从后往前加入混合之后的数组末尾。
 * 需要三个变量i，j，k，分别指向nums1，nums2，和混合数组的末尾。
 * 进行while循环，如果i和j都大于0，再看如果nums1[i] > nums2[j]，
 * 说明要先把nums1[i]加入混合数组的末尾，加入后k和i都要自减1；
 * 反之就把nums2[j]加入混合数组的末尾，加入后k和j都要自减1。
 * 循环结束后，有可能i或者j还大于等于0，若j大于0，那么我们还需要继续循环，
 * 将nums2中的数字继续拷入nums1。
 * 若是i大于等于0，那么就不用管，因为混合数组本身就放在nums1中，参见代码如下
 *
 * </pre>
 */
public class No88_Merge_Sorted_Array {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        solution.merge2(num1,3,num2,3);
        solution.merge(num1,3,num2,3);
    }
}

class Solution {

    /**
     * 从后面开始排序
     *
     * 因为不允许使用多余的数组空间，就不好对两个数组从前往后进行比较（插入位置比较麻烦）。
     * 方法是从后往前比，然后处理剩下的元素。
     *
     * 时间复杂度为 O(n + m) 的解法
     *
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        while (m>0 && n >0) {
            if (nums1[m -1] > nums2[n-1]) {
                //把值大的放在后面
                nums1[m + n -1] = nums1[m-1];
                //往数组左边挪一位
                m--;
            }else {
                //把值大的放在后面
                nums1[m + n -1] = nums2[n-1];
                //往数组左边挪一位
                n--;
            }
        }
        //最后对比完了，但是num2可能还有剩余的，因为数组是放在num1中，所以不需要管 num1还有剩余的
        while (n >0) {
            nums1[m + n -1] = nums2[n-1];
            n--;
        }

        System.out.println("\n====华丽分割线\n");
        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k]+" ");
        }
    }

    /**
     * 我们还可以写的更简洁一些，将两个while循环融合到一起，我们只要加上i>=0且nums1[i] > nums2[j]的判断条件，
     * 就可以从nums1中取数，否则就一直从nums2中取数，参见代码如下:
     * */


    /** 题目是不需要创建新的数组,而且这个在AC的时候有问题 */
    @Deprecated
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[nums1.length/2 + nums2.length];
        int s = array.length;
        int temp = 0;
        int i = 0, j = 0;
        while (s > 0) {
            if (i< m && j< n && nums1[i] <= nums2[j]) {
                array[temp] = nums1[i];
                i++;
                temp++;
            } else if (i< m && j< n && nums1[i] > nums2[j]) {
                array[temp] = nums2[j];
                j++;
                temp++;
            }
            if (i >= m && j < n) {
                array[temp] = nums2[j];
                j++;
                temp++;
            }

            if (i < m && j >= n) {
                array[temp] = nums1[i];
                i++;
                temp++;
            }

            s--;
        }

        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]+" ");
        }

    }
}