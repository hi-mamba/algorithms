package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;

/**
 * @author mamba
 * @ 2020/7/29
 *
 * 在空间复杂度是O(1)，时间复杂度就让他去吧~（貌似是O(2^n)
 *
 */
public class No53_Pattern {

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "a.a";
        Assertions.assertTrue(match(str1.toCharArray(), str2.toCharArray()));
    }
    public boolean isMatch(String s, String p) {
        // 用来保存函数运行的结果，1代表true，-1代表false，0代表未执行过
        int[][] arr = new int[s.length()][p.length()];
        return isMatch(s, 0, p, 0, arr);
    }
    private boolean isMatch(String s, int si, String p, int pi, int[][] arr) {
        boolean r;
        if (si == s.length()) {
            if (pi == p.length()) r = true;
            else if (pi == p.length() - 1) r = false;
            else if (p.charAt(pi + 1) == '*') r = isMatch(s, si, p, pi + 2, arr);
            else r = false;
        } else if (pi == p.length()) {
            r = false;
        } else {
            int result = arr[si][pi];
            if (result == 1) return true;
            if (result == -1) return false;

            char cs = s.charAt(si);
            char cp = p.charAt(pi);

            // 这是一个通配符
            if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
                // 可以匹配，是否配？
                if (cp == '.' || cs == cp) {
                    r = isMatch(s, si + 1, p, pi, arr) || // 配
                            isMatch(s, si, p, pi + 2, arr); // 不配
                } else { // 不能匹配
                    r = isMatch(s, si, p, pi + 2, arr);
                }
            } else { // 这是一个普通字符
                if (cp == '.' || cs == cp) r = isMatch(s, si + 1, p, pi + 1, arr);
                else r = false;
            }
            arr[si][pi] = r ? 1 : -1;
        }

        return r;
    }


    public static boolean match(char[] str, char[] pattern) {
        return matchTwo(str,0,str.length,pattern,0,pattern.length);
    }
    private static boolean matchTwo(char[] str, int i, int length1, char[] pattern,
                             int j, int length2) {
        if(i==length1&&j==length2) {
            return true;
        }
        if(i==length1&&j!=length2) {
            while(j!=length2){
                if(pattern[j]!='*'&&(j+1>=length2||pattern[j+1]!='*')){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(i!=length1&&j==length2) {
            return false;
        }
        if(j+1==length2){
            if(str[i]==pattern[j]||pattern[j]=='.')
                return matchTwo(str, i+1, length1, pattern, j+1, length2);
            else {
                return false;
            }
        }
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]!='*')
            return matchTwo(str, i+1, length1, pattern, j+1, length2);
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]=='*')
            return matchTwo(str, i, length1, pattern, j+2, length2)||matchTwo(str, i+1, length1, pattern, j, length2);
        if(pattern[j+1]=='*')
            return matchTwo(str, i, length1, pattern, j+2, length2);
        return false;
    }
}
