package space.mamba.coding.interviews;

import java.util.Stack;

/**
 * @author pankui
 * @date 2019-01-19
 * <pre>
 *      面试题6：从尾到头打印链表
 *
 *
 *      //队列和栈是一对好基友，从尾到头打印链表，当然离不开借助栈的帮忙啦
 *
 *      //所以，先把链表里的东西，都放到一个栈里去，然后按顺序把栈里的东西pop出来，就这么简单
 *
 * </pre>
 */
public class P58_PrintListInReversedOrder {

    public static void main(String[] args) {
        Node<String> node1 = new Node<>();

        Node<String> node2 = new Node<>();

        Node<String> node3 = new Node<>();

        node1.data = "data1";
        node2.data = "data2";
        node3.data = "data3";
        node1.next = node2;
        node2.next = node3;

        printListReverse(node1);

        System.out.println("######### 分割线");
        printReversinglyRecursively(node1);

    }

    /** 递归版 */
    public static void printReversinglyRecursively(Node<String> node){

        if (node != null) {
            if (node.next != null) {
                printReversinglyRecursively(node.next);
            }
            System.out.println(node.data);
        }

    }

    /**
     * 非递归的方式，鲁棒性好
     */
    public static void printListReverse(Node headNode) {

        Stack<Node> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }

    }


}

class Node<T> {

    T data;

    Node<T> next;

}
