package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * @author mamba
 *
 * 给定一颗二叉搜索树，请找出其中的第k大的结点
 *
 * @date 2021/2/19 08:15
 */
public class No63BinarySearchTreeKNode {

    public static void main(String[] args) {
        No63BinarySearchTreeKNode obj = new No63BinarySearchTreeKNode();
        TreeNode kTreeNode = obj.kthLargest(TreeNode.initTreeNode3(), 3);
        System.out.println(kTreeNode.val);
        int kTreeNode2 = obj.kthLargest2(TreeNode.initTreeNode3(), 3);
        Assertions.assertEquals(kTreeNode2,2);

    }

    TreeNode res = null;

    int index = 0;

    TreeNode kthLargest(TreeNode treeNode, int k) {
        if (treeNode != null) {
            kthLargest(treeNode.left, k);
            index++;
            if (index == k) {
                res = treeNode;
            }
            kthLargest(treeNode.right, k);
        }
        return res;
    }

    // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/javaji-bai-100de-xiang-xi-jie-da-di-gui-he-die-dai/

    public int kthLargest2(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                //根据 搜索二叉树特点，先遍历右边，因为右边总比左边大
                root = root.right;
            }
            TreeNode pop = stack.pop();
            if (count == k) {
                return pop.val;
            }
            count++;
            root = pop.left;
        }
        return 0;

    }

}
