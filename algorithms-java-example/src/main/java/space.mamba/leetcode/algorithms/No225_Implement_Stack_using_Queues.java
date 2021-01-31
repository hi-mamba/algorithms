package space.mamba.leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mamba
 * @date 2021/1/31 22:21
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * 使用队列实现栈的下列操作：
 *
 * push(x) — 元素 x 入栈
 * pop() — 移除栈顶元素
 * top() — 获取栈顶元素
 * empty() — 返回栈是否为空
 */
public class No225_Implement_Stack_using_Queues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> tempQ = new LinkedList<>();
        tempQ.add(x);
        tempQ.addAll(queue);
        queue = tempQ;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
