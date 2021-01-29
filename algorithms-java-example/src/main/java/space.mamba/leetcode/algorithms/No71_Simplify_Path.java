package space.mamba.leetcode.algorithms;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mamba
 * @date 2021/1/29 07:59
 * https://leetcode.com/problems/simplify-path/
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：”/home/”
 * 输出：”/home”
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * <p>
 * 输入：”/../”
 * 输出：”/”
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * <p>
 * 示例 3：
 * <p>
 * 输入：”/home//foo/”
 * 输出：”/home/foo”
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * <p>
 * 输入：”/a/./b/../../c/”
 * 输出：”/c”
 * <p>
 * 示例 5：
 * <p>
 * 输入：”/a/../../b/../c//.//”
 * 输出：”/c”
 * <p>
 * 示例 6：
 * <p>
 * 输入：”/a//b////c/d//././/..”
 * 输出：”/a/b/c”
 * <p>
 * 堆栈就适合解决这类问题。我们首先把字符串用”/”分割成字符串数组。””和”.”都没有啥意义，我们就什么都不做。有内容就压栈，遇到”..”就弹栈，如果最后栈为空，就输出”/”。如果不为空就把栈里面的内容依次输出即可
 * <p>
 * https://codechina.org/2019/07/leetcode-71-simplify-path-stack-java/
 */
public class No71_Simplify_Path {

    public static void main(String[] args) {
        No71_Simplify_Path obj = new No71_Simplify_Path();
        Assertions.assertEquals("/home", obj.simplifyPath("/home/"));
        Assertions.assertEquals("/", obj.simplifyPath("/../"));
        Assertions.assertEquals("/home/foo", obj.simplifyPath("/home//foo/"));
        Assertions.assertEquals("/c", obj.simplifyPath("/a/./b/../../c/"));
        Assertions.assertEquals("/a/b/c", obj.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        for (String s : pathArray) {
            if ("".equals(s) || ".".equals(s)) {
                //nothing
            } else if ("..".equals(s)) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        if (stack.size() == 0) {
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(pathStack -> {
            stringBuilder.append("/").append(pathStack);
        });
        return stringBuilder.toString();
    }
}
