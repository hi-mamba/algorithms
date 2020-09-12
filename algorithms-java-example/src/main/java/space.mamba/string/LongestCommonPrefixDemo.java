package space.mamba.string;

/**
 * @author pankui
 * @date 2018/11/18
 * <pre>
 *
 *  LeetCode—longest-common-prefix（最长公共前缀）—java
 *
 *  https://leetcode.com/problems/longest-common-prefix/
 *
 *  最长子串
 *  　　编写一个函数来查找字符串数组中最长的公共前缀字符串。
 *
 * 理解题目：
 *
 * 　　如数组 ["a", "b"]   最长的公共前缀字符串是 “”；
 *
 * 　　如数组 ["aa", "aa"]   最长的公共前缀字符串是 “aa”；
 *
 * 　　如数组 ["abc", "abcd"]   最长的公共前缀字符串是 “abc”。。。
 *
 * 思路解析：
 *
 * 将字符串数组的第一个进行比较，不可能有公共字符串比它还长了
 *
 * 然后两层循环，第一层是第一个字符串的长度，0到strs.length()-1
 *
 * 第二层是每个字符串的第i个位置，先确定有这个位置，然后判断是否一致。如果没有这个位置就返回目前遍历过的字符长度。
 *
 * </pre>
 */
public class LongestCommonPrefixDemo {


    public static void main(String[] args) {
        String[] str = {"ab","ab","ab"};
        String result = longestCommonPrefix(str);
        System.out.println(result);

    }

    public static String longestCommonPrefix(String[] array) {

        if (array == null || array.length < 1) {
            return "";
        }

        if (array.length == 1) {
            return array[0];
        }

        String arr1 = array[0];
        for (int i = 0; i < arr1.length(); i++) {
            // 获得第一行i列的字符
            char c = arr1.charAt(i);
            // 依次比较剩余行相同列的字符
            for (int j = 1; j < array.length; j++) {

                // 若j行i列的字符与第一行i列的字符不同，代表最长公共前缀判定结束
                // 若第一行新i列已经超出了剩余行的最大列出，也代表最长公共前缀判定结束

                // 如果已经到最小的长度，那么直接截取字符串返回，
                // 或者 如果已经有不相等了字符了，那么也直接截取字符串返回，经典啊！！我靠
                // 注意，最小的判断在前面！！
                if ((array[j].length() == i) || (array[j].charAt(i) != c)) {
                    return array[0].substring(0, i);
                }
            }
        }
        // 当数组里面的字符串都一样的时候，直接返回，就好执行这里
        //  String[] str = {"ab","ab","ab"};
        return array[0];
    }
}
