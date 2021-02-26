package space.mamba.coding.interviews;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mamba
 * @date 2021/2/26 08:18
 */
public class No56_DetectCycle {

    public static void main(String[] args) {
        No56_DetectCycle obj = new No56_DetectCycle();
        ListNode head = ListNode.initRing();
        ListNode result = obj.detectCycle(head);
        //由于是 环，不能打印 result
        System.out.println(result.data);
    }

    ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos!=null) {
            if (visited.contains(pos)) {
                return pos;
            }else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
