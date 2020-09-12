package space.mamba.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pankui
 * @date 2018/11/17
 * <pre>
 *  剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *  例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </pre>
 */
public class ReplaceSpace {


    public static void main(String[] args) {

        String str = "WeAre  Happy. ";

        System.out.println(replace1(str));

        //第二种实现方式
        String[] arr = str.split(" ");

        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char b = str.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                s2.append("%20");
            } else {
                s2.append(b);
            }
        }
        System.out.println(s2.toString());



        // 使用正则，其实String 的replaceAll 也是正则
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {

            String s = matcher.replaceAll("%20");

            System.out.println("s="+s);
            stringBuilder.append(s);
        }

        System.out.println("结果="+stringBuilder.toString());
    }

    public static  String replace1(String str) {
        return str.replaceAll("\\s","%20");
    }
}
