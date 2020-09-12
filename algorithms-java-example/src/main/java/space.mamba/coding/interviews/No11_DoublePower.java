package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-02
 * <pre>
 *  实现函数double Power(double base,int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * </pre>
 */
public class No11_DoublePower {


    public static void main(String[] args) throws IllegalAccessException {

        System.out.println(doublePower(2, 2));
        System.out.println(doublePower(2, 0));
        System.out.println(doublePower(2, -2));
        System.out.println(doublePower(2, 1));

        System.out.println("########## ");
        System.out.println(powerWithExponent2(2, 5));
       // System.out.println(powerWithExponent2(2, 0));
        // System.out.println(powerWithExponent2(2, -2));
        //System.out.println(powerWithExponent2(2, 1));

    }

    static double doublePower(double base, int exponent) throws IllegalAccessException {

        if (base == 0.0 && exponent < 0) {
            throw new IllegalAccessException("0的负数次幂无意义");
        }

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        if (base == 0) {
            if (exponent < 0) {
                //0的负数次方都是 无穷大
                return Double.POSITIVE_INFINITY;
            }
            //0的正数次方都是0
            return 0;
        }

        boolean negativeNumberFlag = false;
        if (exponent < 0) {
            negativeNumberFlag = true;
            exponent = - exponent;
        }
        double result = base;
        while (exponent != 1) {
            result = result * base;
            exponent--;
        }

        if (negativeNumberFlag) {
            return 1.0 / result;
        }
        return result;
    }

    //递归
    static double powerWithExponent2(double base, int exponent) {

        boolean flag = false;
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        System.out.println("exponent="+exponent);
        if (exponent < 0) {
            exponent = - exponent;
            flag = true;
        }

        double result = powerWithExponent2(base, exponent >> 1);
        System.out.println("## result="+result+",base="+base+"，exponent="+exponent);
        result *= result;

        //等于奇数的话需要再乘一次
        if ((exponent & 0x1) == 1) {
            result *= base;
            System.out.println("## result="+result+",base="+base);
        }

        if (flag) {
            return  1.0 / result;
        }
        return result;
    }
}
