package space.mamba.coding.interviews;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author mamba
 * @date 2020/6/26 15:23
 * <p>
 * 第一个出现一次的字符
 */
public class No35_FirstFindOnceChar {

    public static void main(String[] args) {
        String str = "abcdefghjklhfeagjlascbdk";
        System.out.println(getFirstFindOnceChar(str.toCharArray()));
        System.out.println("-------");
        System.out.println(firstNotRepeatingChar(str));
    }

    private static char getFirstFindOnceChar(char[] chars) {
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) == 1) {
                char c = entry.getKey();
                return c;
            }
        }
        return 0;
    }

    private static char firstNotRepeatingChar(String str) {
        int len = str.length();
        if (len <= 0) {
            return 0;
        }

        char[] s = str.toCharArray();
        char[] charArray = new char[256];

        for (int i = 0; i < len; i++) {
            // 保存出现的字符
            charArray[s[i]]++;
        }

        for (int i = 0; i < len; i++) {
            if (charArray[s[i]] == 1) {
                return s[i];
            }
        }
        return 0;
    }
}
