/**
 *  不同于合并两个链表，合并K个链表不能用两个指针来比较当前结点的值大小。
 *  但合并的思路还是一样，每次需要取出K个链表当前结点的最小值，这样需要维护一个大小为K的最小堆
 *  题目地址：https://leetcode.com/problems/merge-k-sorted-lists/
**/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        //Java中堆可以用优先队列来实现，这里使用的其构造函数指定了堆的容量和比较器
        PriorityQueue<ListNode> minHeap = new PriorityQueue<> (lists.length, new ListNodeComparator());
        for(ListNode l : lists) {  //所有K个链表的首结点装堆
            if(l != null)  //优先队列不允许有null元素
                minHeap.add(l);
        }
        
        ListNode pHead = new ListNode(0);  //方便构造返回的链表
        ListNode p = pHead;
        while(!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();  //取优先队列的头，即小堆顶
            p.next = minNode;  //插入结果链表
            p = p.next;  //依次更新遍历指针
            minNode = minNode.next;
            if(minNode != null) minHeap.add(minNode);  //要把已插入结果链表结点的下一个结点装堆，
        }
        return pHead.next;
    }
    
    //实现Comparator接口的比较器，指定两链表结点的排序方法。
    public class ListNodeComparator implements Comparator<ListNode> {
        //覆盖了Comparator的compare方法，根据第一个参数小于、等于、大于第二个参数依次返回负、零、正。
        public int compare(ListNode l1, ListNode l2) {
            if( l1.val < l2.val) return -1;
            else if( l1.val == l2.val) return 0;
            else return 1;
        }
    }
}