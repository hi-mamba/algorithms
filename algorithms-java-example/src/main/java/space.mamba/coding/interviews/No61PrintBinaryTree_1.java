package space.mamba.coding.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mamba
 * @date 2021/2/19 08:15
 * <p>
 * 解题思路：
 * 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
 * BFS 通常借助 队列 的先入先出特性来实现。
 */
public class No61PrintBinaryTree_1 {

    public static void main(String[] args) {
        No61PrintBinaryTree_1 obj = new No61PrintBinaryTree_1();
        TreeNode root = TreeNode.initTreeNode();
        int[] result = obj.levelOrder(root);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            ans.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
