package space.mamba.coding.interviews;

import java.util.Arrays;

/**
 * @author mamba
 * @ 2020/7/26
 *
 * 不用加减乘除做加法
 *
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
 *
 */
public class No47_Add {

    public static void main(String[] args) {
        System.out.println(add(1,7));
        System.out.println(add(3,11));
        System.out.println("--");
        System.out.println(add2(3,11));
    }

    /**
     * 不用加减乘除做加法
     *
     * 1、加法其实质为各位相加结果（不考虑进位）+ 进位值
     *
     * 2、各位相加结果（不考虑进位）等价于 加数二进制异或结果
     *
     * 进位值等价于加数按位与并向左移动一位
     *
     * 3、第一步和第二部反复迭代，最终没有进位，那么各位相加结果（不考虑进位）则是最终结果
     * */
    private static int add(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = a ^ b;
            b = (tmp & b) << 1;
        }
        return a;
    }

    public static int sum(int...a){
        return Arrays.stream(a).sum();
    }
    public static int add2(int a, int b) {
        return sum(a,b);
    }


}
