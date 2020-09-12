package space.mamba.logic_operation;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *   Bitwise or  |（按位或）
 *
 *   |按位或和&按位与计算方式都是转换二进制再计算，不同的是运算规则(一个为真即为真)1|0 = 1 , 1|1 = 1 , 0|0 = 0 , 0|1 = 1
 *
 * </pre>
 */
public class BitwiseOrExample01 {

    public static void main(String[] args) {
        System.out.println(6 | 2);
    }
}
