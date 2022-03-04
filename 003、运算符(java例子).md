## [原文](https://www.jianshu.com/p/8cf5af30f245)

# 运算符（java 例子）
 
Java运算符大致分为逻辑运算符(&&,||,！)、算数运算符（+, -, *, / ,+=）、位运算符（^,|,&）、其他运算符（三元运算符）

> 凡位运算符都是把值先转换成二进制再进行后续的处理

## &（按位与）

&按位与的运算规则是将两边的数转换为二进制位，然后运算最终值
> 运算规则即(两个为真才为真)1&1=1 , 1&0=0 , 0&1=0 , 0&0=0

```java
    public static void main(String[] args) {
        System.out.println(3 & 1);
        System.out.println(7 & 5);
    }
```
- [按位与例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/BitwiseAndExample01.java)


## &&（逻辑与）

&&逻辑与也称为短路逻辑与，先运算&&左边的表达式，一旦为假，后续不管多少表达式，均不再计算，一个为真，
再计算右边的表达式，两个为真才为真。

- [逻辑与例子](//algorithms-java-example/src/main/java/space.mamba/logic_operation/LogicAndExample01.java)


## |（按位或）

|按位或和&按位与计算方式都是转换二进制再计算，不同的是运算规则(一个为真即为真)1|0 = 1 , 1|1 = 1 , 0|0 = 0 , 0|1 = 1

- [例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/BitwiseOrExample01.java)

## ||（逻辑或）

逻辑或||的运算规则是一个为真即为真，后续不再计算，一个为假再计算右边的表达式。

- [逻辑或例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/LogicalOrExample01.java)


## ^（异或运算符）

^异或运算符顾名思义，异就是不同，其运算规则为1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0

- [异或例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/XOR_Example01.java)


## <<（左移运算符）

意思为某个数的二进制位往左挪两位，右边补0。正数左边第一位补0，负数补1，等于乘于2的n次方

- [左移运算符例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/LeftShiftOperator.java)

## >>（右移运算符）

凡位运算符都是把值先转换成二进制再进行后续的处理

意思为某个数的二进制位往右边挪两位，正数左边第一位补0，负数补1，等于除于2的n次方，结果为1


- [右移运算符例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/RightShiftOperator.java)


## ~（取反运算符）

取反就是1为0,0为1,

5的二进制位是0000 0101，取反后为1111 1010，值为-6

- [取反运算符例子](/algorithms-java-example/src/main/java/space.mamba/logic_operation/InverseOperatorExample01.java)



## >>>（无符号右移运算符）




