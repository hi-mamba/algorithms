package space.mamba.coding.interviews;

import java.util.Stack;

/**
 * @author pankui
 * @date 2019-01-20
 * <pre>
 *
 *     https://www.cnblogs.com/gl-developer/p/6445419.html
 *
 *     题目：
 *
 *     用两个栈实现一个队列。
 *     队列的声明如下：请实现他的两个函数appendTail和deleteHead，
 *     分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 *
 * </pre>
 */
public class No7QueueWithTwoStacks {

    private static Stack<Object> stack1 = new Stack<>();
    private static Stack<Object> stack2 = new Stack<>();

    /**
     * 加入队列中的元素只加入到栈1中
     */
    public static void appendTail(Object item) {
        stack1.push(item);
        System.out.println("压入栈元素：" + item);
    }

    /**
     * 删除一个元素时，检查栈2是否为空，栈2不为空则弹出栈2栈顶元素
     * 栈2为空，则把栈1中的元素全部弹出、压入到栈2中，然后从栈2栈顶弹出元素
     */
    public static void deleteHead() {
        if (!stack2.empty()) {
            System.out.println("弹出栈元素：" + stack2.pop());
        }
        else {
            if (stack1.empty()) {
                throw new RuntimeException("队列为空");
            }
            while (!stack1.empty()) {
                Object item = stack1.pop();
                stack2.push(item);
            }
            deleteHead();
        }
    }

    public static void main(String[] args) {
        //向空的队列中添加元素
        appendTail(1);
        //向非空的队列中添加元素
        appendTail(2);
        appendTail(3);
        //向非空的队列中删除元素
        deleteHead();
        deleteHead();
        appendTail(4);
        deleteHead();
        appendTail(5);
        deleteHead();
        deleteHead();
        deleteHead();

    }
}
