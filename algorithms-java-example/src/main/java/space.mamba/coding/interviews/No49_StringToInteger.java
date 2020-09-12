package space.mamba.coding.interviews;


/**
 * @author mamba
 * @ 2020/7/26
 * <p>
 * 不用加减乘除做加法
 * @see No49_StringToIntegerTest
 */
public class No49_StringToInteger {


    public int strToInteger(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        //第一个字符可以是正号或者是负号
        int first = 1;//做符号位,1为+，2为-
        int index = 0;//防止出现123这种开始就不是符号位的数字
        char[] charArray = str.toCharArray();
        if (charArray.length == 1) {
            return 0;
        }
        if (charArray[0] == '-') {
            //如果是负号且字符串长度不小于1，将符号位置-1
            first = 2;
            index++;
        }

        if (charArray[0] == '+') {
            //如果是符号为正号且字符串长度不小于1，将符号位置+1
            index++;
        }

        int result = 0;
        for (int i = index; i < charArray.length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                //如果后面的不在0-9的话，说明不是数字
                return 0;
            }
            result = result * 10 + (int) (charArray[i] - '0');//-‘0’转换为数字
            //TODO 有越界的问题
        }

        if (first == 2) {
            return result * (-1);
        }
        return result;
    }
}