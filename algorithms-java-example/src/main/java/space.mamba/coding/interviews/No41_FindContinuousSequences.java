package space.mamba.coding.interviews;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author mamba
 * <p>
 * <p>
 * 输入一个正整数s，打印出所有和为s的连续正整数序列（至少包含两个数字）。
 * <p>
 * 例如输入15，所以打印出3个连续序列（1，2，3，4，5）（4，5，6）（7，8）
 */
public class No41_FindContinuousSequences {

    public static void main(String[] args) {

        System.out.println(findContinuousSequences1(15));
        System.out.println(findContinuousSequence(15));
    }

    private static List<List<Integer>> findContinuousSequences1(int sum) {

        if (sum <= 2) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();

        // 双向队列
        Deque<Integer> deque = new LinkedList<>();
        int i = 1;
        int value = 0;
        while (i < sum) {
            if (value < sum) {
                deque.push(i);
                i++;
            } else {
                deque.pollLast();
            }

            value = deque.stream().reduce(0, Integer::sum);
            if (value == sum && deque.size() > 1) {
                List<Integer> subList = new ArrayList<>(deque);
                Collections.sort(subList);
                list.add(subList);
            }
        }

        return list;
    }

    /**
     * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
     *
     * 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
     * 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
     * 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，
     * 那么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1 开头的序列，所以窗口的左边界要向右移动
     *
     *
     * 我们一开始要找的是 1 开头的序列，只要窗口的和小于 target，窗口的右边界会一直向右移动。假设 1+2+\dots+81+2+⋯+8 小于 target，
     * 再加上一个 9 之后， 发现 1+2+\dots+8+91+2+⋯+8+9 又大于 target 了。这说明 1 开头的序列找不到解。此时滑动窗口的最右元素是 9。
     *
     * 接下来，我们需要找 2 开头的序列，我们发现，2 + \dots + 8 < 1 + 2 + \dots + 8 < \mathrm{target}2+⋯+8<1+2+⋯+8<target。
     * 这说明 2 开头的序列至少要加到 9。那么，我们只需要把原先 1~9 的滑动窗口的左边界向右移动，变成 2~9 的滑动窗口，
     * 然后继续寻找。而右边界完全不需要向左移动。
     *
     * 以此类推，滑动窗口的左右边界都不需要向左移动，所以这道题用滑动窗口一定可以得到所有的解。时间复杂度是 O(n)O(n)。
     *
     * */
    public static List<List<Integer>> findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<List<Integer>> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res;
    }
}
