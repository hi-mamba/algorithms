package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-26
 * <pre>
 *
 *    https://blog.csdn.net/dong_cc/article/details/64444075
 *
 *
 *   返回两个int型数中的较大者，不准用关系运算符，不准用if, while, for等语句
 *
 *   There are two int variables: x and y, don’t use “if”, “? :”, “switch”or other judgementstatements,
 *   find out the biggest one of the two numbers.
 *
 *  有两个int型的整数：x，y；不使用"if","? :","switch"等判断语句！找出a、b中最大的数！
 * </pre>
 */
public class MaxNumExample01 {

    public static void main(String[] args) {
        int result = maxNum1(2,3);
        System.out.println(result);

        int result2 = fMax2(4,3);
        System.out.println(result2);

        int result3 = fMax3(2,3);
        System.out.println(result3);

        int result4 = fMax3(4,3);
        System.out.println(result4);
    }

    /**
        方法1：取平均值法
        大的为 ((a+b)+abs(a-b)) / 2
        小的为 (a+b - abs(a-b)) / 2
     */
    static int maxNum1(int a, int b) {
         return  ((a+b)+Math.abs(a-b)) / 2;
    }

    /**
        方法2：不使用abs()
        a<b时，a/b=0，所以前面为b*(b/a)，后面为b/a，那么结果就是b
        a=b时，a/b=1，所以前面为a+b=2a，后面为2，那么结果就是a
        a>b时，b/a=0，所以前面为a*(a/b)，后面为a/b，那么结果就是a
        */
    static int fMax2(int a, int b) {
        int larger = (a*(a/b) + b*(b/a))/(a/b + b/a);
        long smaller = (b*(a/b) + a*(b/a))/(a/b + b/a);
        System.out.println("smaller:"+smaller);
        return larger;
    }

    /**
        方法3：如果取 a/b 余数不为0，则说明a>b
        这是个好方法，不过题目说了，不能用“? :”
     */
    static int fMax3(int a, int b) {
        return (a / b) == 0 ? b : a;
    }

    /**
        方法4：移位法
        当b<0的时候以补码存,故最高位是1
        所以右移31位b>>31其实就是最高位的值
        b>=0时候最高位为0
        所以b跟1与时候为b,a=a-(a-b)=b
        b跟1作与运算时候为0,相当于a=a-0=a
     */
    int fMax4(int a, int b) {
        b = a - b;
        a -= b & (b>>31);
        return a;
    }

    /**
     * 我想这个应该是最牛B的一个
     * */

}
