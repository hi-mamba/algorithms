package space.mamba.coding.interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mamba
 * @date 2021/2/22 08:06
 * <p>
 * 序列化二叉树
 */
public class No62_SerializeBinaryTree {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String result = codec.serialize(TreeNode.initTreeNode2());
        System.out.println(result);

        TreeNode deserializeResult = codec.deserialize("1,2,4,None,6,None,None,5,None,None,3,None,7,None,None,");
        //二叉树先序遍历
        TreeNode.preTraverseBinTree(deserializeResult);
    }
}

class Codec {

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(dataList);
    }
}
