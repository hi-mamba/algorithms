package space.mamba.leetcode.algorithms;

/**
 * @author byte mamba
 * @date 2019/11/24
 * <pre>
 *
 *      https://leetcode.com/problems/defanging-an-ip-address/
 *      1108. Defanging an IP Address
 * </pre>
 */
public class No1108_DefangingIPAddress {

    public static void main(String[] args) {

        No1108_DefangingIPAddress obj = new No1108_DefangingIPAddress();
        String result = obj.defangIPaddr("1.1.1.1");
        System.out.println(result);

        result = obj.defangIPaddr("255.100.50.0");
        System.out.println(result);
    }

    public String defangIPaddr(String address) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] strArray = address.split("\\.");
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
            if (i < strArray.length - 1) {
                stringBuilder.append("[.]");
            }
        }
        return stringBuilder.toString();
    }
}
