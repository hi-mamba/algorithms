package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pankui
 * @date 2019-01-21
 * <pre>
 *     https://www.cnblogs.com/edisonchou/p/4746561.html
 *
 *     https://www.jianshu.com/p/c8f43b33779a
 *
 *     旋转数组的最小数字
 *
 *      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 *  ## 方法一：暴力解法
 *      这道题最直观的解法并不难，从头到尾遍历数组一次，我们就能找出最小的元素。
 *      这种思路的时间复杂度显然是O(n)。
 *      但是这个思路没有利用输入的旋转数组的特性，肯定达不到面试官的要求
 *
 * ## 方法二：二分法
 * 　    我们注意到旋转之后的数组实际上可以划分为两个排序的子数组，而且前面的子数组的元素都大于或者等于后面子数组的元素。
 *       我们还注意到最小的元素刚好是这两个子数组的分界线。
 *       在排序的数组中我们可以用二分查找法实现O(logn)的查找。
 *
 *
 *    ###   解题思路
 * 　　- Step1.和二分查找法一样，我们用两个指针分别指向数组的第一个元素和最后一个元素。
 *
 * 　　- Step2.接着我们可以找到数组中间的元素：
 *
 * 　　      如果该中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元素。
 *          此时数组中最小的元素应该位于该中间元素的后面。
 *          我们可以把第一个指针指向该中间元素，这样可以缩小寻找的范围。移动之后的第一个指针仍然位于前面的递增子数组之中。
 *          如果中间元素位于后面的递增子数组，那么它应该小于或者等于第二个指针指向的元素。
 *          此时该数组中最小的元素应该位于该中间元素的前面。
 *
 * 　　- Step3.接下来我们再用更新之后的两个指针，重复做新一轮的查找。
 *
 * </pre>
 */
public class RotateSmallestNumberOfArrays {

    public static int GetMin(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        int index1 = 0;
        int index2 = numbers.length - 1;
        // 把indexMid初始化为index1的原因：
        // 一旦发现数组中第一个数字小于最后一个数字，表明该数组是排序的
        // 就可以直接返回第一个数字了
        int indexMid = index1;

        while (numbers[index1] >= numbers[index2]) {
            // 如果index1和index2指向相邻的两个数，
            // 则index1指向第一个递增子数组的最后一个数字，
            // index2指向第二个子数组的第一个数字，也就是数组中的最小数字
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            // 特殊情况：如果下标为index1、index2和indexMid指向的三个数字相等，则只能顺序查找
            if (numbers[index1] == numbers[indexMid] && numbers[indexMid] == numbers[index2]) {
                return GetMinInOrder(numbers, index1, index2);
            }
            // 缩小查找范围
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }

        return numbers[indexMid];
    }

    public static int GetMinInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }

        return result;
    }

    public int minNumberInRotateArray(int [] array){
        if(array==null||array.length<0) {
            return -1;
        }
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(array[right]<array[left]){
            //array[right]>array[left],则为有序
            if(right-left==1){
                //只有两个元素
                mid=right;
                break;
            }
            mid=(left+right)/2;
            if(array[left]==array[right]&&array[left]==array[mid]) {
                return MinInOrder(array,left, right);
            }
            if(array[left]<=array[mid]) {
                left = mid;
            }
            else  if(array[right]>=array[mid]) {
                right = mid;
            }
        }
        return array[mid];
    }
    int MinInOrder(int [] array,int left,int right){
        int result=0;
        for(int i=left;i<= right;i++){
            if(result>array[i]) {
                result = array[i];
            }
        }
        return result;
    }



    @Test
    public void GetMinNumTest1()
    {
        int[] array = {3, 4, 5, 1, 2};
        Assertions.assertEquals(GetMin(array),1);
    }
}
