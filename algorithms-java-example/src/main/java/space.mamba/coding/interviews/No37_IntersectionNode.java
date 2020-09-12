package space.mamba.coding.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mamba
 * @date 2020/6/27 18:48
 */
public class No37_IntersectionNode {

    public static void main(String[] args) {

        System.out.println(getIntersectionNode(ListNode.initData(), ListNode.initData3()));
        System.out.println("---");

        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;


        System.out.println(getIntersectionNode2(n1, n4));
    }


    /**
     * 遍历+哈希表记录
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        while (headA != null) {
            map.put(headA.data, true);
            headA = headA.next;
        }

        ListNode listNode = new ListNode();
        while (headB != null) {
            if (map.containsKey(headB.data)) {
                listNode.data = headB.data;
                return listNode;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 快慢指针发
     *
     * 我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，
     * 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；
     * 当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
     *
     * TODO 如果 这两个链表有多个 公共节点，那么下面这里就有问题！！！
     *
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //思路：双指针法。
        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }

}
