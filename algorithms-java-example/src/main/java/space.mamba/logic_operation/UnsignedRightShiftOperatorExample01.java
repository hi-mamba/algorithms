package space.mamba.logic_operation;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *      Unsigned right shift operator
 *      无符号右移运算符
 *
 *      无符号右移运算符和右移运算符的主要区别在于负数的计算，因为无符号右移是高位补0，移多少位补多少个0。
 *
 *      15的二进制位是0000 1111 ， 右移2位0000 0011，结果为3
 *
 * </pre>
 */
public class UnsignedRightShiftOperatorExample01 {

    public static void main(String[] args) {

        // 无符号右移运算符和右移运算符的主要区别在于负数的计算，因为无符号右移是高位补0，移多少位补多少个0。
        //  15的二进制位是0000 1111 ， 右移2位0000 0011，结果为3
        System.out.println(15 >>> 2);


        // -6的二进制是6的二进制取反再加1,6的二进制也就是0000 0000 0000 0000 0000 0000 0000 0110，
        // 取反后加1为1111 1111 1111 1111 1111 1111 1111 1010，
        // 右移三位0001 1111 1111 1111 1111 1111 1111 1111

        System.out.println(-6 >>> 3);
    }
}
