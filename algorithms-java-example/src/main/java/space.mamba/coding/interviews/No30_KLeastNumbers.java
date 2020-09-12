package space.mamba.coding.interviews;

import java.util.*;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *     找出最小的K个数
 *
 * </pre>
 */
public class No30_KLeastNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {2, 3, 6, 99, 7, 32, 12, 36, 42};

        List list = solution.getLeastNumbers(arr, 6);
        System.out.println(list);

        System.out.println("分割线 ========");
        List list2 = solution.getLeastNumbers_2(arr, 6);
        System.out.println(list2);
    }
}

class Solution {

    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (k <= 0 || k > input.length) {
            return new ArrayList<>();
        }
        //创建大根堆
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer s : input) {
            maxheap.add(s);
            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(maxheap);
        return arrayList;
    }

    public ArrayList<Integer> getLeastNumbers_2(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int lens = nums.length;
        if (nums == null || lens == 0 || k > lens || k <= 0) {
            return list;
        }

        //插入进去已经排序好
        TreeSet<Integer> kSet = new TreeSet<Integer>();
        for (int i = 0; i < lens; i++) {
            if (kSet.size() < k) {
                kSet.add(nums[i]);

                //容器慢了之后，移除最大的
            } else if (nums[i] < kSet.last()) {
                kSet.remove(kSet.last());
                kSet.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = kSet.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}