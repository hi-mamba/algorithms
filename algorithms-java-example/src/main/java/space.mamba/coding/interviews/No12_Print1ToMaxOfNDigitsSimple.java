package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-04-01
 * <pre>
 *  题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 * </pre>
 */
public class No12_Print1ToMaxOfNDigitsSimple {


    public static void main(String[] args) {
        new No12_Print1ToMaxOfNDigitsSimple().print1ToMaxOfNDigits(2);
        // new No12_Print1ToMaxOfNDigitsSimple().print1ToMaxOfNDigitsSimple2(5);
    }

    /*
     * 初看之下好像没有问题，但是其并没有考虑大数问题，有可能即使用整型(int)或长整型(long)都会溢出。
     * */
    void print1ToMaxOfNDigitsSimple2(int n) {
        int number = 1;
        int i = 0;

        while (i < n) {
            number = number * 10;
            i++;
        }

        for (i = 1; i < number; i++) {
            System.out.println(i);
        }
    }


    /**
     * 使用数组模拟数字，可以解决大数溢出的问题
     *
     * @param n 最大的位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n < 0) {
            return;
        }
        char[] number = new char[n];

        //给number数组赋初值0
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }


        while (!Increment(number)) {
            PrintNumber(number);
        }


    }

    /**
     * 实现数字数组加1的功能
     *
     * @param number 数字数组
     * @return 是否溢出，即是否已经打印完所有1到n位最大数，是返回true
     */
    public static Boolean Increment(char[] number) {
        Boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) //数字的最低位
            {
                nSum++;
            }

            if (10 <= nSum) //产生进位
            {
                if (0 == i)  //产生进位的是最高位，证明已经打印完所有数了
                {
                    isOverflow = true;
                } else   //产生进位的不是最高位
                {
                    nSum -= 10;
                    nTakeOver = 1;  //高一位要加1
                    number[i] = (char) ('0' + nSum);
                }

            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印出数组，去掉数组前面的0
     *
     * @param number 要打印的数组
     */
    public static void PrintNumber(char[] number) {
        Boolean isBeginning0 = true;
        int nLength = number.length;

        for (int i = 0; i < nLength; i++) {
            //用于判断是否是0开头
            if (isBeginning0 && '0' != number[i])
            {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println("");
    }
}
