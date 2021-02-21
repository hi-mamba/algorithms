package space.mamba.coding.interviews;

import java.util.*;

/**
 * @author mamba
 * @date 2021/2/19 08:15
 * <p>
 * 解题思路：
 * 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
 * BFS 通常借助 队列 的先入先出特性来实现。
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 */
public class No60PrintBinaryTree {

    public static void main(String[] args) {
        No60PrintBinaryTree obj = new No60PrintBinaryTree();
        TreeNode root = TreeNode.initTreeNode2();
        List<List<Integer>> result = obj.levelOrder(root);
        System.out.println(result);
        // [[1], [3, 2], [4, 5, 7], [6]]

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                if (ans.size() % 2 == 0) {
                    tmp.addLast(treeNode.val);
                }else {
                    tmp.addFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        List<List<Integer>> ans = new ArrayList<>();
        int mark = 1;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            // 判断，翻转  tmp list
            if (mark % 2 == 0) {
                Collections.reverse(tmp);
            }
            ans.add(tmp);
            mark++;
        }
        return ans;
    }
}
