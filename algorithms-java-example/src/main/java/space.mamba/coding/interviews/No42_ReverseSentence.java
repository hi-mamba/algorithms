package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;

import java.util.Objects;

/**
 * @author mamba
 * <p>
 * 输入一个字符串，翻转单词的次序。比如输入："i am a student"，输出："student a am i"
 */
public class No42_ReverseSentence {

    public static void main(String[] args) {
        String str = "hello world!";
        Assertions.assertEquals(reverseSentence1(str), "world! hello");
        String input = "   ";
        String expected = "   ";
        Assertions.assertEquals(reverseSentence1(input), expected);
        Assertions.assertEquals(reverseSentence1(null), null);


        System.out.println("-----");
        //这个地方可以用String，也可以用char[]来接收函数的返回值
        //String a=new Method1().ReverseSentence(str);
        char[] a= ReverseSentence(str);
        System.out.println(a);


    }

    private static String reverseSentence1(String str) {
        if (Objects.isNull(str)) {
            return null;
        }

        String[] strArr = str.split(" ");
        //为了防止出现全空格的情况
        if (strArr.length == 0) {
            return str;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = strArr.length - 1; i > 0; i--) {
            temp.append(strArr[i]).append(" ");//从尾部添加就可以保证顺序颠倒了
        }
        temp.append(strArr[0]);//写在外面是因为最后一个添加的不用添加空格了。
        return temp.toString();

    }


    //函数Reverse的功能：翻转一段字符串
    public static void Reverse(char[] data, int begin, int end) {
        //当满足以下条件时，结束函数
        if (data == null || data.length < 0 || begin < 0 || end > data.length || begin > end) {
            return;
        }
        //首尾一一交换
        while (begin < end) {
            char temp = data[begin];
            data[begin] = data[end];
            data[end] = temp;

            begin++;
            end--;
        }
    }

    //函数ReverseSentence的功能：调动Reverse函数；并且控制翻转的范围
    public static char[] ReverseSentence(String string) {
        char[] data = string.toCharArray();
        if (data == null || data.length < 0)
            return null;

        //翻转整个句子
        Reverse(data, 0, data.length - 1);
        //可以用一个输出语句来观察此时的data
        System.out.print("翻转整个句子");
        System.out.println(data);

        //翻转句子中的每个单词
        int begin = 0;
        int end = 0;
        while (begin < data.length) {
            if (data[begin] == ' ') {
                begin++;
                end++;
            } else if (end == data.length || data[end] == ' ') {
                Reverse(data, begin, end - 1);
                end++;
                begin = end;
            } else {
                end++;
            }
        }
        //可以返回String类型或是char[]类型，注意：与函数对应的返回值类型是否匹配
        //return new String(data);
        return data;
    }

}
