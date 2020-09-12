package space.mamba.coding.interviews;

import java.util.Stack;

/**
 * @author pankui
 * @date 2019-04-07
 * <pre>
 *       包含min函数的栈
 * </pre>
 */
public class No21_StackMin {

    public static void main(String[] args) {

        StackSolution stackSolution = new StackSolution();
        stackSolution.push(3);
        stackSolution.push(4);
        stackSolution.push(1);

        System.out.println(stackSolution.min());

    }

}

class StackSolution {

    Stack<Integer> stack = new Stack();
    Stack<Integer> min = new Stack();

    public void push(int node) {

        stack.push(node);
        if (min.isEmpty() || node <= min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
