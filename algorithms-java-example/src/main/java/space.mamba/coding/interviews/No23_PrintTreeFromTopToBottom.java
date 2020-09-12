package space.mamba.coding.interviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pankui
 * @date 2019-04-09
 * <pre>
 *      层序遍历二叉树（从上到下打印二叉树）
 *
 *
 *      运行结果:
 *          1   2   3   4   5   6   7
 * </pre>
 */
public class No23_PrintTreeFromTopToBottom {

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode root = TreeNode.initTreeNode();
        printFromTopToBottom(root);
    }

    public static void printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }

        //使用一个队列,进行广度优先遍历即可
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            //弹出
            temp = queue.poll();
            // 输出队首元素的值
            System.out.print(temp.val);
            System.out.print('\t');
            // 如果左子结点不为空，则左子结点入队
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            // 如果右子结点不为空，则左子结点入队
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
}
