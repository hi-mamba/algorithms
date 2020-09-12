package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/3
 * <pre>
 *      通过了解二叉搜索树，我们知道 左子树小于root，root小于右子树。
 * 因此只需要判断 p 与root.val的值来确认是在左还是在右，q 也是一样。
 * 如果都小于，那么它们都在左边。如果都大于那么都在右边，否则它们一个左一个右，当前 root就是目前的root.
 * </pre>
 */
public class No235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {


    public static void main(String[] args) {

        No235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree obj =
                new No235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();

        /*
               6
             /  \
            2     8
           / \    / \
          0   4  7   9
             / \
            3   5
         */

        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);

        TreeNode left2_left1 = new TreeNode(0);
        TreeNode left2_right1 = new TreeNode(4);
        TreeNode left2_right1_left = new TreeNode(3);
        TreeNode left2_right1_right = new TreeNode(5);

        TreeNode right2_left = new TreeNode(7);
        TreeNode right2_right = new TreeNode(9);

        root.left = left;
        left.left = left2_left1;
        left.right = left2_right1;
        left2_right1.left = left2_right1_left;
        left2_right1.right = left2_right1_right;

        root.right = right;
        right.left = right2_left;
        right.right = right2_right;


        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        TreeNode treeNode = obj.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == null || q == null) {
            return root;
        }

        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
