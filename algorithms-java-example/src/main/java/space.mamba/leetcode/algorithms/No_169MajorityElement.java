package space.mamba.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pankui
 * @date 2019-03-09
 * <pre>
 *      https://leetcode.com/problems/majority-element/
 *
 *      Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 *      You may assume that the array is non-empty and the majority element always exist in the array.
 *
 *      Example 1:
 *
 *      Input: [3,2,3]
 *      Output: 3
 *      Example 2:
 *
 *      Input: [2,2,1,1,1,2,2]
 *      Output: 2
 *
 *
 *
 *       给你一个长度为 n 的数组，其中只有一个数字出现了大于等于 n/2 次，
 *       问如何使用优秀的时空复杂度快速找到这个数字。
 *
 *
 * </pre>
 */
public class No_169MajorityElement {


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        No_169MajorityElement obj = new No_169MajorityElement();

        System.out.println(obj.majorityElement(nums));
        System.out.println(obj.majorityElement_2(nums));
    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    /***
     * [3,2,3]
     *
     * [2,2,1,1,1,2,2]
     *
     *
     * 下述算法中将首元素认为是中众数元素，计数为1，
     * 然后每次向后搜索就比较搜索到的元素是不是众数元素，是的话计数+1，
     * 否则计数-1，如果计数减为0说明原设定的众数元素可能不是真正的众数元素，
     * 并将众数元素设为刚搜索的数。一直循环到搜索结束，
     * 由于众数元素出现的次数比其他元素出现的次数之和还要多，
     * 所以最终的计数一定会大于0而相应的最后的众数元素一定是真正的众数元素。
     * */
    public int majorityElement_2(int[] num) {
        int count = 0;
        int major = num[0];
        for (int i : num) {
            if (count == 0) {
                major = i;
                count++;
            } else if (i == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
