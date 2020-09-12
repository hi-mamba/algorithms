package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-07
 * <pre>
 *      找链表中倒数第K个节点
 *
 *
 *      用两个指针，第一个指针先走k-1步，然后两个指针一起走，
 *      当第一个指针走到尾节点的时候。第二个指针指向的就是倒数第k个节点。
 *
 * </pre>
 */
public class No15_FindList_Last_K_Node {

    public static void main(String[] args) {
        ListNode ln1 = ListNode.initData();

        ListNode kListNode = findListNode(ln1, 3);

        ListNode.printListNode(ln1);

        System.out.println(kListNode.data);

    }

    //查找链表中倒数第k个结点

    public static ListNode findListNode(ListNode head, int k) {


        // 判断链表是否为空以及k是否为小于0的数
        if (head == null || k < 0) { // 链表不能为空，查找的倒数第k个结点k不能小于0
            return null;
        }
        // 开始时声明两个结点使其都指向头结点
        ListNode aNode = head;
        ListNode bNode = head;
        // 使aNode达到第k个结点
        for (int i = 0; i < k - 1; i++) {
            if (aNode.next != null) {
                aNode = aNode.next;
            } else {
                return null; // 链表太短，打不到k个结点
            }
        }
        while (aNode.next != null) {
            aNode = aNode.next;
            bNode = bNode.next;
        }
        return bNode; // bNode即为倒数第k个结点
    }
}
