package space.mamba.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import space.mamba.leetcode.algorithms.No387_First_Unique_Character_In_a_String;

/**
 * @author mamba
 * @date 2020/9/12 09:58
 */
public class No387_First_Unique_Character_In_a_StringTest {

    @Test
    public void testFirstUniqChar() {

        No387_First_Unique_Character_In_a_String obj = new No387_First_Unique_Character_In_a_String();
        Assertions.assertEquals(0, obj.firstUniqChar("leetcode"));
        Assertions.assertEquals(2, obj.firstUniqChar("loveleetcode"));
        String str = "asdffdaq";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 如果这个字符第一次出现的位置和最后出现的位置相等，就说明字符串中它只出现了一次
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                System.out.println(ch);
                break;
            }
        }

        System.out.println(obj.firstUniqChar(str));
    }
}
