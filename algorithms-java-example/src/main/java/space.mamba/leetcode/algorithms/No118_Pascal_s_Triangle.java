package space.mamba.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author byte mamba
 * @date 2020/1/6
 * <pre>
 *      https://leetcode.com/problems/pascals-triangle/
 *
 *      118. Pascal's Triangle
 * Add to List
 *
 * Share
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * </pre>
 */
public class No118_Pascal_s_Triangle {

    public static void main(String[] args) {
        No118_Pascal_s_Triangle obj = new No118_Pascal_s_Triangle();
        //  System.out.println(obj.generate(3));
        System.out.println(obj.generate(5));
    }

    /**
     * leetcode 目前不支持JDK9 之后的？
     */
    public List<List<Integer>> generateJDK9(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>();
        if (numRows == 1) {
            triangleList.add(List.of(1));
            return triangleList;
        }
        if (numRows == 2) {
            triangleList.add(List.of(1, 1));
            return triangleList;
        }

        triangleList.add(List.of(1));
        triangleList.add(List.of(1, 1));

        for (int i = 2; i < numRows; i++) {
            // 首是1
            List<Integer> list = new ArrayList<>(List.of(1));
            // 获取上一个来做循环 triangleList
            List<Integer> lastList = triangleList.get(triangleList.size() - 1);
            for (int j = 1; j < lastList.size(); j++) {
                // 上一个
                int value = lastList.get(j - 1) + lastList.get(j);
                list.add(value);
            }
            // 尾也是1
            list.add(1);
            triangleList.add(list);
        }

        return triangleList;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>();

        if (numRows == 0) {
            return triangleList;
        }
        List<Integer> initList = new ArrayList<>();
        initList.add(1);
        triangleList.add(initList);
        if (numRows == 1) {
            return triangleList;
        }
        initList = new ArrayList<>();
        initList.add(1);
        initList.add(1);
        triangleList.add(initList);
        if (numRows == 2) {
            return triangleList;
        }

        for (int i = 2; i < numRows; i++) {
            // 首是1
            List<Integer> list = new ArrayList<>();
            list.add(1);
            // 获取上一个来做循环 triangleList
            List<Integer> lastList = triangleList.get(triangleList.size() - 1);
            for (int j = 1; j < lastList.size(); j++) {
                // 上一个
                int value = lastList.get(j - 1) + lastList.get(j);
                list.add(value);
            }
            // 尾也是1
            list.add(1);
            triangleList.add(list);
        }

        return triangleList;
    }
}
