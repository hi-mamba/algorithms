

## [原文](https://www.zhihu.com/question/20545708/answer/58717264)

# 为什么C ++ STL和linux都使用红黑树作为平衡树的实现？


1. 如果插入一个node引起了树的不平衡，AVL和RB-Tree都是最多只需要2次旋转操作，即两者都是O(1)；
但是在删除node引起树的不平衡时，最坏情况下，AVL需要维护从被删node到root这条路径上所有node的平衡性，
因此需要旋转的量级O(logN)，而RB-Tree最多只需3次旋转，只需要O(1)的复杂度。

2. 其次，AVL的结构相较RB-Tree来说更为平衡，在插入和删除node更容易引起Tree的unbalance，
因此在大量数据需要插入或者删除时，AVL需要rebalance的频率会更高。
因此，RB-Tree在需要大量插入和删除node的场景下，效率更高。
自然，由于AVL高度平衡，因此AVL的search效率更高。

3. map的实现只是折衷了两者在search、insert以及delete下的效率。
总体来说，RB-tree的统计性能是高于AVL的
 
 
> 红黑树除了旋转有可能还需要由下而上修正节点颜色，旋转和改颜色开销差不多的。 
