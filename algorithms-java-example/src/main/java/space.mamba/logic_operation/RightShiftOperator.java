package space.mamba.logic_operation;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *      >>（右移运算符）
 * </pre>
 */
public class RightShiftOperator {

    public static void main(String[] args) {

        /**
         * 凡位运算符都是把值先转换成二进制再进行后续的处理，
         *
         * 5的二进制位是0000 0101，右移两位就是把101左移后为0000 0001，正数左边第一位补0，负数补1，等于除于2的n次方，结果为1
         * */
        // 等于除于2的平方
        System.out.println(5 >> 2);

        // 等于除于2的一次方
        System.out.println(5 >> 1);
    }
}
