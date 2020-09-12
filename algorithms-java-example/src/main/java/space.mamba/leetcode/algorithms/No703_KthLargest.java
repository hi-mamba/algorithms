package space.mamba.leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author byte mamba
 * @date 2019/11/23
 * <pre>
 *
 *     https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 *     此题要找出输入流中第k大的数字。我们可以使用一个小顶堆，初始化时先用前k个数字将其填满，
 *     由于堆顶元素是最小的，因此每添加一个数字时都将其和堆顶元素进行比较，只要比堆顶元素大就将堆顶元素移除，
 *     并把要添加的数字加入堆中。如此反复，每次添加后堆中都保存着当前输入流中的前K大的数字，
 *     并且堆顶元素是其中最小的也就是第K大的数字。
 *
 *
 * </pre>
 */
public class No703_KthLargest {

    public static void main(String[] args) {

        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        // returns 4
        int result = kthLargest.add(3);
        System.out.println(result);

        // returns 5
        result = kthLargest.add(5);
        System.out.println(result);

        // returns 5
        result = kthLargest.add(10);
        System.out.println(result);

        // returns 8
        result = kthLargest.add(9);
        System.out.println(result);

        // returns 8
        result = kthLargest.add(4);
        System.out.println(result);
    }

}

class KthLargest {

    private PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {

        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}