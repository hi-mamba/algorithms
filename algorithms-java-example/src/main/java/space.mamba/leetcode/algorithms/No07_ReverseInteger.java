package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-02-12
 * <pre>
 *      翻转一个long类型数字。例如输入123456L，输出654321L。
 *
 *      https://leetcode.com/problems/reverse-integer/
 * </pre>
 */
public class No07_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new No07_ReverseInteger().reverse(12345));
        System.out.println(new No07_ReverseInteger().reverse(67890));
    }

    public int reverse(int x) {
        long xlong = 0;

        while (x != 0) {

            xlong = xlong * 10 + x % 10;

            if (xlong > Integer.MAX_VALUE || xlong < Integer.MIN_VALUE) {
                return 0;
            }

            x = x / 10;
        }

        return (int) xlong;

    }

    /**
     * 投机取巧,哈哈哈哈
     * */
    public int reverse_2(int x) {
        try {
            if (x < 0) {
                StringBuffer stringBuffer = new StringBuffer(String.valueOf(x).substring(1));
                stringBuffer.reverse();
                int i = -Integer.parseInt(stringBuffer.toString());
                return i;
            } else {
                StringBuffer stringBuffer = new StringBuffer(String.valueOf(x));
                stringBuffer.reverse();
                return Integer.parseInt(stringBuffer.toString());
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return 0;
        }
    }
}
