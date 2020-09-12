package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-08
 * <pre>
 *      判断二叉树A中是否包含子树B
 *      https://blog.csdn.net/smile_YangYue/article/details/79794729
 * </pre>
 */
public class No18_HasSubTree {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.right = new TreeNode(2);
        tree1.left = new TreeNode(3);
        tree1.right.right = new TreeNode(4);
        tree1.right.left = new TreeNode(5);
        tree1.left.right = new TreeNode(6);
        tree1.left.left = new TreeNode(7);
        tree1.right.right.right = new TreeNode(8);

        TreeNode tree2 = new TreeNode(3);
        tree2.right = new TreeNode(6);
        tree2.left = new TreeNode(7);

        boolean result = hasSubTree(tree1, tree2);
        System.out.println(result);

    }

    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;

        // 如果找到了对应Tree2的根节点的点
        if (root1.val == root2.val) {
            // 以这个根节点为为起点判断是否包含Tree2
            result = doesTree1HasTree2(root1, root2);
        }

        // 如果找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
        if (!result) {
            result = doesTree1HasTree2(root1.right, root2);
        }
        // 如果还找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
        if (!result) {
            result = doesTree1HasTree2(root1.left, root2);
        }
        return result;

    }

    public static boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {

        // 如果Tree2已经遍历完了都能对应的上，返回true，这个判断条件一定要放在下面那个条件的上面，不然就会出现错误，可能两个
        // 都到达叶子节点了，但是把下面放在前面就会返回false，实际上刚刚好都相同
        if (root2 == null) {
            return true;
        }
        // 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null) {
            return false;
        }
        // 如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val) {
            return false;
        }
        // 如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}