package space.mamba.logic_operation;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *
 *   &按位与的运算
 *
 *   &按位与的运算规则是将两边的数转换为二进制位，然后运算最终值，
 *   运算规则即(两个为真才为真)1&1=1 , 1&0=0 , 0&1=0 , 0&0=0
 *
 *   3的二进制位是0000 0011 ， 5的二进制位是0000 0101 ， 那么就是011 & 101，由按位与运算规则得知，001 & 101等于0000 0001，最终值为1
 *
 *   7的二进制位是0000 0111，那就是111 & 101等于101，也就是0000 0101，故值为5
 *
 * </pre>
 */
public class BitwiseAndExample01 {

    public static void main(String[] args) {
        //&按位与的运算规则是将两边的数转换为二进制位，然后运算最终值
        // int 是八位  011  001
        System.out.println(3 & 1);

        System.out.println(3 & 5);

        System.out.println(7 & 5);
    }
}
