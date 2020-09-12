package space.mamba.coding.interviews;

/**
 * @author pankui
 * @date 2019-01-15
 * <pre>
 *    原文:https://www.jianshu.com/p/3f024a03176b
 *
 *    赋值运算符函数
 *
 *    题目要求：
 *
 *    为自定义类添加赋值运算符函数，考察一些细节点的书写。
 *
 *
 *      将返回值类型声明为该类型的引用
 *      把传入的参数类型声明为常量引用
 *      释放实例自身已有的内存
 *      判断传入的参数和当前的实例是不是同一个实例
 * </pre>
 */
public class AssignmentOperatorFunctionDemo01 {

    /**
     * 赋值运算符函数
     * <p>
     * 1.对于传入的参数，不应该被修改，使用final修饰；
     * 2.如果两个对象相同或值相等，不进行操作，直接返回；
     * 3.返回值最好为this，这样可以使赋值链接起来。
     * 一个缺点：此赋值从左到右进行，a=b=c等价于a=c，b不会被赋值；
     * 而如果是String的=运算，a,b都会被赋成c的值。
     */
    public static void main(String[] args) {
        MyString s1 = new MyString("a");
        MyString s2 = new MyString("b");
        MyString s3 = new MyString("c");
        System.out.println(s1.assign(s2).assign(s3));
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        System.out.println("s3:" + s3);

    }


    public static class MyString {
        private String data;

        public MyString(String data) {
            this.data = data;
        }

        public MyString assign(final MyString another) {
            if (this == another || this.data.equals(another.data)) {
                return this;
            }
            else {
                this.data = another.data;
                return this;
            }
        }

        @Override
        public String toString() {
            return "MyString{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

}
