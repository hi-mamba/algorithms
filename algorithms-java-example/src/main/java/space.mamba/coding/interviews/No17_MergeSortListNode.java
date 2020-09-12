package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-07
 * <pre>
 *      合并两个有序链表
 *
 *      推荐去 合并两个有序的数组
 * </pre>
 */
public class No17_MergeSortListNode {

    public static void main(String[] args) {

        ListNode firstNode = ListNode.initData2();

        ListNode secondNode = ListNode.initData3();

        ListNode node = merge(firstNode, secondNode);
        ListNode.printListNode(node);

        System.out.println("########3 华丽分割线");

        ListNode firstNode2 = ListNode.initData2();

        ListNode secondNode2 = ListNode.initData3();

        ListNode node2 = mergeTwoLists(firstNode2, secondNode2);

        ListNode.printListNode(node2);

    }

    public static ListNode merge(ListNode firstNode, ListNode secondNode) {

        if (firstNode == null) {
            return secondNode;
        }

        if (secondNode == null) {
            return firstNode;
        }

        ListNode mergeHead = new ListNode();
        ListNode currentNode = mergeHead;
        while (firstNode != null && secondNode != null) {

            if (firstNode.data > secondNode.data) {
                currentNode.next = secondNode;
                secondNode = secondNode.next;

            } else {
                currentNode.next = firstNode;
                firstNode = firstNode.next;
            }
            currentNode = currentNode.next;
        }

        if (firstNode != null) {
            currentNode.next = firstNode;
        }

        if (secondNode != null) {
            currentNode.next = secondNode;
        }

        return mergeHead.next;
    }

    /**
     * 递归
     * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
