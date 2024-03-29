
## [原文](https://blog.csdn.net/baiye_xing/article/details/78428561)

# 剑指offer

## 一、引言

《剑指offer》可谓是程序猿面试的神书了，在面试中帮了我很多，
大部分面试的算法题都会遇到原题或者是类似的题。

但是书上的代码都是C版的，我在这里整理了一份Java版的代码供大家学习参考，
这些代码我都是在OJ上跑过全AC的，所以正确性你大可放心。

## 二、目录

- 1、赋值运算函数

  - [例子](/algorithms-java-example/src/main/java/space.mamba/coding/interviews/AssignmentOperatorFunctionDemo01.java)

- 2、单例设计模式
 
  - [例子](/algorithms-java-example/src/main/java/space.mamba/coding/interviews/SingletonDemo02.java)     

- 3、二维数组中查找目标值（二维数组中的查找）

  - [例子](/algorithms-java-example/src/main/java/space.mamba/coding/interviews/P44_FindInPartiallySortedMatrix.java)

- 4、替换字符串中的空格

    - [例子](/algorithms-java-example/src/main/java/space.mamba/coding/interviews/DeleteWhitespace.java)

- 5、[从尾到头打印链表](05、从尾到头打印链表.md)
     
- 6、[由前序和中序遍历重建二叉树]()
    - [例子](/algorithms-java-example/src/main/java/space.mamba/coding/interviews/BinaryTreeNode.java)

- 7、[用两个栈实现队列](07、用两个栈实现队列.md)

- 8、[求旋转数组的最小数字](08、求旋转数组的最小数字.md)

- 9、[斐波那契数列的第n项（青蛙跳台阶）](09、斐波那契数列的第n项（青蛙跳台阶）.md)

- 10、[二进制中1的个数](10、求二进制数中1的个数.md)

- 11、[数值的整数次方](11、数值的整数次方.md)

- 12、[打印1到最大的n位数](12、打印1到最大的n位数.md)

- 13、[O(1)时间删除链表节点](13、O(1)时间删除链表节点.md)

- 14、[使数组中的奇数位于偶数前面](14、使数组中的奇数位于偶数前面.md)

- 15、[找链表中倒数第K个节点](15、找链表中倒数第K个节点.md)

- 16、[输出反转后的链表](16、输出反转后的链表.md)

- 17、[合并两个有序链表](17、合并两个有序链表.md)

- 18、[判断二叉树A中是否包含子树B](18、判断二叉树A中是否包含子树B.md)

- 19、[二叉树的镜像]()

- 20、[顺时针打印矩阵](20、顺时针打印矩阵.md)

- 21、[包含min函数的栈](21、包含min函数的栈.md)

- 22、[判断一个栈是否是另一个栈的弹出序列](22、判断一个栈是否是另一个栈的弹出序列.md)

- 23、[层序遍历二叉树](23、1.层序遍历二叉树.md)

- 24、[后序遍历二叉搜索树](24、后序遍历二叉搜索树.md)

- 25、[二叉树中和为某值的路径](25、二叉树中和为某值的路径.md)

- 26、[复杂链表的复制]()

- 27、[二叉搜索树转换为双向链表]()

- 28、[打印字符串中所有字符的排列](38、字符串的排列.md)

- 29、[数组中出现次数超过一半的数字]()

- 30、[找出最小的K个数](30、找出最小的K个数.md)

- 31、[连续子数组的最大和](31、连续子数组的最大和.md)

- 32、[从1到整数n中1出现的次数](32、从1到整数n中1出现的次数.md)

- 33、[把数组中的数排成一个最小的数](33、把数组中的数排成一个最小的数.md)

- 34、[求第N个丑数](34、求第N个丑数.md.md)

- 35、[第一个出现一次的字符](35、第一个出现一次的字符.md)

- 36、[数组中逆序对的个数](36、数组中逆序对的个数.md)

- 37、[两个链表的第一个公共节点](37、两个链表的第一个公共节点.md)

- 38、[数字在排序数组中出现的次数](38、数字在排序数组中出现的次数.md)

- 39、[二叉树的深度](39、二叉树的深度.md)

- 40、[数组中只出现一次的两个数，而其他数都出现两次](40、数组中只出现一次的两个数，而其他数都出现两次.md)

- 41、[和为s的连续正数序列](41、和为s的连续正数序列.md)

- 42、[翻转字符串](42、翻转字符串.md)

- 43、[n个骰子的点数及出现的概率](43、n个骰子的点数及出现的概率.md)

- 44、[扑克牌的顺子]()

- 45、[圆圈中最后剩下的数](45、圆圈中最后剩下的数.md)

- 46、[1+2+3+…+n的和](46、1+2+3+…+n的和.md)

- 47、[不用加减乘除做加法](47、不用加减乘除做加法.md)

- 48、[不能被继承的类](48、不能被继承的类.md)

- 49、[字符串转换为整数](49、字符串转换为整数.md)

- 50、[树中两个节点的最低公共祖先](50、树中两个节点的最低公共祖先.md)

- 51、[找出重复的数](51、找出重复的数.md)

- 52、[构建乘积数组](52、构建-乘积数组.md)

- 53、[正则表达式匹配](53、正则表达式匹配.md)

- 54、[表示数值的字符串](54、表示数值的字符串.md)

- 55、[字符流中第一个不重复的字符](55、字符流中第一个不重复的字符.md)

- 56、[链表中环的入口节点]()

- 57、[删除链表中重复的节点]()

- 58、[二叉树的下一个节点](58、二叉树的下一个节点.md)

- 59、[对称的二叉树]()

- 60、[按之字形顺序打印二叉树](60、按之字形顺序打印二叉树.md)

- 61.1、[把二叉树打印成多行](61、I-从上到下打印二叉树.md)

- 61.2、[把二叉树打印成多行](61、II-把二叉树打印成多行.md)

- 62、[序列化二叉树](62、序列化二叉树.md)

- 63、[二叉搜索树的第K个节点](63、二叉搜索树的第k大节点.md)

- 64、[数据流中的中位数](64、数据流中的中位数.md)

- 65、[滑动窗口的最大值]()

- 66、[矩阵中的路径]()

- 67、[机器人的运动范围]()

 