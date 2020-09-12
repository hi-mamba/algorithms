

## [原文1](https://blog.csdn.net/zeb_perfect/article/details/53333606)

# 分组Top N问题(一) - java实现Top n算法基础

## 前言：
在分析MapReduce、Hive、Redis和Storm、Spark等工具实现分组Top n问题前，我
们先看下java最原始实现Top的方法有哪些，为后面奠定些基础，这也是我要整理成一个系列的原因。

对于Top n问题，这里根据数据特点用合并法、快排过程法、大小顶堆和PriorityQueue固定队列四种方式来实现。

## 合并法：
数据描述：这种方法适用于几个数组有序的情况，来求Top k。

实现描述：采用Merge的方法，设定一个数组下标扫描位置记录临时数组和top结果数组，
然后从临时数组记录下标开始遍历所有数组并比较大小，将最大值存入结果数组，
最大值对应所在数组下标加一存入临时数组，以使其从下位开始遍历，时间复杂度为O(k*m)。(m:为数组的个数）。

## 具体实现

```java

package fjdm;
import java.util.ArrayList;
import java.util.List;
/**
 * 已知几个递减有序的m个数组，求这几个数据前k大的数
 * a[4,3,2,1],b[6,5,3,1] -> result[6,5,4]
 * @author 张恩备
 * @date 2016-11-25 上午10:57:03
 */
public class TopKByMerge{
 public static int[] getTopK(List<List<Integer>>input,int k){
	int index[]=new int[input.size()];//保存每个数组下标扫描的位置;
	int result[]=new int[k];
	for(int i=0;i<k;i++){
	   int max=Integer.MIN_VALUE;
	   int maxIndex=0;
	   for(int j=0;j<input.size();j++){
		   if(index[j]<input.get(j).size()){
				if(max<input.get(j).get(index[j])){
					max=input.get(j).get(index[j]);
					maxIndex=j;
				}
		   }
	   }
	   if(max==Integer.MIN_VALUE){
		   return result;
	   }
	   result[i]=max;
	   index[maxIndex]+=1;
	   
	}
	return result;
 } 
 public static void main(String[] args) {
	 List<Integer> a = new ArrayList<Integer>();
	 a.add(4);
	 a.add(3);
	 a.add(2);
	 a.add(1);
	 List<Integer> b = new ArrayList<Integer>();
	 b.add(6);
	 b.add(5);
	 b.add(3);
	 b.add(1);
	 List<List<Integer>> ab = new ArrayList<List<Integer>>();
	 ab.add(a);
	 ab.add(b);
	 int r[] = getTopK(ab, 3);
	 for (int i = 0; i < r.length; i++) {
		System.out.println(r[i]);
	}
}
}

```

## 快排过程法：

数据描述：适用于无序单个数组，快排过程法利用快速排序的过程来求Top k。

实现步骤：根据快排规则，选择一个数为基准（代码是以最后一个数）分化数据，
并记录基准数最后的落点下标，最后判断下标和k-1值大小（下标从0开始），不相等就继续朝k-1数量方向分化：

下标小于k-1，对下标右侧（partion，end）继续二分；

下标大于k-1，对下标左侧（first，partion）继续二分；

直到k个数为top，但这k个数并没有顺序。

具体实现：


```java
package fjdm;
 
/**
 * 利用快速排序的过程来求最小的k个数
 * @author 张恩备
 * @date 2016-11-25 上午11:59:45
 */
public class TopK{
	int partion(int a[],int first,int end){
		  int i=first;
		  int main=a[end];
		  for(int j=first;j<end;j++){
				 if(a[j]<main){
					 int temp=a[j];
					 a[j]=a[i];
					 a[i]=temp;
					 i++;
				 }
		  }
		  a[end]=a[i];
		  a[i]=main;
		  return i;	 
	}
	void getTopKMinBySort(int a[],int first,int end,int k){
		if(first<end){
			 int partionIndex=partion(a,first,end);
			 if(partionIndex==k-1)return;
			 else if(partionIndex>k-1)getTopKMinBySort(a,first,partionIndex-1,k);
			 else getTopKMinBySort(a,partionIndex+1,end,k);
		}
	}
public static void main(String []args){
		int a[]={2,20,3,7,9,1,17,18,0,4};
		int k=6;
		new TopK().getTopKMinBySort(a,0,a.length-1,k);
		for(int i=0;i<k;i++){
			System.out.print(a[i]+" ");
		}
	}
}

```

## 采用小顶堆或者大顶堆：
数据描述：求最大K个采用小顶堆，而求最小K个采用大顶堆。

实现步骤：根据数据前K个建立K个节点的小顶堆，在后面的N-K的数据的扫描中，

如果数据大于小顶堆的根节点，则根节点的值覆为该数据，并调节节点至小顶堆。

如果数据小于或等于小顶堆的根节点，小根堆无变化。

求最小K个跟这求最大K个类似。时间复杂度O(nlogK)(n:数据的长度)，特别适用于大数据的求Top K。

具体实现：

```java
package fjdm;
 
/**
 * 求前面的最大K个 解决方案：小根堆 (数据量比较大（特别是大到内存不可以容纳）时，偏向于采用堆)
 * @author 张恩备
 * @date 2016-11-25 下午12:15:36
 */
public class TopKByHeap {
	/**
	 * 创建k个节点的小根堆
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	int[] createHeap(int a[], int k) {
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = a[i];
		}
		for (int i = 1; i < k; i++) {
			int child = i;
			int parent = (i - 1) / 2;
			int temp = a[i];
			while (parent >= 0 &&child!=0&& result[parent] >temp) {
				result[child] = result[parent];
				child = parent;
				parent = (parent - 1) / 2;
			}
			result[child] = temp;
		}
		return result;
 
	}
 
	void insert(int a[], int value) {
		 a[0]=value;
		 int parent=0;
		 
		 while(parent<a.length){
			 int lchild=2*parent+1;
			 int rchild=2*parent+2;
			 int minIndex=parent;
			 if(lchild<a.length&&a[parent]>a[lchild]){
				 minIndex=lchild;
			 }
			 if(rchild<a.length&&a[minIndex]>a[rchild]){
				 minIndex=rchild;
			 }
			 if(minIndex==parent){
				 break;
			 }else{
				 int temp=a[parent];
				 a[parent]=a[minIndex];
				 a[minIndex]=temp;
				 parent=minIndex;
			 }
		 }
	}
 
	int[] getTopKByHeap(int input[], int k) {
		int heap[] = this.createHeap(input, k);
		for(int i=k;i<input.length;i++){
			if(input[i]>heap[0]){
				this.insert(heap, input[i]);
			}
		}
		return heap;
	}
 
	public static void main(String[] args) {
		int a[] = { 4, 3, 5, 1, 2,8,9,10};
		int result[] = new TopKByHeap().getTopKByHeap(a, 3);
		for (int temp : result) {
			System.out.println(temp);
		}
	}
}

```

## PriorityQueue优先队列：
数据描述：PriorityQueue是从JDK1.5开始提供的新的数据结构接口，它是一种基于优先级堆的极大优先级队列。
优先级队列是不同于先进先出队列的另一种队列。每次从队列中取出的是具有最高优先权的元素。
如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，
字符串则按字典序排列（参阅 Comparable），也可以根据 Comparator 来指定，
这取决于使用哪种构造方法。优先级队列不允许 null 元素。
依靠自然排序的优先级队列还不允许插入不可比较的对象（这样做可能导致 ClassCastException）。

实现步骤：PriorityQueue构造固定容量的优先队列，模拟大顶堆，这种队列本身数组实现，无容量限制，
可以指定队列长度和比较方式，然后将数据依次压入，当队列满时会poll出小值，最后需要注意的是，
priorityQueue本身遍历是无序的，可以使用内置poll()方法，每次从队首取出元素。

具体实现：

```java
package fjdm;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
/**
 * 固定容量的优先队列，模拟大顶堆，用于解决求topN小的问题
 * @author 张恩备
 * @date 2016-11-25 下午02:29:31
 */
public class FixSizedPriorityQueue<E extends Comparable> {
	private PriorityQueue<E> queue;
	private int maxSize; // 堆的最大容量
 
	public FixSizedPriorityQueue(int maxSize) {
		if (maxSize <= 0)
			throw new IllegalArgumentException();
		this.maxSize = maxSize;
		this.queue = new PriorityQueue(maxSize, new Comparator<E>() {
			public int compare(E o1, E o2) {
				// 生成最大堆使用o2-o1,生成最小堆使用o1-o2, 并修改 e.compareTo(peek) 比较规则
				return (o2.compareTo(o1));
			}
		});
	}
 
	public void add(E e) {
		if (queue.size() < maxSize) { // 未达到最大容量，直接添加
			queue.add(e);
		} else { // 队列已满
			E peek = queue.peek();
			if (e.compareTo(peek) < 0) { // 将新元素与当前堆顶元素比较，保留较小的元素
				queue.poll();
				queue.add(e);
			}
		}
	}
 
	public List<E> sortedList() {
		List<E> list = new ArrayList<E>(queue);
		Collections.sort(list); // PriorityQueue本身的遍历是无序的，最终需要对队列中的元素进行排序
		return list;
	}
 
	public static void main(String[] args) {
		final FixSizedPriorityQueue pq = new FixSizedPriorityQueue(10);
		Random random = new Random();
		int rNum = 0;
		System.out.println("100 个 0~999 之间的随机数：-----------------------------------");
		for (int i = 1; i <= 100; i++) {
			rNum = random.nextInt(1000);
			System.out.println(rNum);
			pq.add(rNum);
		}
		System.out.println("PriorityQueue 本身的遍历是无序的：-----------------------------------");
		Iterable<Integer> iter = new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return pq.queue.iterator();
			}
		};
		for (Integer item : iter) {
			System.out.print(item + ", ");
		}
		System.out.println();
		System.out.println("PriorityQueue 排序后的遍历：-----------------------------------");
		/*
		 * for (Integer item : pq.sortedList()) { System.out.println(item); }
		 */
		// 或者直接用内置的 poll() 方法，每次取队首元素（堆顶的最大值）
		while (!pq.queue.isEmpty()) {
			System.out.print(pq.queue.poll() + ", ");
		}
	}
}

```
 