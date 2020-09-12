package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019/11/21
 * <pre>
 *   数组的方式判断，这个执行时间比栈快
 * </pre>
 */
public class No20Valid_Parentheses_Array {


    public boolean isValid(String s) {

        if (s == null) {
            return true;
        }

        char[] ch = new char[s.length()];

        char[] c = s.toCharArray();

        int j = 0;
        boolean flag = false;

        if (c.length % 2 != 0) {
            return flag;
        }

        for (int i = 0; i < c.length; i++) {

            if (c[i] == '{' || c[i] == '(' || c[i] == '[') {

                ch[j] = c[i];
                j++;

            } else if (c[i] == '}' && (j - 1) >= 0 && ch[j - 1] == '{') {

                j--;
                flag = true;
            } else if (c[i] == ']' && (j - 1) >= 0 && ch[j - 1] == '[') {

                j--;
                flag = true;

            } else if (c[i] == ')' && (j - 1) >= 0 && ch[j - 1] == '(') {

                j--;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }


        return flag;
    }
}
