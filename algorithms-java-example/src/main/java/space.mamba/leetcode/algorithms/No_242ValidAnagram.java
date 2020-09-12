package space.mamba.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author byte mamba
 * @date 2019/11/28
 * <pre>
 *      https://leetcode.com/problems/valid-anagram/
 * </pre>
 */
public class No_242ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        No_242ValidAnagram obj = new No_242ValidAnagram();
        boolean result = obj.isAnagram(s, t);
        System.out.println(result);

        String s2 = "rat", t2 = "car";
        result = obj.isAnagram(s2, t2);
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return false;
        }

        String[] str1Array = s.split("");
        String[] str2Array = t.split("");
        Map<String, Integer> mapStr1 = new HashMap<>(str1Array.length);
        Map<String, Integer> mapStr2 = new HashMap<>(str2Array.length);

        for (String str : str1Array) {
            if (mapStr1.containsKey(str)) {
                mapStr1.put(str, mapStr1.get(str) + 1);
            } else {
                mapStr1.put(str, 1);
            }
        }

        for (String str : str2Array) {
            if (mapStr2.containsKey(str)) {
                mapStr2.put(str, mapStr2.get(str) + 1);
            } else {
                mapStr2.put(str, 1);
            }
        }

        if (mapStr1.equals(mapStr2)) {
            return true;
        }
        return false;
    }

    public boolean isAnagram2(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }
}
