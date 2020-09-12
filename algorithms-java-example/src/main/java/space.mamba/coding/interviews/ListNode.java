package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-07
 * <pre>
 *
 * </pre>
 */
public class ListNode {

    /**
     * 保存链表的值
     */
    public int data;

    /**
     * 下一个节点
     */
    public ListNode next;

    public ListNode(){}

    public ListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    /**注意环的问题*/
    public int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        ListNode currNode = head;
        while (currNode != null) {
            len ++;
            currNode = currNode.next;
        }
        return len;
    }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printListNode(ListNode head) {
        // 解决环的问题
        while (head != null && head.next != head) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode initData() {
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        ln1.data = 1;
        ln2.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;
        ln8.data = 8;
        return ln1;
    }

    public static ListNode initData2() {
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ln1.next = ln2;
        ln2.next = ln3;
        ln1.data = 1;
        ln2.data = 3;
        ln3.data = 5;
        return ln1;
    }

    public static ListNode initData3() {
        ListNode listNode1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        listNode1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        listNode1.data = 2;
        ln2.data = 6;
        ln3.data = 8;
        ln4.data = 10;
        return listNode1;
    }
    /**环形*/
    public static ListNode initRing() {
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln1;
        ln1.data = 1;
        ln2.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;

        return ln1;
    }

}
