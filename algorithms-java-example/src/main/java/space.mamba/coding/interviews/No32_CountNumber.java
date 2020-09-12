package space.mamba.coding.interviews;


import org.junit.jupiter.api.Assertions;

/**
 * @author mamba
 * @date 2020/6/25 16:10
 * <p>
 * 从1到整数n中1出现的次数
 * <p>
 * https://blog.csdn.net/yi_Afly/article/details/52012593
 */
public class No32_CountNumber {


    public static void main(String[] args) {

      //  System.out.println(countNumber(2));
      //  System.out.println(countNumber(22));
      //  System.out.println(countNumber(111));
      //  System.out.println("###");
      //  System.out.println(countNumber2(22));
      //  System.out.println(countNumber2(111));
      //  System.out.println("===");
      //  System.out.println(countNumber3(22, 1));
      //  System.out.println(countNumber3(111, 1));
        /**
         530 = （53*1）+（5*10+10）+（0*100+100） = 213
         504 = （50*1+1）+（5*10）+（0*100+100） = 201
         514 = （51*1+1）+（5*10+4+1）+（0*100+100） = 207
         */
      // System.out.println(countNumber3(530, 1));
      // System.out.println(countNumber3(504, 1));
      // System.out.println(countNumber3(514, 1));
        Assertions.assertEquals(countNumber3(514, 1), 207);
        Assertions.assertEquals(countNumber3(13, 1), 6);
    }

    private static int countNumber(int n) {
        int count = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
        }
        String str = stringBuilder.toString();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                count++;
        }
        System.out.println("###");
        return count;
    }

    private static int countNumber2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp = temp / 10;
            }
        }

        System.out.println("###");
        return count;
    }

    private static int countNumber3(int n, int x) {
        if (n < 0 || x < 1 || x > 9) {
            return 0;
        }
        int curr, low, temp, high = n, i = 1, total = 0;
        while (high != 0) {
            high = n / (int) Math.pow(10, i); //获取第i位的高位，
            temp = n % (int) Math.pow(10, i); //
            curr = temp / (int) Math.pow(10, i - 1); //获取第i位
            low = temp % (int) Math.pow(10, i - 1); //获取第i位的低位
            if (curr == x) { //等于x
                total += high * (int) Math.pow(10, i - 1) + low + 1;
            } else if (curr < x) { //小于x
                total += high * (int) Math.pow(10, i - 1);
            } else { //大于x
                total += (high + 1) * (int) Math.pow(10, i - 1);
            }
            i++;
        }
        return total;

    }
}
