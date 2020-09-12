package space.mamba.coding.interviews;

/**
 * @author mamba
 * @ 2020/7/24
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class No46_SumSolution {


    public static void main(String[] args) {
        System.out.println(sumNums(3));
        System.out.println(sumNums(5));
        System.out.println(sumNums(10));
    }

    private static int sumNums(int n) {

        if (n == 1) {
            return 1;
        }
        n += sumNums(n - 1);
        return n;
    }
}
