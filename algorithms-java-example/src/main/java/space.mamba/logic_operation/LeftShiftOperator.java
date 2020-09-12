package space.mamba.logic_operation;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *   Left shift operator 左移运算符
 * </pre>
 */
public class LeftShiftOperator {

    public static void main(String[] args) {

        /**
         * 5<<2的意思为5的二进制位往左挪两位，右边补0，5的二进制位是0000 0101 ，
         * 就是把有效值101往左挪两位就是0001 0100 ，
         * 正数左边第一位补0，负数补1，等于乘于2的n次方，十进制位是20
        * */
        // 等于乘以2的平方
        System.out.println(5 << 2);

        // 等于乘以2的一次方
        System.out.println(5 << 1);
    }
}
