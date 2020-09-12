
## [原文](https://www.jianshu.com/p/65c90aa1236d)

## [原文](https://blog.csdn.net/heyue_99/article/details/74833808 )

# AVL树

## 什么是AVL树

   AVL树，是一种平衡(balanced)的二叉搜索树(binary search tree, 简称为BST)。
由两位科学家在1962年发表的论文《An algorithm for the organization of information》当中提出，
作者是发明者G.M. Adelson-Velsky和 E.M. Landis]。它具有以下两个性质：
   
- 任意一个结点的key，比它的左孩子key大，比它的右孩子key小；
- 任意结点的孩子结点之间高度差距最大为1。


本身首先是一棵二叉查找树。带有平衡条件：每个结点的左右子树的高度之差的绝对值（平衡因子）最多为1。

最小不平衡树：距离插入结点最近的，且平衡因子的绝对值大于1的结点为根的子树。

平衡二叉树的构建：在构建二叉排序树的过程中，每当插入一个结点，先检查是否破坏了树的平衡性，
若是，找出最小的不平衡树，通过右旋（顺时针，BF>0）、左旋（逆时针，BF<0），使之成为新的平衡子树。

查找、插入、删除时间复杂度O(log n)。

平衡二叉树的追求的是全局均衡，如在做插入，删除操作时，需要调整整棵树（旋转树），
显然这是费时的，因此希望在做调整时，是局部调整，因此提出了红黑树，这样一种高效的数据结构(也是最变态的一种数据结构)。
 
 
## [AVL树的Java实现](https://www.cnblogs.com/skywang12345/p/3577479.html) 

### [AVL树平衡性调整策略](https://www.jianshu.com/p/cf202771cb6c)