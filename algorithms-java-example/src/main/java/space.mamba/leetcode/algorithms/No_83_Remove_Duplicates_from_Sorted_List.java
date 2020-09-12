package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-02-19
 * <pre>
 *      Remove Duplicates from Sorted List
 *
 *      https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 *      Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * </pre>
 */
public class No_83_Remove_Duplicates_from_Sorted_List {

    public static void main(String[] args) {
        No_83_Remove_Duplicates_from_Sorted_List obj = new No_83_Remove_Duplicates_from_Sorted_List();

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
    public ListNode deleteDuplicates(ListNode head) {

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
            }else{
                prev = p;
                p = p.next;
            }
        }

        return head;
    }

    public void printListNode(ListNode result){

        while (result != null) {
            Integer val = result.val;
            System.out.print(val+"->");
            if (result.next == null) {
                break;
            }
            result = result.next;
        }

        System.out.println();

    }
}




