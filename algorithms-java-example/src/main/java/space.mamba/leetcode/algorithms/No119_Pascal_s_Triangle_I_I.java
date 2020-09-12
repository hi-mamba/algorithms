package space.mamba.leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * @author byte mamba
 * @date 2020/1/6
 * <pre>
 *      https://leetcode.com/problems/pascals-triangle-ii/
 *
 *     119. Pascal's Triangle II
 *
 *      Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 *
 * Could you optimize your algorithm to use only O(k) extra space?【重点】 O(n) 空间复杂度
 *
 * 参考 118
 *
 *
 * [C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]
 *
 * C[k,i] = C[k,i-1]*(k-i+1)/i
 *
 * </pre>
 */
public class No119_Pascal_s_Triangle_I_I {

    public static void main(String[] args) {
        No119_Pascal_s_Triangle_I_I obj = new No119_Pascal_s_Triangle_I_I();
        //  System.out.println(obj.generate(3));
        System.out.println(obj.getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {
        Integer[] rowList = new Integer[rowIndex+1];
        rowList[0] = 1;
        for(int i=1; i<rowList.length;i++) {
            rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
        }
        return Arrays.asList(rowList);
    }
}
