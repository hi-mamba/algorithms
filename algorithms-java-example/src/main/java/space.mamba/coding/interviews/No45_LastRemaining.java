package space.mamba.coding.interviews;

/**
 * @author mamba
 * @ 2020/7/26
 *
 * 圆圈中最后剩下的数（约瑟夫环问题）
 *
 */
public class No45_LastRemaining {


    public static void main(String[] args) {
        ListNode listNode = ListNode.initRing();
        System.out.println(getLastRemaining(listNode, 3));
        System.out.println("---------");
        System.out.println(lastRemaining(7, 3));
    }

    public static int getLastRemaining(ListNode firstNode,int m) {

        ListNode currNode = firstNode;
        while (currNode.next != currNode) {
            ListNode prev = null;
            for (int i = 0; i < m - 1; i++) {
                // 这里是不断让环断开，把不符合条件的连接起来
                prev = currNode;
                // currNode 就是要删除的点
                currNode = currNode.next;
                System.out.println(currNode.data +",prev="+prev.data);
            }
            System.out.println("==");

         //  ListNode.printListNode(currNode);

            prev.next = currNode.next;
            currNode = null;
            currNode = prev.next;  // 让循环继续
        }
        return currNode.data;
    }

    static int lastRemaining(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }
}
