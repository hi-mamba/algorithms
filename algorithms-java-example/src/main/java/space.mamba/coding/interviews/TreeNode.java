package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-08
 * <pre>
 *
 * 首先建立一个二叉树类
 * </pre>
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }


    TreeNode(int x) {
        val = x;
    }

    public static int[] initdData() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        return pre;
    }

    public static TreeNode initTreeNode() {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode initTreeNode2() {
        //            1
        //          /   \
        //         2     3
        //       /  \    \
        //      4    5    7
        //       \
        //        6
        //
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
}
