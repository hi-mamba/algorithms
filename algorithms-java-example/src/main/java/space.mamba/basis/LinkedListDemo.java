package space.mamba.basis;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author pankui
 * @date 25/04/2018
 * <pre>
 *
 *  单向链表
 *
 *  链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的。
 *
 *  链表由一系列节点组成，这些节点不必在内存中相连。每个节点由数据部分Data和链部分Next，Next指向下一个节点，
 *
 *  这样当添加或者删除时，只需要改变相关节点的Next的指向，效率很高。
 *
 *
 *  实现一个 list
 *
 * </pre>
 */
public class LinkedListDemo implements List {

    /**
     * 头指针
     */
    private Node<Object> head;

    /**
     * 当前结点对象
     */
    private Node tail;

    /**
     * 结点个数
     */
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {

        if (head == null) {
            head = new Node<>(null, o);
            size++;
            return true;
        }
        Node<Object> node = new Node<>(o);
        Node<Object> temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        checkElementIndex(index);

        Node temp = head;
        for (int i = 0 ;i < index;i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {

        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    private void print() {

        for (Node p = head; p != null; p = p.getNext()) {
            System.out.print(p.getData() + " ");
        }

    }

    public static void main(String[] args) {

        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.add("a");
        linkedListDemo.add("d");
        linkedListDemo.add("f");
        linkedListDemo.add("g");
        linkedListDemo.add("h");

        linkedListDemo.print();

        System.out.println("");

        System.out.println("size:"+linkedListDemo.size());

        System.out.println("is empty:"+linkedListDemo.isEmpty());

        Object getResult = linkedListDemo.get(0);
        System.out.println(getResult);

        //101
        //
        System.out.println(5 >> 2);
    }
}

