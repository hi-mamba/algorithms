package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/2
 * <pre>
 *
 * </pre>
 */
public class No98_Validate_Binary_Search_Tree {

    public static void main(String[] args) {

        No98_Validate_Binary_Search_Tree obj = new No98_Validate_Binary_Search_Tree();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;
        boolean result = obj.isValidBST(root);
        System.out.println(result);


        TreeNode root_1 = new TreeNode(5);
        TreeNode left_1 = new TreeNode(6);
        TreeNode right_1 = new TreeNode(3);

        root_1.left = left_1;
        root_1.right = right_1;
        result = obj.isValidBST(root_1);
        System.out.println(result);

    }

    /**
     * Java Solution using Recursion
     * 递归
     */
    public boolean isValidBST(TreeNode root) {

        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        // 左子树都小于根节点，一直递归到 null，右子树都大于根节点，一直递归到null ，都满足就返回TRUE
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }


}


