package space.mamba.leetcode.algorithms;

import javax.print.DocFlavor;

/**
 * @author byte mamba
 * @date 2019/12/24
 * <pre>
 *      需要判断没有左子树或者右子树就完成了
 *
 *      BFS
 *
 *      DFS
 *
 *      分而治之
 *
 *
 *      TODO: 如果没有左子树 或者右子树 那么根节点不就是最小的深度了吗？不太理解这里还判断这些
 * </pre>
 */
public class No111_Minimum_Depth_of_Binary_Tree {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //没有左子树
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        //没有右子树
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // 分而治之
        int minLeftDepth = minDepth(root.left);

        int minRightDepth = minDepth(root.right);

        return 1 + Math.min(minLeftDepth, minRightDepth);

    }

    public static void main(String[] args) {
        No111_Minimum_Depth_of_Binary_Tree obj = new No111_Minimum_Depth_of_Binary_Tree();
        TreeNode treeNode = new TreeNode();
        TreeNode data = treeNode.getTestExampleData();

        int result = obj.minDepth(data);
        System.out.println("min:" + result);
    }
}
