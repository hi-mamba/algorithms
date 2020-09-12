package space.mamba.string;

import java.util.HashSet;

/**
 * @author pankui
 * @date 2018/11/18
 * <pre>
 *   https://blog.csdn.net/baidu_32045201/article/details/79743753
 *   https://github.com/Snailclimb/JavaGuide/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/%E6%90%9E%E5%AE%9ABAT%E9%9D%A2%E8%AF%95%E2%80%94%E2%80%94%E5%87%A0%E9%81%93%E5%B8%B8%E8%A7%81%E7%9A%84%E5%AD%90%E7%AC%A6%E4%B8%B2%E7%AE%97%E6%B3%95%E9%A2%98.md
 * </pre>
 */
public class RevoreDemo {

    public static void main(String[] args) {

        String s = "asssdff";

        Solution solution = new Solution();
        int result = solution.longestPalindrome(s);
        System.out.println(result);



        Solution2 solution2 = new Solution2();
        int result2 = solution2.longestPalindrome(s);
        System.out.println(result2);
    }


}

class Solution {
    public  int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
                System.out.println("保存:"+chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                System.out.println("移除:"+chars[i]+",hashSet="+hashset);
                count++;
            }
        }

        System.out.println("hashSet"+hashset);
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }
}

/**
 *
 * 排名第一的范例代码写的非常聪明，直接利用一个 boolean[] 来统计字符出现的奇偶次数
 *
  */
class Solution2 {

    public int longestPalindrome(String s) {
        //初始化都是false
        boolean[] map = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            // flip on each occurrence, false when seen n*2 times
            // 由于第一次出现就负责true，当第二次出现的时候就进入if 里面
            map[c] = !map[c];
            if (!map[c]) {
                len += 2;
            }
        }
        // if more than len, atleast one single is present
        // 这里就是奇数的时候
        if (len < s.length()) {
            len++;
        }
        return len;
    }
}

