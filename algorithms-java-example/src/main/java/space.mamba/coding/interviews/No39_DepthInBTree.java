package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mamba
 * @date 2020/7/7 08:05
 * <p>
 * 二叉树的深度
 */
public class No39_DepthInBTree {

    //            1
    //          /   \
    //         2     3
    //       /  \    \
    //      4    5    7
    //       \
    //        6
    //
    public static void main(String[] args) {

        System.out.println(depthInBTree(TreeNode.initTreeNode()));
        System.out.println(depthInBTree(TreeNode.initTreeNode2()));
        Assertions.assertEquals(depthInBTree(TreeNode.initTreeNode()), 3);
        Assertions.assertEquals(depthInBTree(TreeNode.initTreeNode2()), 4);
        System.out.println("----");
        Assertions.assertEquals(treeDepth2(TreeNode.initTreeNode2()), 4);

    }

    //递归
    private static int depthInBTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = depthInBTree(treeNode.left);
        int right = depthInBTree(treeNode.right);

        return left > right ? (left + 1) : (right + 1);
    }

    //非递归，广度优先/层序遍历
    public static int treeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
