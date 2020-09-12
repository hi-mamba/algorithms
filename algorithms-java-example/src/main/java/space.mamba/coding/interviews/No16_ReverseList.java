package space.mamba.coding.interviews;

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

        ListNode.printListNode(reverseList(ln1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
