package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-02-19
 * <pre>
 *
 *      82. Remove Duplicates from Sorted List II
 *      Medium
 *
 *      Given a sorted linked list, delete all nodes that have duplicate numbers,
 *      leaving only distinct numbers from the original list.
 *
 *      Example 1:
 *
 *      Input: 1->2->3->3->4->4->5
 *      Output: 1->2->5
 *      Example 2:
 *
 *      Input: 1->1->1->2->3
 *      Output: 2->3
 *      </pre>
 */
public class No82_Remove_Duplicates_from_Sorted_List_II {


    public static void main(String[] args) {

        No82_Remove_Duplicates_from_Sorted_List_II obj = new No82_Remove_Duplicates_from_Sorted_List_II();

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);

        head3.next = head4;
        head2.next = head3;
        head1.next = head2;
        head.next = head1;

        System.out.println("去重前打印");
        obj.printListNode(head);

        System.out.println();
        System.out.println("去重后打印");
        ListNode result = obj.deleteDuplicates(head);
        obj.printListNode(result);
    }

    public ListNode deleteDuplicates_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode p = head.next;

        while (p != null) {
            if (p.val == prev.val) {
                prev.next = p.next;
                p = p.next;


                //no change prev
            } else {
                prev = p;
                p = p.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int dup = p.next.val;
                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }

        }

        return t.next;
    }

    public void printListNode(ListNode result) {

        while (result != null) {
            Integer val = result.val;
            System.out.print(val + "->");
            if (result.next == null) {
                break;
            }
            result = result.next;
        }

        System.out.println();

    }

}
