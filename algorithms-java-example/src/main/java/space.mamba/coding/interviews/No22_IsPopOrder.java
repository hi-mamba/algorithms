package space.mamba.coding.interviews;


import java.util.Stack;

/**
 * @author pankui
 * @date 2019-04-09
 * <pre>
 *  判断一个栈是否是另一个栈的弹出序列
 * </pre>
 */
public class No22_IsPopOrder {


    /**
     *  对于一个给定的压入序列，由于弹出的时机不同，会出现多种弹出序列。如果是选择题，
     *  依照后进先出的原则，复现一下栈的压入弹出过程就很容易判断了。写成程序同样如此，主要步骤如下：
     *
     * 步骤1：栈压入序列第一个元素，弹出序列指针指弹出序列的第一个；
     * 步骤2：判断栈顶元素是否等于弹出序列的第一个元素：
     *     步骤2.1：如果不是，压入另一个元素，进行结束判断，未结束则继续执行步骤2；
     *     步骤2.2：如果是，栈弹出一个元素，弹出序列指针向后移动一位，进行结束判断，未结束则继续执行步骤2；
     *
     * 结束条件：如果弹出序列指针还没到结尾但已经无元素可压入，则被测序列不是弹出序列。
     *          如果弹出序列指针以判断完最后一个元素，则被测序列是弹出序列。
    *
     *
     *   判断 popSeq 是否是 pushSeq的弹出栈
    * */
    public static boolean isPopOrder(int[] pushSeq,int[] popSeq){

        if (pushSeq == null || popSeq == null || pushSeq.length != popSeq.length) {
            return false;
        }
        //保存入栈数据
        Stack<Integer> stack = new Stack<>();

        int pushSeqIndex=0;
        int popSeqIndex=0;

        while (popSeqIndex < popSeq.length) {
            // popSeq 弹出栈
            //都返回栈顶的值, peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除
            if (stack.isEmpty() || stack.peek() != popSeq[popSeqIndex]) {

                if (pushSeqIndex < pushSeq.length) {
                    stack.push(pushSeq[pushSeqIndex++]);
                } else {
                    return false;
                }
            } else {
                stack.pop();
                popSeqIndex++;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        System.out.println(isPopOrder(push,pop1));
        System.out.println(isPopOrder(push,pop2));
    }

}
