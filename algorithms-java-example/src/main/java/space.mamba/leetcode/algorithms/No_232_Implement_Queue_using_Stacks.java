package space.mamba.leetcode.algorithms;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * @author mamba
 * @date 2021/2/1 07:50
 */
public class No_232_Implement_Queue_using_Stacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        Assertions.assertEquals(myQueue.pop() , 1);
        Assertions.assertEquals(myQueue.pop() , 2);
        Assertions.assertEquals(myQueue.pop() , 3);
    }
}

class MyQueue {

    Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.add(x);
        tempStack.addAll(stack);
        stack = tempStack;

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}