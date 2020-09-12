package space.mamba.basis;

/**
 * @author pankui
 * @date 24/04/2018
 * <pre>
 * 一、线性表
 *
 *   线性表是最常用且最简单的一种数据结构，它是n个数据元素的有限序列。
 *
 *   实现线性表的方式一般有两种，一种是使用数组存储线性表的元素，即用一组连续的存储单元依次存储线性表的数据元素。
 *
 *   另一种是使用链表存储线性表的元素，即用一组任意的存储单元存储线性表的数据元素（存储单元可以是连续的，也可以是不连续的）。
 *
 *   https://www.jianshu.com/p/230e6fde9c75
 *
 * </pre>
 */
public class LinearTableDemo {


    public static void main(String[] args) {
        LinearTableDemo tableDemo = new LinearTableDemo();
        int[] resultArray = tableDemo.linearArray();
        tableDemo.printArray(resultArray);

        int[] oldArray = {9,8,7,6,5,4,3,2,1,0};
        int[] addResult = tableDemo.add(oldArray,2,11);
        tableDemo.printArray(addResult);

    }

    private void printArray(int[] resultArray) {

        System.out.print("array:");
        for (int n : resultArray) {
            System.out.print(" " + n);
        }
        System.out.println();
        System.out.println("#############################");
    }
     //数组实现

    // 数组是一种大小固定的数据结构，对线性表的所有操作都可以通过数组来实现。
    // 虽然数组一旦创建之后，它的大小就无法改变了，但是当数组不能再存储线性表中的新元素时，
    // 我们可以创建一个新的大的数组来替换当前数组。这样就可以使用数组实现动态的数据结构。

    /**代码1 创建一个更大的数组来替换当前数组
     *
     * @return int
     */
    private int[] linearArray(){

        int[] oldArray = {9,8,7,6,5,4,3,2,1,0};

        int[] newArray = new int[20];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

     /** 也可以使用System.arraycopy方法来实现数组间的复制
      *  System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
      */
        oldArray = newArray;

        return oldArray;
    }

    /**
     * 代码2 在数组位置index上添加元素e
     *
     * index 要在 数组里面
     *
     * */
    private int[] add(int[] array,int index,int e){

        if (index < 0) {
            System.out.println("不合法参数");
            return null;
        }

        // 扩容
        if (index > array.length) {

            int[] newArray = new int[array.length + 1];

            //时间复杂度 O(n)
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[j] = array[i];
                } else {
                    newArray[j] = e;
                    newArray[++j] = array[i];
                }
                j++;
            }

            return newArray;
        }


        // 最后一个数组淘汰
        for (int k = array.length - 2; k >= index; k--) {

            array[k + 1] = array[k];

        }

        array[index] = e;

        return array;
    }
}
