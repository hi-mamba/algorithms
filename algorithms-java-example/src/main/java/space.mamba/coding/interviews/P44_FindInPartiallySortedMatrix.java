package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-15
 * <pre>
 *
 * 题目要求：
 *
 *  一个二维数组中，每一行从左到右递增，每一列从上到下递增。输入一个整数，判断数组中是否含有该整数
 *
 *
 *  答案：
 *
 * ## 分析
 *
 * 由题意我们可以知道，该二维数组最左上角的元素最小，最右下角的元素最大，
 * 所以我们可以先判断目标值与这两个元素的大小。这里有两种情况我们可以分别考虑：
 *
 * 1、
 * 目标超过这两个元素的范围
 * 如果目标小于数组最小值或者大于最大值，那么我们就可以判断出它不在二维数组里面。
 *
 * 目标在两个元素之间
 * 当目标元素在两个值之间的时候，我们可以对二维数组进行遍历，判断每一层的元素：如果目标元素比该层第一个小或者比最后一个元素大，
 * 则说明不在该层，直接跳过。如果目标元素在该层范围里面，则遍历该层，如果没有元素与之匹配则说明该二维数组不包含目标值。
 *
 *
 *  2、也可以直接用两个for循环判断每一个元素与目标的值
 *
 * </pre>
 */
public class P44_FindInPartiallySortedMatrix {


    /**
     * 题目描述：二维数组中的查找
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的顺序排序。
     * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否包含该整数
     */
    public static boolean find(int arr[][], int keyNumber) {

        //从二维数组的右上角开始选取与keyNumber比较的整数
        //column的变化：arr[0].length-1-->0;
        //row的变化：0-->arr.length;
        int column = arr[0].length - 1;
        int row = 0;
        while (column >= 0 && row < arr.length) {
            if (arr[row][column] == keyNumber) {
                return true;
            } else if (arr[row][column] > keyNumber) {
                column--;
            } else {
                row++;
            }
        }
        return false;

    }

    public static boolean findValue(int arr[][], int keyNumber) {

        for (int a = 0; a < arr.length; a++) {
            for (int j = 0; j < arr[a].length; j++) {
                if (arr[a][j] == keyNumber) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 测试find函数
     */
    public static void main(String[] args) {
        /*
         * 1  2  8  9
         * 2  4  9  12
         * 4  7  10 13
         * 6  8  11 15
         */
        int array[][] = new int[4][4];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 8;
        array[0][3] = 9;
        array[1][0] = 2;
        array[1][1] = 4;
        array[1][2] = 9;
        array[1][3] = 12;
        array[2][0] = 4;
        array[2][1] = 7;
        array[2][2] = 10;
        array[2][3] = 13;
        array[3][0] = 6;
        array[3][1] = 8;
        array[3][2] = 11;
        array[3][3] = 15;
        System.out.println(find(array, 7));
        System.out.println(find(array, 5));

        System.out.println("###########");

        System.out.println(findValue(array, 7));
        System.out.println(findValue(array, 5));

    }

}
