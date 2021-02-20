package space.mamba.coding.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mamba
 * @date 2021/2/19 08:15
 */
public class No61PrintBinaryTree_2 {

    public static void main(String[] args) {
        No61PrintBinaryTree_2 obj = new No61PrintBinaryTree_2();
        TreeNode root = TreeNode.initTreeNode();
        List<List<Integer>> result = obj.levelOrder(root);
        System.out.println(result);

        System.out.println("###");
        List<List<Integer>> result2 = obj.levelOrder(null);
        System.out.println(result2);

        System.out.println("###");
        List<List<Integer>> result3 = obj.levelOrder(new TreeNode());
        System.out.println(result3);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //保存每层打印
            List<Integer> tmp = new ArrayList<>();
            //每层的打印, 注意这里的循环!!!
            for (int i = queue.size(); i > 0; i--) {

                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
