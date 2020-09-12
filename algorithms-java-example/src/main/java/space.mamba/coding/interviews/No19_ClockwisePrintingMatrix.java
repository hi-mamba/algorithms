package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2018-12-23
 * <pre>
 *    //顺时针打印一个矩阵 或者称为蛇形打印
 * </pre>
 */
public class No19_ClockwisePrintingMatrix {

    //顺时针打印一个矩阵

    public static void main(String[] args) {


        int[][] num = new int[100][100];
        int n = 4;
        int count = 1;

        // 初始化数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = count++;
            }
        }
        output(num, 0, n - 1);
    }

    /**
     * 算法很简单，就是正方形
     *
     *  1   2   3   4
     *  5   6   7   8
     *  9   10  11  12
     *  13  14  15  16
     *
     *  下面的for 需要分别计算四条边就OK了。
     *  第一个for 循环是计算 1 - 4
     *  第二个for 循环是计算 8 - 16
     *  第三个for 循环是计算 15 - 13
     *  第四个for 循环是计算 9 - 5
     *
     *  然后在做递归
     * */
    public static void output(int[][] num, int start, int end) {
        if (start > end || end <= 0) {
            return;
        }

        // 从左到右
        for (int i = start; i <= end; i++) {
            // 输出序号  start = 0, i 是自增
            System.out.println(num[start][i]);
        }

        // 从上到下
        for (int i = start + 1; i <= end; i++) {
            System.out.println(num[i][end]);
        }

        // 从右到左
        for (int i = end - 1; i >= start; i--) {

            System.out.println("="+num[end][i]);
        }

        //从下到上
        for (int i = end - 1; i > start; i--) {
            System.out.println(num[i][start]);
        }

        //递归
        output(num, start + 1, end - 1);
    }
}
