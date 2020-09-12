package space.mamba.coding.interviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pankui
 * @date 2019-04-09
 * <pre>
 *
 * </pre>
 */
public class No23_printTreeInLine {

    /**
     * Created by ryder on 2017/7/18.
     * 分行从上到下打印二叉树
     */
    public static void printTreeInLine(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                temp = queue.poll();
                System.out.print(temp.val);
                System.out.print("\t");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode root = TreeNode.initTreeNode();
        printTreeInLine(root);
    }
}
