package space.mamba.basis;

import java.util.HashMap;

/**
 * @author meta a
 * @date 2022/3/9
 * <pre>
 *  使用双向链表结构+HashMap实现
 *
 *  其实就是linkedHashMap的实现
 * </pre>
 */
public class LRUCache<K, V> {


    //双向链表: 删除操作的时间复杂度仍是O(n)，那么如何使其复杂度降为O(1)？我们可以自定义双向链表的结构
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(5);
        for (int i = 0; i < 10; i++) {
            obj.put(i, i);
        }
        System.out.println(obj.map);
    }

    private int size;

    private HashMap<K, Node> map;

    private Node head;

    private Node tail;

    LRUCache(int size) {
        this.size = size;
        map = new HashMap<>();
    }

    /**
     * 添加元素
     * 1.元素存在，将元素移动到队尾
     * 2.不存在，判断链表是否满。
     * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
     * 如果不满，放入队尾元素，更新哈希表
     */
    public void put(K key,V value) {
        Node node = map.get(key);
        if (node != null) {
            //更新值
            node.v = value;
            moveNodeToTail(node);
        }else {
            Node newNode = new Node(key, value);
            if (map.size() == size) {
                Node delHead = removeHead();
                map.remove(delHead.k);
            }
            addLast(newNode);
            map.put(key, newNode);
        }
    }

    public void addLast(Node newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //连接新节点
            tail.next = newNode;
            newNode.pre = tail;
            //更新尾节点指针为新节点
            tail = newNode;
        }
    }


    public V get(K key) {
        Node node = map.get(key);
        if (node != null) {
            moveNodeToTail(node);
            return node.v;
        }
        return null;
    }

    public void moveNodeToTail(Node node) {
        if (tail == node) {
            return;
        }
        if (head == node) {
            head = node.next;
            head.pre = null;
        }else {
            node.pre.next = head.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        node.next = null;
        tail.next = node;
        tail = node;

    }


    public Node removeHead() {
        if (head == null) {
            return null;
        }
        Node res = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = res.next;
            head.pre = null;
            res.next = null;
        }
        return res;
    }
    class Node {
        K k;
        V v;
        Node pre;
        Node next;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            // System.out.println("k=" + k + " v=" + v);
            return "k=" + k + ", v=" + v;
        }
    }
}
