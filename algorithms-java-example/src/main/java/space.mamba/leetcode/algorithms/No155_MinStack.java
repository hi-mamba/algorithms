package space.mamba.leetcode.algorithms;

import java.util.Stack;

/**
 * @author mamba
 * @date 2021/1/28 08:00
 * https://leetcode.com/problems/min-stack/
 */
public class No155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}

class MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (minStack.peek() == x){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */