package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-02
 * <pre>
 *      题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * </pre>
 */
public class No13_DeleteNode {

    public static void main(String[] args) {

        No13_DeleteNode no13_deleteNode = new No13_DeleteNode();

        ListNode head = new ListNode();
        head.data = 1;

        head.next = new ListNode();
        head.next.data = 2;

        head.next.next = new ListNode();
        head.next.next.data = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.data = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.data = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.data = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.data = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.data = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.data = 9;

        // 删除的结点为空
        System.out.println("### 删除的结点为空 之前： ");
        no13_deleteNode.printList(head);
        head = no13_deleteNode.deleteNode(head, null);
        no13_deleteNode.printList(head);
        System.out.println("### 删除的结点为空 之后");
        System.out.println();
        // 删除头结点
        System.out.println("### 删除头结点之前： ");
        no13_deleteNode.printList(head);
        head = no13_deleteNode.deleteNode(head, head);
        System.out.println("### 删除之后");
        no13_deleteNode.printList(head);
        System.out.println();

        // 删除尾结点
        System.out.println("### 删除尾结 之前： ");
        no13_deleteNode.printList(head);
        head = no13_deleteNode.deleteNode(head, last);
        no13_deleteNode.printList(head);
        System.out.println("### 删除尾结 之后： ");
        System.out.println();
        // 删除中间结点
        head = no13_deleteNode.deleteNode(head, middle);
        no13_deleteNode.printList(head);

        // 删除的结点不在链表中
        ListNode node = new ListNode();
        node.data = 12;

        head = no13_deleteNode.deleteNode(head, node);
        no13_deleteNode.printList(head);

    }


    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
     * 【注意1：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，
     * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】
     * 【注意2：输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证】
     *
     * @param head        链表表的头
     * @param toBeDeleted 待删除的结点
     * @return 删除后的头结点
     */
    public ListNode deleteNode(ListNode head, ListNode toBeDeleted) {

        // 如果输入参数有空值就返回表头结点
        if (head == null || toBeDeleted == null) {
            return head;
        }
        // 如果删除的是头结点，直接返回头结点的下一个结点
        if (head == toBeDeleted) {
            return head.next;
        }
        // 在多个节点的情况下，如果删除的是最后一个元素,要删除的是尾节点:O(n)时间
        if (toBeDeleted.next == null) {
            ListNode temp = head;
            while (temp.next != toBeDeleted) {
                temp = temp.next;
            }
            // 删除待结点
            temp.next = null;
        }
        //要删除节点是中间节
        else {
            // 将下一个结点的值输入当前待删除的结点
            toBeDeleted.data = toBeDeleted.next.data;
            // 待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
            toBeDeleted.next = toBeDeleted.next.next;
        }
        // 返回删除节点后的链表头结点
        return head;
    }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
