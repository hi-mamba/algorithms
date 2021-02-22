package space.mamba.coding.interviews;


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
}
