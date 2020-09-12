package space.mamba.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author pankui
 * @date 2019/11/21
 * <pre>
 *      https://leetcode.com/problems/valid-parentheses/
 *
 *      Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *      determine if the input string is valid.
 *
 *      An input string is valid if:
 *
 *      Open brackets must be closed by the same type of brackets.
 *      Open brackets must be closed in the correct order.
 *      Note that an empty string is also considered valid.
 *
 *      Example 1:
 *
 *      Input: "()"
 *      Output: true
 *      Example 2:
 *
 *      Input: "()[]{}"
 *      Output: true
 *      Example 3:
 *
 *      Input: "(]"
 *      Output: false
 *      Example 4:
 *
 *      Input: "([)]"
 *      Output: false
 *      Example 5:
 *
 *      Input: "{[]}"
 *      Output: true
 * </pre>
 *
 *
 *  Map<String, String> map = new HashMap<>();
 *         map.put("}", "{");
 *         map.put("]", "[");
 *         map.put(")", "(");
 */
public class No20Valid_Parentheses_Stack {

    public static void main(String[] args) {
        No20Valid_Parentheses_Stack param = new No20Valid_Parentheses_Stack();
        System.out.println(param.isValid("()"));
        System.out.println(param.isValid("()[]{}"));
        System.out.println(param.isValid("(]"));
        System.out.println(param.isValid("([)]"));
        System.out.println(param.isValid(""));
        System.out.println(param.isValid("]"));
    }

    public boolean isValid(String s) {

        if (s == null || "".equals(s.trim())) {
            return true;
        }

        // leetcode 目前不支持这么高的JDK
        Map<String, String> map = Map.of("}", "{", "]", "[", ")", "(");
        Stack<String> stack = new Stack<>();
        String[] parentheseArray = s.split("");
        for (String param : parentheseArray) {
            // 不是右括号，放入栈里
            if (!map.containsKey(param)) {
                stack.push(param);
                // 右括号且栈为空
            } else if (stack.isEmpty() && map.containsKey(param)) {
                return false;
                // 否则是右括号且栈不为空，和栈顶元素比配是否一对，
            } else if (!stack.empty() && !map.get(param).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
