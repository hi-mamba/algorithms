package space.mamba.coding.interviews;

import java.util.*;

/**
 * @author mamba
 * @date 2021/2/19 08:15
 * <p>
 *     .二叉树的下一个节点
 */
public class No58GetNextBinaryTree {

    public static void main(String[] args) {

    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        //二叉树为空
        if (pNode == null) {
            return null;
        }
        //若有右孩子，则找右孩子的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //该节点不是根节点，若该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext2(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //1.当前节点有右子树，则去递归寻找左子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //2.当前节点无右子树，且有父节点
        while (pNode.next != null) {
            //2.1当前节点为父节点的左子树
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            //2.2当前节点为父节点的右子树，则继续往上找
            pNode = pNode.next;
        }
        //3.既无右子树也父节点，即根节点返回null
        return null;
    }
}
