package space.mamba.niubi;

import org.junit.jupiter.api.Assertions;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 *  数据结构中的栈有什么用？
 *
 * https://www.youtube.com/watch?v=r90BJ3G-BgU&list=PLkl2qqmYigA60rBjPyms_7kjMvVy3gSAK&index=1
 * */
public class StackArithmeticExample {

    public static void main(String[] args) throws ScriptException {
        // 计算视频里的  1 + ( 6 + 2 ) * 3 = 25

        String str = "1+(6+2)*3";

        //postfix expression 后缀表达式  1 6 2 + 3 * +


        //定义：规则
        // 1.所有的数字直接输出，
        // 2.运算符优先级高于栈内的 要入栈（或空栈）
        // 3.所有左括号都要入栈
        // 4.若栈内包含左括号，运算符都入栈
        // 5.若是右括号，栈不断出栈，直到碰到左括号

        //定义左括号
        String leftChar = "{[(";
        //定义右括号
        String rightChar = "}])";

        //入栈(转换的时候判断是否是数字)
        Stack<String> tempStack = new Stack<>();


        boolean includeLeftChar = false;
        String[] arr = str.split("");
        //后缀表达式
        List<String> postfixExpression = new ArrayList<>();
        for (String s : arr) {
            //3.所有左括号都要入栈
            if (leftChar.contains(s)) {
                tempStack.add(s);
                includeLeftChar = true;
                continue;
            }
            //4.若栈内包含左括号，运算符都入栈
            if (includeLeftChar) {
                if ("+-*/".contains(s)) {
                    tempStack.add(s);
                    continue;
                }
            }
            //1.所有的数组直接输出
            if (s.matches("-?\\d+")) {
                postfixExpression.add(s);
                continue;
            }

            //5.若是右括号，栈不断出栈，直到碰到左括号
            if (rightChar.contains(s)) {
                while (!tempStack.isEmpty()) {
                    //直到碰到左括号
                    if (leftChar.contains(tempStack.peek())) {
                        tempStack.pop();
                        break;
                    } else {
                        postfixExpression.add(tempStack.pop());
                    }
                }
                continue;
            }

            //2.运算符优先级高于栈内的要入栈（或空栈）
            if (tempStack.isEmpty()) {
                tempStack.add(s);
                continue;
            }
            //2.运算符优先级高于栈内的 要入栈（或空栈）
            if ("+-".contains(tempStack.peek())) {
                postfixExpression.add(s);
            } else {
                tempStack.add(s);
            }
        }

        while (!tempStack.isEmpty()) {
            postfixExpression.add(tempStack.pop());
        }
        int result = 0;
        //凡是数字就压栈，运算符就出栈两次
        Stack<String> postfixExpressionStack = new Stack<>();

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        for (String x : postfixExpression) {
            System.out.print(x);
            //
            if (x.matches("-?\\d+")) {
                postfixExpressionStack.add(x);
            }else {
                //运算符就出栈两次
                String eval = postfixExpressionStack.pop() + x + postfixExpressionStack.pop();
                Object obj = scriptEngine.eval(eval);
                postfixExpressionStack.add(String.valueOf(obj));
            }
        }


        System.out.println();
        Assertions.assertEquals(25, Integer.valueOf(postfixExpressionStack.peek()));
    }
}
