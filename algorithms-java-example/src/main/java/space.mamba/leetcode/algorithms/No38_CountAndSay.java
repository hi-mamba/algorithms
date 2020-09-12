package space.mamba.leetcode.algorithms;

/**
 * @author pankui
 * @date 2019-01-26
 * <pre>
 *
 *  Count and Say 
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 * ```
 *
 *
 * 思路：题意实在太难理解了，尤其是英文又不好，只能参看下别人的资料，理解下规则。
 *
 * 终于理解，题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；n=3时，
 * 由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。
 * 依次类推，写个countAndSay(n)函数返回字符串。
 *
 * </pre>
 */
public class No38_CountAndSay {

    public static void main(String[] args) {
        No38_CountAndSay no38_countAndSay = new No38_CountAndSay();
        for (int i = 0; i <= 6; i++) {
            System.out.println("参数:"+i+"="+no38_countAndSay.countAndSay(i));
        }

    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String result = "1";
        int i = 1;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }
}
