package space.mamba.logic_operation;

/**
 * @author pankui
 * @date 2019-04-06
 * <pre>
 *  Logic and  &&（逻辑与）
 * </pre>
 */
public class LogicAndExample01 {

    public static void main(String[] args) {
        String str = null;

        if (str != null && (100 / 0 == 0)) {
            System.out.println("&&左边一旦为假，右边就不在计算");
        } else {
            System.out.println("100 / 0 == 0被计算会抛异常");
        }
    }
}
