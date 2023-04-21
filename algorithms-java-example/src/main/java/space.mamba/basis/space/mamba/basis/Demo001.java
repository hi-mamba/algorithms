package space.mamba.basis;

/**
 * @author pankui
 * @date 01/05/2018
 * <pre>
 *     https://www.jianshu.com/p/7988e646a37e
 *
 *     http://gityuan.com/2015/10/24/jvm-bytecode-grammar/
 *
 *     https://www.jianshu.com/p/c11f98269b00
 *
 * </pre>
 */
public class Demo001 {

    public static void main(String[] args) {

        int j = 0;
        int t = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
            t++;
        }
        System.out.println(j);
        System.out.println(t);



        int i = 0;
        i = i++;

        int k = i;
        System.out.println(i+" "+k);

    }


}
