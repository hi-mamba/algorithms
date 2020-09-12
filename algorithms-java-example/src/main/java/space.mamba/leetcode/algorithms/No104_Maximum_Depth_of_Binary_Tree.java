package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/12/24
 * <pre>
 *
 *     BFS
 *     DFS
 *
 *     遍历最后，判断最大的
 *
 *
 *     分而治之
 *     分而治之
 *
 * </pre>
 */
public class No104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {


        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        No104_Maximum_Depth_of_Binary_Tree obj = new No104_Maximum_Depth_of_Binary_Tree();
        TreeNode treeNode = new TreeNode();
        TreeNode data = treeNode.getTestExampleData();
        System.out.println(data);
        int result = obj.maxDepth(data);
        System.out.println("max:" + result);
    }
}
