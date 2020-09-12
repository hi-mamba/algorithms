package space.mamba.leetcode.algorithms;


/**
 * @author pankui
 * @date 2019-03-08
 * <pre>
 *
 * </pre>
 */
public class No387_First_Unique_Character_In_a_String {

    /**
    * 很简单的解法，因为只包含字母（26），所以可以用int数组作为简单的哈希表。
    * */
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (charCount[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
