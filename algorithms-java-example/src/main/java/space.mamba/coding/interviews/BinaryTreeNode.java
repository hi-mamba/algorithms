package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-20
 * <pre>
 *
 *   题目描述：
 *
 *      输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *      假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *      例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 *      先来分析一下前序遍历和中序遍历得到的结果，
 *
 *      前序遍历第一位是根节点；
 *      中序遍历中，根节点左边的是根节点的左子树，右边是根节点的右子树。
 *
 *      例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}。
 *
 *      首先，根节点 是{ 1 }；
 *      左子树是：前序{ 2,4,7 } ，中序{ 4,7,2 }；
 *      右子树是：前序{ 3,5,6,8 } ，中序{ 5,3,8,6 }；
 *
 *      这时，如果我们把左子树和右子树分别作为新的二叉树，则可以求出其根节点，左子树和右子树。
 *
 *      这样，一直用这个方式，就可以实现重建二叉树。
 *
 *               1
 *             /   \
 *            2     3
 *           /     / \
 *          4     5   6
 *           \        /
 *           7        8
 *
 * </pre>
 */
public class BinaryTreeNode {

    //主功能函数
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode mm = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return mm;
    }

    //核心递归
    public static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode tree = new TreeNode(pre[preStart]);
        tree.left = null;
        tree.right = null;
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        int root = 0;
        for (root = inStart; root < inEnd; root++) {
            if (pre[preStart] == in[root]) {
                break;
            }
        }
        int leifLength = root - inStart;
        int rightLength = inEnd - root;
        if (leifLength > 0) {
            tree.left = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leifLength, inStart, root - 1);
        }
        if (rightLength > 0) {
            tree.right = reConstructBinaryTreeCore(pre, in, preStart + 1 + leifLength, preEnd, root + 1, inEnd);
        }
        return tree;
    }

    //将二叉树先序遍历，用于测试结果
    public static void preTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ",");
        if (node.left != null) {
            preTraverseBinTree(node.left);
        }
        if (node.right != null) {
            preTraverseBinTree(node.right);
        }
    }

    //将二叉树中序遍历，用于测试结果
    public static void inTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inTraverseBinTree(node.left);
        }
        System.out.print(node.val + ",");
        if (node.right != null) {
            inTraverseBinTree(node.right);
        }
    }

    //将二叉树后序遍历，用于测试结果
    public static void postTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postTraverseBinTree(node.left);
        }
        if (node.right != null) {
            postTraverseBinTree(node.right);
        }
        System.out.print(node.val + ",");
    }

    //主函数，用于测试结果
    public static void main(String[] args) {
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        TreeNode tree = reConstructBinaryTree(pre, in);
        System.out.print("先序遍历结果:  {");
        preTraverseBinTree(tree);
        System.out.println("}");

        System.out.print("中序遍历结果:  {");
        inTraverseBinTree(tree);
        System.out.println("}");

        System.out.print("后序遍历结果:  {");
        postTraverseBinTree(tree);
        System.out.println("}");
    }


}
