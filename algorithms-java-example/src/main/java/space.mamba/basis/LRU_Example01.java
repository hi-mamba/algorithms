package space.mamba.basis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author meta a
 * @date 2022/3/9
 * <pre>
 *      LinkedHashMap已经实现了LRU缓存淘汰算法
 *
 * </pre>
 */
public class LRU_Example01 {


    //LinkedHashMap会自动扩容，如果想 实现限制容量删除队列顶端元素，
    //需要重写removeEldestEntry()方法，当map里面的元素个数大于了缓存最大容量，
    //删除链表的顶端元素。


    public static void main(String[] args) {
        LRULinkedHashMap obj = new LRULinkedHashMap(5);

        for (int i = 0; i < 10; i++) {
            obj.put(i, i);
        }
        System.out.println(obj);
    }
}

class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {


    private int capacity;

    LRULinkedHashMap(int capacity) {
        // 初始大小，0.75是装载因子，true是表示按照访问时间排序
        super(capacity, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }
}
