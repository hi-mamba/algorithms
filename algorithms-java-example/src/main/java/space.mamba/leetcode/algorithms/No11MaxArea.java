package space.mamba.leetcode.algorithms;

/**
 * @author meta a
 * @date 2022/3/4
 * <pre>
 *
 *  盛最多水的容器
 *
 *  https://leetcode-cn.com/problems/container-with-most-water/
 *
 * </pre>
 */
public class No11MaxArea {

    public static void main(String[] args) {
        No11MaxArea obj = new No11MaxArea();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(obj.maxArea(arr));

    }
    //双指针
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        // [1, 8, 6, 2, 5, 4, 8, 3, 7]
        //在初始时，左右指针分别指向数组的左右两端，它们可以容纳的水量为 min(1, 7) * 8 = 8min(1,7)∗8=8
        //TODO 注意：x轴 相隔是1 个单位， 总共八个单位
        while (left < right) {
            //取较小的，和相隔单位 获取面积
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(currentArea, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
