[动态规划法（八）最大子数组问题（maximum subarray problem）](https://segmentfault.com/a/1190000015205978)

# Kadane算法

- 最大子数组问题（maximum subarray problem）

- 

Kadane算法的简单想法就是寻找所有连续的正的子数组（max_ending_here就是用来干这事的），
同时，记录所有这些连续的正的子数组中的和最大的连续数组。
每一次我们得到一个正数，就将它与max_so_far比较，如果它的值比max_so_far大，则更新max_so_far的值。

