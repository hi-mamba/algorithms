package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/3
 * <pre>
 *
 * </pre>
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(){}

    @Override
    public String toString() {
        return "" + val;
    }

    public TreeNode getTestExampleData() {
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
        return root;
    }
}
