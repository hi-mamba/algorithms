

# 递归 recursion


## 举个例子

计算 n! 

n!= 1 * 2 * 3 * n

```java
long factorial(long n) {
  // 递归的终止条件
  if (n <= 1) {
        return 1;
      }
   return n * factorail(n - 1);
}
```
- 递归执行顺序

factorial(6)

6 * factorial(5)

6 * (5 * factorial(4))

6 * (5 * (4 * factorial(3))))

6 * (5 * (4 * (3 * factorial(2)))))

6 * (5 * (4 * (3 * (2 * factorial(1)))))

6 * (5 * (4 * (3 * (2 * 1))))

6 * (5 * (4 * (3 * 2)))

6 * (5 * (4 * 6))

6 * (5 * 24)

6 * 120

720


## 结论

对于递归我们应该知道的是，方法的调用其实是入栈与出栈

> 回溯

## [动画演示](https://www.mathwarehouse.com/programming/gifs.php)

