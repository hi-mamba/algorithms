package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-02-18
 * <pre>
 *
 * </pre>
 */
public class No21_Merge_Two_Sorted_Lists {


    public static void main(String[] args) {
        No21_Merge_Two_Sorted_Lists obj = new No21_Merge_Two_Sorted_Lists();

        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(3);


        listNode1_2.next = listNode1_3;
        listNode1_1.next = listNode1_2;


        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        ListNode listNode2_3 = new ListNode(3);


        listNode2_2.next = listNode2_3;
        listNode2_1.next = listNode2_2;



        ListNode result = obj.mergeTwoLists(listNode1_1,listNode2_1);
        System.out.println(result);
        obj.printListNode(result);

        // 递归的有问题
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判断特殊值
        if (l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        //头引用，创建头结点
        ListNode list =new ListNode(0);
        //临时引用（指针）
        ListNode p = list;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if( l2 != null){
            p.next = l2;

        }
        if(l1 != null){
            p.next = l1;

        }

        //因为头结点的元素不是要求的两个链表中的元素，故从list.next开始返回
        return list.next;

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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}


