import java.util.LinkedHashMap;

/**
	题目地址：https://leetcode.com/problems/lru-cache/
	实现访问策略为LRU(最近最少使用）的Cache
**/
public class LRUCache {
	/**
		使用LinkedHashMap (链接哈希映射表），若按照插入顺序，则是顺序迭代访问的。
		要实现LRU,则排序模式应该为访问顺序，即构造函数的排序模式应为true
		访问顺序对映射表条目进行迭代时，每次调用get或put，受影响的条目将从当前位置删除，放到链表尾部。(最近已使用的）
	**/
    private Map<Integer,Integer> cache;
    private int capacity;
    
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer,Integer> (capacity, 1, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        return cache.get(key);
    }
    
    public void set(int key, int value) {
		//当在表中找不到元素项且表已满，则需要删除最近少使用的元素
        if(!cache.containsKey(key) && cache.size() == capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }
}