package space.mamba.coding.interviews;

import java.util.Stack;

/**
 * @author pankui
 * @date 2019-04-07
 * <pre>
 *      输出反转后的链表
 * </pre>
 */
public class No16_ReverseList {

    public static void main(String[] args) {
        ListNode ln1 = ListNode.initData();
        ListNode.printListNode(ln1);

        ListNode.printListNode(reverseList3(ln1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;//next保存head下一个节点
            head.next = pre;//将当前节点next指向前一个节点，实现反转
            pre = head;//将当前节点的前节点后移
            head = next;//将当前节点后移
        }
        return pre;
    }

    //Stack反转链表
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode listNode = new ListNode(head.data);
            stack.push(listNode);
            head = head.next;
        }

        ListNode current = stack.pop();
        ListNode newHead = current;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        return newHead;
    }
    //    递归反转链表
    private static ListNode reverseList3(ListNode head) {
        if(head==null||head.next ==null) {
         //   System.out.println("判断满足条件：" + head);
         //   System.out.println("       ");
            return head;
        }
        ListNode next = head.next;
       // System.out.println("next:" + next + ",head:" + head);
        ListNode prev = reverseList3(next);

        System.out.println("递归打印prev：" + prev);
        System.out.println("递归打印head：" + head);

        //第一次递归到会把 data=8 指向 data = 7
        head.next.next = head;
        //打印就异常
        //System.out.println("head:"+head);
        //把data = 7 的下一个指向先删除
        head.next = null;
        System.out.println("------" + head + ",prev:" + prev);
        return prev;

        //递归第一轮
        // 当 ListNode(data=8,next=null) 的时候返回
        // 此时 prev: ListNode{data=8, next=null}
        // head：ListNode{data=7, next=ListNode{data=8, next=null}}
        // head.next.next = ListNode{data=7, next=ListNode{data=8, next=null}}
    }
}
