package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-19
 * <pre>
 *
 *
 * ## Java去除字符串中的空格
 *
 * 特别注意了
 *
 * 1、strim或者Trip都是只能去除头部和尾部的空字符串。中间的部分是不能够去除的!
 *
 * 2、推荐使用ApacheCommonse的 StringUtils.deleteWhitespace("a b c"); 删除所有空格。
 *
 * 3、如果我自己写，我会采用foreache遍历每一个字符串中的字符然后利用StringBuilder追加 或者使用 Replace进行替换，
 *
 * 4、替换的时候对于多个空格可能匹配有问题，利用正则表达式?
 *
 * </pre>
 */
public class DeleteWhitespace {

    public static void main(String[] args) {
        String s = "a  b d  c";
        s = s.replaceAll(" ","");
        System.out.println(s);

        String s2 = "a  b d  c";
        s2 = deleteWhitespace(s2);
        System.out.println(s2);

    }

    /**StringUtils.deleteWhitespace 的方法*/
    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        } else {
            int sz = str.length();
            char[] chs = new char[sz];
            int count = 0;

            for(int i = 0; i < sz; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    chs[count++] = str.charAt(i);
                }
            }

            if (count == sz) {
                return str;
            } else {
                return new String(chs, 0, count);
            }
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

}
