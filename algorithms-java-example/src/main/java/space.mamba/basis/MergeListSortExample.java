package space.mamba.basis;


/**
 * @author pankui
 * @date 2019-03-27
 * <pre>
 *      对两个数组进行merge 排序：
 * </pre>
 */
public class MergeListSortExample {

    public static void main(String[] args) {
        MergeListSortExample solution = new MergeListSortExample();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int[]arr = solution.mergeList(num1, num2);

        System.out.println("\n====华丽分割线\n");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
    }

    /**这种不是排序好的。不行 */
    public int[] mergeList(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k] = b[j];
                j++;
                k++;
            } else {
                c[k] = a[i];
                i++;
                k++;
            }
        }

        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        return c;
    }
}
