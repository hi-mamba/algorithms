package space.mamba.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author byte mamba
 * @date 2019/12/25
 * <pre>
 *
 * </pre>
 */
public class No22_Generate_Parentheses {

    public static void main(String[] args) {

        System.out.println(new No22_Generate_Parentheses().generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOnoByOne("", result, n, n);
        return result;
    }

    private void generateOnoByOne(String subList, List<String> result, int left, int right) {

        if (left == 0 && right == 0) {
            result.add(subList);
            return;
        }
        if (left > 0) {
            generateOnoByOne(subList + "(", result, left - 1, right);
        }

        if (right > left) {
            generateOnoByOne(subList + ")", result, left, right - 1);
        }
    }
}
