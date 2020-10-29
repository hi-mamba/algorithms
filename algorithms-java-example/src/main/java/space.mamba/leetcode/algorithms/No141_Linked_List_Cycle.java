package space.mamba.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mamba
 * @date 2020/10/26 08:19
 */
public class No141_Linked_List_Cycle {


    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();

        while(head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

}
