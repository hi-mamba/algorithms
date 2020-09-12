package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-26
 * <pre>
 *
 * </pre>
 */
public class BitCountExample01 {
    public static void main(String[] args) {

        int result = new BitCountExample01().bitCount(7);
        System.out.println(result);

        int result2 = new BitCountExample01().bitCount(8);
        System.out.println(result2);

        int result3 = new BitCountExample01().bitCount1(9);
        System.out.println(result3);

        int result4 = new BitCountExample01().bitCount2(11);
        System.out.println(result4);



    }


    int bitCount(int n) {
        // 计数器
        int c = 0;
        while (n > 0) {
            // 当前位是1
            System.out.println(n+" & 1=" + (n & 1));
            // 任何值 & 1 来判断最后一位是否有1，因为  1&1=1 , 1&0=0 , 0&1=0 , 0&0=0
            // 1的八位表示   0000 00001  所以最后一位是1 才判断是否是1
            if ((n & 1) == 1) {
                // 计数器加1
                ++c;
            }
            // 移位
            n >>= 1;
        }
        return c;
    }

    int bitCount1(int n) {
        // 计数器
        int c = 0;
        // 循环移位
        for (c = 0; n > 0; n >>= 1) {
            // 如果当前位是1，则计数器加1
            c += n & 1;
        }
        return c;
    }


    int bitCount2(int n) {
        int c = 0;
        for (c = 0; n > 0; ++c) {
            // 清除最低位的1
            System.out.println("==="+(n & (n - 1))+" n="+n);
            // n = n & (n - 1)
            n &= (n - 1);
        }
        return c;
    }
}
