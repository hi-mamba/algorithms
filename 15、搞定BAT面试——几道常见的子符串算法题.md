
## [原文](https://github.com/Snailclimb/JavaGuide/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/%E6%90%9E%E5%AE%9ABAT%E9%9D%A2%E8%AF%95%E2%80%94%E2%80%94%E5%87%A0%E9%81%93%E5%B8%B8%E8%A7%81%E7%9A%84%E5%AD%90%E7%AC%A6%E4%B8%B2%E7%AE%97%E6%B3%95%E9%A2%98.md)

# 搞定BAT面试——几道常见的子符串算法题.md

## 1. KMP 算法

谈到字符串问题，不得不提的就是 KMP 算法，它是用来解决字符串查找的问题，
可以在一个字符串（S）中查找一个子串（W）出现的位置。KMP 算法把字符匹配的时间复杂度缩小到 O(m+n) ,
而空间复杂度也只有O(m)。因为“暴力搜索”的方法会反复回溯主串，导致效率低下，
而KMP算法可以利用已经部分匹配这个有效信息，保持主串上的指针不回溯，通过修改子串的指针，
让模式串尽量地移动到有效的位置。

具体算法细节请参考：

字符串匹配的KMP算法: <http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html>

从头到尾彻底理解KMP: <https://blog.csdn.net/v_july_v/article/details/7041827>

如何更好的理解和掌握 KMP 算法?: <https://www.zhihu.com/question/21923021>

KMP 算法详细解析: <https://blog.sengxian.com/algorithms/kmp>

图解 KMP 算法: <http://blog.jobbole.com/76611/>

汪都能听懂的KMP字符串匹配算法【双语字幕】: <https://www.bilibili.com/video/av3246487/?from=search&seid=17173603269940723925>

KMP字符串匹配算法1: <https://www.bilibili.com/video/av11866460?from=search&seid=12730654434238709250>

除此之外，再来了解一下BM算法！

BM算法也是一种精确字符串匹配算法，它采用从右向左比较的方法，
同时应用到了两种启发式规则，即坏字符规则 和好后缀规则 ，来决定向右跳跃的距离。
基本思路就是从右往左进行字符匹配，遇到不匹配的字符后从坏字符表和好后缀表找一个最大的右移值，将模式串右移继续匹配。 
《字符串匹配的KMP算法》:<http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html>

## 2. 替换空格

> 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为
We%20Are%20Happy。

实现：

[LongestCommonPrefixDemo](algorithms-java-example/src/main/java/space.mamba/string/ReplaceSpace.java)


## 最长公共前缀

Leetcode: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
   
例子

　 如数组 ["a", "b"]   最长的公共前缀字符串是 “”；

 　如数组 ["aa", "aa"]   最长的公共前缀字符串是 “aa”；

 　如数组 ["abc", "abcd"]   最长的公共前缀字符串是 “abc”。。。

实现：

[LongestCommonPrefixDemo](algorithms-java-example/src/main/java/space.mamba/string/LongestCommonPrefixDemo.java)

参考：<https://blog.csdn.net/Lynn_Baby/article/details/80596410>

Leetcode:

<https://blog.csdn.net/lynn_baby/article/list/3?t=1>

## 4. 回文串

## 4.1. 最长回文串
LeetCode: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。

> 回文串：“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
——百度百科 地址：<https://baike.baidu.com/item/%E5%9B%9E%E6%96%87%E4%B8%B2/1274921?fr=aladdin>

```
示例 1:

输入:
"abccccdd"

输出:
7
```
解释:

我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。


## 4.2. 验证回文串
LeetCode: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
说明：本题中，我们将空字符串定义为有效的回文串。

```
示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
```


## 4.3. 最长回文子串

LeetCode: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 
``` 
示例 1：

输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
```

参考 <https://www.zhihu.com/question/40965749>

参考 <https://segmentfault.com/a/1190000002991199>



## 5. 括号匹配深度

   爱奇艺 2018 秋招 Java： 一个合法的括号匹配序列有以下定义:
   
```   
   空串""是一个合法的括号匹配序列
   如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
   如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
   每个合法的括号序列都可以由以上规则生成。
   例如: "","()","()()","((()))"都是合法的括号序列 对于一个合法的括号序列我们又有以下定义它的深度:
   
   空串""的深度是0
   如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
   如果"X"的深度是x,那么字符串"(X)"的深度是x+1
   例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
   
   输入描述:
   输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
   
   输出描述:
   输出一个正整数,即这个序列的深度。
 ```
 
 示例：
 
 输入:
 
 (())
 
 输出:
 
 2  
 
 
 
## 把字符串转换成整数

剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 
数值为0或者字符串不是一个合法的数值则返回0。 
