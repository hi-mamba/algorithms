package space.mamba.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mamba
 * @date 2020/11/3 08:15
 */
public class No100_Same_Tree {

    public static void main(String[] args) {

        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();
        boolean result = isSameTree(p.getTestExampleData(), q.getTestExampleData());
        boolean result2 = isSameTree(p.getTestExampleData(), new TreeNode());

        System.out.println(result);
        System.out.println(result2);


    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        List<Integer> leftSet = new ArrayList<>();
        while (p.left != null) {
            leftSet.add(p.val);
            p = p.left;
        }

        while (p.right != null) {
            leftSet.add(p.val);
            p = p.right;
        }

        List<Integer> rightSet = new ArrayList<>();
        while (q.left != null) {
            rightSet.add(q.val);
            q = q.left;
        }

        while (q.right != null) {
            rightSet.add(q.val);
            q = q.right;
        }

        return leftSet.equals(rightSet);
    }
}
