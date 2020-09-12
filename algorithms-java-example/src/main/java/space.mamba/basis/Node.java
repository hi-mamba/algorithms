package space.mamba.basis;

/**
 * @author pankui
 * @date 25/04/2018
 * <pre>
 *  结点类
 * </pre>
 */

public class Node<E> {

    /**
     * 指针域
     */
    private Node<E> next;
    /**
     *  数据域
     */
    private E data;

    public Node() {
    }

    /**
     * 头结点的构造方法
     *
     * @param data
     */
    public Node(E data) {
        this.data = data;
    }

    /**
     * 非头结点的构造方法
     */
    public Node(Node<E> next, E data) {
        this.next = next;
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
